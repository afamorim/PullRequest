package br.com.vortice.pullrequest.seguranca.web.faces;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.vortice.pullRequest.business.EstabelecimentoBean;
import br.com.vortice.pullRequest.business.PerfilBean;
import br.com.vortice.pullRequest.business.UsuarioBean;
import br.com.vortice.pullRequest.entity.EstabelecimentoEntity;
import br.com.vortice.pullRequest.entity.PerfilEntity;
import br.com.vortice.pullRequest.entity.UsuarioEntity;
import br.com.vortice.pullrequest.web.faces.PullRequestFaces;

@ManagedBean
@ViewScoped
@SuppressWarnings("serial")
public class UsuarioFaces extends PullRequestFaces{

	private UsuarioEntity		usuario;
	
	private List<UsuarioEntity>	usuarios;
	
	private List<PerfilEntity>	perfis;
	
	private List<EstabelecimentoEntity> estabelecimentos;
	
	@EJB
	private UsuarioBean			usuarioBean;
	
	@EJB
	private PerfilBean			perfilBean;
	
	@EJB
	private EstabelecimentoBean	estabelecimentoBean;
	
	public UsuarioFaces(){
		super();
		incializarUsuario();
		
		usuarios = new ArrayList<UsuarioEntity>();
	}
	
	@PostConstruct
	public void init(){
		try {
			System.out.println("POST USUARIO");
			if (!FacesContext.getCurrentInstance().isPostback())
			{
				setPerfis(perfilBean.findAll());
				setEstabelecimentos(estabelecimentoBean.findAll());
			}else{
				System.out.println("TESTE 1");
			}
		} catch (Exception e) {
			tratarExcecao(e);
		}
		
	}
	
	public void incializarUsuario(){
		setUsuario(new UsuarioEntity());
		getUsuario().setPerfil(new PerfilEntity());
		getUsuario().setAtivo(true);
	}
	
	public void limparFiltro(){
		incializarUsuario();
	}
	
	public String novo(){
		return "/seguranca/usuario_form.xhtml";
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
	public List<EstabelecimentoEntity> getEstabelecimentos() {
		return estabelecimentos;
	}
	public void setEstabelecimentos(List<EstabelecimentoEntity> estabelecimentos) {
		this.estabelecimentos = estabelecimentos;
	}
}