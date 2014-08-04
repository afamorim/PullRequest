package br.com.vortice.pullrequest.seguranca.web.faces;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

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
		if (!FacesContext.getCurrentInstance().isPostback())
		{
			if (codigo != null){
				getUsuario().setCodigo(new Long(getCodigo()));
				setUsuario(getUsuarioBean().findByPrimaryKey(getUsuario()));
			}
		}else{
			String codigoParameter = getRequest().getParameter("codigo");
			if(!VorticeUtil.isEmpty(codigoParameter)){
				getUsuario().setCodigo(Long.valueOf(codigoParameter));
				setUsuario(getUsuarioBean().findByPrimaryKey(getUsuario()));
			}
		}
		super.init();
	}
	
	public void salvar(){
		try {
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