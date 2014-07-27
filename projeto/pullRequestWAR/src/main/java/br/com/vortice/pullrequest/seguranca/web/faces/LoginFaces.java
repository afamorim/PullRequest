package br.com.vortice.pullrequest.seguranca.web.faces;

import javax.ejb.EJB;

import br.com.vortice.pullRequest.business.UsuarioBean;
import br.com.vortice.pullRequest.entity.UsuarioEntity;

import com.vortice.web.view.BasePageBean;

public class LoginFaces extends BasePageBean {

	@EJB
	private UsuarioBean	usuarioBean;
	
	private UsuarioEntity		usuarioLogado;
	
	public LoginFaces(){
		usuarioLogado = new UsuarioEntity();
	}
	
	public void login(){
		
	}

	public UsuarioEntity getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(UsuarioEntity usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}