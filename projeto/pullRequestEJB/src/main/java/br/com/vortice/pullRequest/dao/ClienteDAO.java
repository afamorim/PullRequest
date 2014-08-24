package br.com.vortice.pullRequest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import br.com.vortice.pullRequest.entity.ClienteEntity;

import com.vortice.core.util.VorticeUtil;

public class ClienteDAO extends GenericDAO<ClienteEntity, Long>{

	@SuppressWarnings("unchecked")
	public List<ClienteEntity> findByFilter(ClienteEntity filter){
		Criteria c = getSession().createCriteria(getEntityClass());
		
		if(!VorticeUtil.isEmpty(filter.getNome())){
			c.add(Restrictions.ilike("nome", filter.getNome(), MatchMode.ANYWHERE));
		}
		if(!VorticeUtil.isEmpty(filter.getTelefone())){
			c.add(Restrictions.ilike("telefone", filter.getTelefone(), MatchMode.ANYWHERE));
		}
		if(!VorticeUtil.isEmpty(filter.getEmail())){
			c.add(Restrictions.ilike("email", filter.getEmail(), MatchMode.ANYWHERE));
		}
		
		c.addOrder(Order.asc("nome"));
		
		return c.list();
	}
}
