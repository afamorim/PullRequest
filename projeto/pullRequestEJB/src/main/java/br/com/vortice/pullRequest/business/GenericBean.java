package br.com.vortice.pullRequest.business;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.vortice.core.abstracao.Entidade;
import com.vortice.core.ejb.GenericEJBBean;

@Stateless
public class GenericBean<E extends Entidade, ID extends Serializable> extends GenericEJBBean<E, ID> {

	@PostConstruct
	public void initBean(){
		getDAO().setEntityManager(entityManager);
	}
	
	@PersistenceContext(unitName="treinamentoPU")
	private EntityManager entityManager;

	protected EntityManager getEntityManager() {
		return entityManager;
	}
}
