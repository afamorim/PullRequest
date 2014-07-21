package br.com.vortice.treinamento.web.faces;

import javax.ejb.EJB;

import br.com.vortice.pullRequest.business.UsuarioBean;
import br.com.vortice.pullRequest.entity.Usuario;

import com.vortice.web.view.BasePageBean;

public class LoginFaces extends BasePageBean {

	@EJB
	private UsuarioBean	usuarioBean;
	
	private Usuario		usuarioLogado;
	
	public LoginFaces(){
		usuarioLogado = new Usuario();
	}
	
	public void login(){
		
	}

	public Usuario getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(Usuario usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}