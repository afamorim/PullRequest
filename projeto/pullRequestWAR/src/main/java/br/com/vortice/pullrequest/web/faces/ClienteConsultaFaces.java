package br.com.vortice.pullrequest.web.faces;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vortice.pullRequest.entity.ClienteEntity;

@ViewScoped
@ManagedBean
public class ClienteConsultaFaces extends ClienteFaces{

	private static final long serialVersionUID = -946278552443427606L;
	
	private List<ClienteEntity> listaResultado;
	
	private ClienteEntity cliente;
	
	public ClienteConsultaFaces(){
		super.init();
		listaResultado = new ArrayList<ClienteEntity>();
	}
	
	public void consultar(){
		try{
			listaResultado = super.bean.findByFilter(getEntity());
		}catch(Exception e){
			super.tratarExcecao(e);
		}
	}
	
	public void limparFiltro(){
		setEntity(new ClienteEntity());
	}
	
	public void remover(){
		try{
			super.bean.delete(cliente);
			this.consultar();
		}catch(Exception e){
			super.tratarExcecao(e);
		}
	}
	
	public String detalhar(){
		return "/cliente/cliente_form.xhtml?faces-redirect=true&codigo="+this.getCodigo();
	}

	public ClienteEntity getCliente() {
		return cliente;
	}

	public void setCliente(ClienteEntity cliente) {
		this.cliente = cliente;
	}

	public List<ClienteEntity> getListaResultado() {
		return listaResultado;
	}

	public void setListaResultado(List<ClienteEntity> listaResultado) {
		this.listaResultado = listaResultado;
	}

}
