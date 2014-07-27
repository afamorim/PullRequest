package br.com.vortice.pullRequest.dao;

import org.hibernate.Session;

import com.vortice.core.abstracao.Entidade;
import com.vortice.core.persistencia.GenericJPADAO;

public class GenericDAO<E extends Entidade, ID> extends GenericJPADAO<E, ID> {

	public Session  getSession(){
    	return (Session) getEntityManager().getDelegate();
    }
}