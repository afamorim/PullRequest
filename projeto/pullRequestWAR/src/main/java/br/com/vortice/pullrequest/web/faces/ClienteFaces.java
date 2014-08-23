package br.com.vortice.pullrequest.web.faces;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vortice.pullRequest.business.ClienteBean;
import br.com.vortice.pullRequest.entity.ClienteEntity;

@ManagedBean
@ViewScoped
public class ClienteFaces extends PullRequestFaces{

	private static final long serialVersionUID = -4185196276985624215L;
	
	@EJB
	protected ClienteBean bean;
	
	private ClienteEntity entity;
	
	private Long codigo;
	
	public void init(){
		entity = new ClienteEntity();
		codigo = null;
	}
	
	public void limparEntity(){
		entity = new ClienteEntity();
	}
	
	public String novo(){
		return "/cliente/cliente_form.xhtml";
	}
	
	public String consulta(){
		return "/cliente/cliente_consulta.xhtml";
	}

	public ClienteEntity getEntity() {
		return entity;
	}

	public void setEntity(ClienteEntity entity) {
		this.entity = entity;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

}
