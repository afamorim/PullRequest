package br.com.vortice.pullrequest.seguranca.web.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import br.com.vortice.pullRequest.business.PerfilBean;
import br.com.vortice.pullRequest.business.UsuarioBean;
import br.com.vortice.pullRequest.entity.PerfilEntity;
import br.com.vortice.pullRequest.entity.UsuarioEntity;

import com.vortice.web.view.BasePageBean;

@ManagedBean
@ViewScoped
@SuppressWarnings("serial")
public class UsuarioFaces extends BasePageBean{

	private UsuarioEntity		usuario;
	
	private List<UsuarioEntity>	usuarios;
	
	private List<PerfilEntity>	perfis;
	
	@EJB
	private UsuarioBean			usuarioBean;
	
	@EJB
	private PerfilBean			perfilBean;
	
	public UsuarioFaces(){
		incializarUsuario();
		
		usuarios = new ArrayList<UsuarioEntity>();
	}
	
	@PostConstruct
	public void init(){
		setPerfis(perfilBean.findAll());
	}
	
	public void incializarUsuario(){
		setUsuario(new UsuarioEntity());
		getUsuario().setPerfil(new PerfilEntity());
	}
	
	public void limparFiltro(){
		incializarUsuario();
	}
	
	public String novo(){
		return "/seguranca/usario_form.xhtml";
	}
	
	public String consulta(){
		return "/seguranca/usuario_consulta.xhtml";
	}

	public UsuarioEntity getUsuario() {
		return usuario;
	}
	public void setUsuario(UsuarioEntity usuario) {
		this.usuario = usuario;
	}
	public UsuarioBean getUsuarioBean() {
		return usuarioBean;
	}
	public List<UsuarioEntity> getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(List<UsuarioEntity> usuarios) {
		this.usuarios = usuarios;
	}
	public List<PerfilEntity> getPerfis() {
		return perfis;
	}
	public void setPerfis(List<PerfilEntity> perfis) {
		this.perfis = perfis;
	}
}