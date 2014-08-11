package br.com.vortice.pullrequest.seguranca.web.faces;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.vortice.core.exception.AplicacaoException;
import com.vortice.core.util.VorticeUtil;

@ManagedBean
@ViewScoped
@SuppressWarnings("serial")
public class UsuarioFormFaces extends UsuarioFaces {

	private Long	codigo;
	
	private String	rSenha;
	
	public UsuarioFormFaces(){
		super();
	}
	
	@PostConstruct
	public void init(){
		if (FacesContext.getCurrentInstance().isPostback())
		{
			if (codigo != null){
				getUsuario().setCodigo(new Long(getCodigo()));
				setUsuario(getUsuarioBean().findByPrimaryKey(getUsuario()));
			}
		}else{
			String codigoParameter = getRequest().getParameter("codigo");
			if(codigoParameter != null && !"".equals(codigoParameter)){
				getUsuario().setCodigo(Long.valueOf(codigoParameter));
				setUsuario(getUsuarioBean().findByPrimaryKey(getUsuario()));
				codigo = new Long(codigoParameter);
				rSenha = getUsuario().getSenha();
			}
		}
		super.init();
	}
	
	public void salvar(){
		try {
			if (getUsuario().getSenha() != null){
				if (!getUsuario().getSenha().equals(rSenha)){
					throw new AplicacaoException("As senhas digitadas devem ser similares.");
				}
			}
			
			if (getUsuario().getCodigo() == null){
				getUsuario().setDataCadastro(new Date());
				getUsuarioBean().insert(getUsuario());
				super.addMessageSucesso("Usuário inserido com sucesso.");
			}else{
				getUsuarioBean().update(getUsuario());
				super.addMessageSucesso("Usuário alterado com sucesso.");
			}
		} catch (Exception e) {
			tratarExcecao(e);
		}
	}
	
	public boolean getDesabilitaSenha(){
		if (getUsuario().getCodigo() != null && getUsuario().getCodigo() > 0){
			return true;
		}else{
			return false;
		}
	}
	
	@Override
	public String consulta(){
		return "/seguranca/usuario_consulta.xhtml";
	}

	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getrSenha() {
		return rSenha;
	}
	public void setrSenha(String rSenha) {
		this.rSenha = rSenha;
	}
}