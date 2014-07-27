package br.com.vortice.pullRequest.business;

import java.util.List;

import javax.ejb.Stateless;

import br.com.vortice.pullRequest.dao.UsuarioDAO;
import br.com.vortice.pullRequest.entity.UsuarioEntity;

@Stateless
public class UsuarioBean extends GenericBean<UsuarioEntity, Long> {
	
	public UsuarioBean(){
		setDAO(new UsuarioDAO());
	}
	
	public List<UsuarioEntity> findByFilter(UsuarioEntity aUsuario){
		return getUsuarioDAO().findByFilter(aUsuario);
	}
	
	public UsuarioDAO getUsuarioDAO(){
		return (UsuarioDAO)getDAO();
	}
}