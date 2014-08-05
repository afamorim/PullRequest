package br.com.vortice.pullRequest.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Example;

import br.com.vortice.pullRequest.entity.ConfiguracaoEntity;


public class ConfiguracaoDAO extends GenericDAO<ConfiguracaoEntity, Long> {

	public List<ConfiguracaoEntity> findByFilter(ConfiguracaoEntity aConfiguracao) {
		Criteria c = getSession().createCriteria(getEntityClass());
		c.add(Example.create(aConfiguracao).enableLike());
		return c.list();
	}
}
