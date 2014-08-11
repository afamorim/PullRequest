package br.com.vortice.pullrequest.seguranca.web.faces;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vortice.pullRequest.business.UsuarioBean;
import br.com.vortice.pullRequest.entity.UsuarioEntity;
import br.com.vortice.pullRequest.util.PullRequestConstantes;

import com.vortice.web.view.BasePageBean;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class LoginFaces extends BasePageBean {

	@EJB
	private UsuarioBean		usuarioBean;
	
	private UsuarioEntity	usuarioLogado;
	
	public LoginFaces(){
		usuarioLogado = new UsuarioEntity();
	}
	
	public String logar(){
		try {
			usuarioLogado = usuarioBean.findByLoginSenha(usuarioLogado);
			
			if (usuarioLogado != null){
				getSession().setAttribute(PullRequestConstantes.USUARIO_LOGADO, usuarioLogado);
				
				return "/index.xhtml";
			}
		} catch (Exception e) {
			return tratarExcecao(e);
		}
		return "";
	}
	
	public String getNomeUsuarioBemVindo(){
		if (usuarioLogado != null){
			return usuarioLogado.getLogin();
		}
		
		return "";
	}
	
	public void limpar(){
		usuarioLogado = new UsuarioEntity();
	}
	
	public String logout(){
		getSession().invalidate();
		return "/login.xhtml";
	}
	
	public void reiniciarSenha(){
		
	}

	public UsuarioEntity getUsuarioLogado() {
		return usuarioLogado;
	}
	public void setUsuarioLogado(UsuarioEntity usuarioLogado) {
		this.usuarioLogado = usuarioLogado;
	}
}