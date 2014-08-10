package br.com.vortice.pullrequest.web.faces;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vortice.pullRequest.entity.EstabelecimentoEntity;

@ViewScoped
@ManagedBean
public class EstabelecimentoConsultaFaces extends EstabelecimentoFaces{

	private static final long serialVersionUID = 9174638381212312329L;

	private List<EstabelecimentoEntity> listaResultado;
	
	private EstabelecimentoEntity estabelecimento;
	
	public EstabelecimentoConsultaFaces(){
		super.init();
		listaResultado = new ArrayList<EstabelecimentoEntity>();
	}
	
	public void consultar(){
		try{
			super.bean.findByFilter(getEntity());
		}catch(Exception e){
			super.tratarExcecao(e);
		}
	}
	
	public void remover(){
		try{
			super.bean.delete(estabelecimento);
		}catch(Exception e){
			super.tratarExcecao(e);
		}
	}
	
	public String detalhar(){
		return "/estabelecimento/estabelecimento_form.xhtml?faces-redirect=true&codigo="+this.getCodigo();
	}

	public EstabelecimentoEntity getEstabelecimento() {
		return estabelecimento;
	}

	public void setEstabelecimento(EstabelecimentoEntity estabelecimento) {
		this.estabelecimento = estabelecimento;
	}

	public List<EstabelecimentoEntity> getListaResultado() {
		return listaResultado;
	}

	public void setListaResultado(List<EstabelecimentoEntity> listaResultado) {
		this.listaResultado = listaResultado;
	}
}
