package br.com.vortice.pullRequest.business;

import javax.ejb.Stateless;

import br.com.vortice.pullRequest.dao.UsuarioDAO;

@Stateless
public class UsuarioBean extends GenericBean {
	
	public UsuarioBean(){
		setDAO(new UsuarioDAO());
	}
}