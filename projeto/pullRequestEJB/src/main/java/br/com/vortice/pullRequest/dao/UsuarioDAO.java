package br.com.vortice.pullRequest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;

import br.com.vortice.pullRequest.entity.UsuarioEntity;


public class UsuarioDAO extends GenericDAO<UsuarioEntity, Long> {

	public List<UsuarioEntity> findByFilter(UsuarioEntity aUsuario) {
		Criteria c = getSession().createCriteria(getEntityClass());
		c.add(Example.create(aUsuario).enableLike());
		return c.list();
	}
	
	public UsuarioEntity findLoginSenha(UsuarioEntity aUsuario) {
		Criteria c = getSession().createCriteria(getEntityClass());
		c.add(Restrictions.eq("login", aUsuario.getLogin()));
		c.add(Restrictions.eq("senha", aUsuario.getSenha()));
		return (UsuarioEntity)c.uniqueResult();
	}
}
