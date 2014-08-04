package br.com.vortice.pullrequest.seguranca.web.faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class UsuarioConsultaFaces extends UsuarioFaces {

	public UsuarioConsultaFaces(){
		
	}
	
	public void consultar(){
		try {
			setUsuarios(getUsuarioBean().findByFilter(getUsuario()));
		} catch (Exception e) {
			tratarExcecao(e);
		}
	}
	
	public void remover(){
		try {
			getUsuarioBean().delete(getUsuario());
			addMessageSucesso("Usuário removido com sucesso.");
		} catch (Exception e) {
			tratarExcecao(e);
		}
	}
}