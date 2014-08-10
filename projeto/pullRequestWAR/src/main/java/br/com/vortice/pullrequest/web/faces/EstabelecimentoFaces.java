package br.com.vortice.pullrequest.web.faces;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vortice.pullRequest.business.EstabelecimentoBean;
import br.com.vortice.pullRequest.entity.EstabelecimentoEntity;

import com.vortice.web.view.BasePageBean;

@ManagedBean
@ViewScoped
public class EstabelecimentoFaces extends BasePageBean{

	private static final long serialVersionUID = -6221752626531119134L;

	@EJB
	protected EstabelecimentoBean bean;
	
	private EstabelecimentoEntity entity;
	
	private Long codigo;
	
	public void init(){
		entity = new EstabelecimentoEntity();
		codigo = null;
	}
	
	public void limparEntity(){
		entity = new EstabelecimentoEntity();
	}
	
	public String novo(){
		return "/estabelecimento/estabelecimento_form.xhtml";
	}
	
	public String consulta(){
		return "/estabelecimento/estabelecimento_consulta.xhtml";
	}

	public EstabelecimentoEntity getEntity() {
		return entity;
	}

	public void setEntity(EstabelecimentoEntity entity) {
		this.entity = entity;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

}
