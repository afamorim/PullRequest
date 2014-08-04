package br.com.vortice.pullRequest.dao;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.criterion.Restrictions;

import br.com.vortice.pullRequest.entity.PerfilEntity;

public class PerfilDAO extends GenericDAO<PerfilEntity, Long> {

	@Override
	public PerfilEntity findByPrimaryKey(PerfilEntity e) {
		Criteria criteria = getSession().createCriteria(PerfilEntity.class);
		criteria.setFetchMode("urls", FetchMode.JOIN);
		criteria.add(Restrictions.eq("codigo", e.getCodigo()));
		return (PerfilEntity)criteria.uniqueResult();
	}
}
