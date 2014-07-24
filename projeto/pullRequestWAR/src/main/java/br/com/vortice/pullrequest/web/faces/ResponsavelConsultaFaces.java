package br.com.vortice.pullrequest.web.faces;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vortice.pullrequest.business.ResponsavelBean;
import br.com.vortice.pullrequest.entity.Responsavel;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ResponsavelConsultaFaces extends ResponsavelFaces{

	private List<Responsavel> responsaveis;
	
	@EJB
	private ResponsavelBean	responsavelBean;
	
	public ResponsavelConsultaFaces(){
		initResponsavel();
		responsaveis = new ArrayList<Responsavel>();
	}
	
	public void consultar(){
		try {
			responsaveis = responsavelBean.findAll();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void remover(){
		try {
			getResponsavelBean().delete(getResponsavel());
			addMessageSucesso("Responsável removido com sucesso.");
			responsaveis.clear();
		} catch (Exception e) {
			tratarExcecao(e);
		}
	}

	public List<Responsavel> getResponsaveis() {
		return responsaveis;
	}
	public void setResponsaveis(List<Responsavel> responsaveis) {
		this.responsaveis = responsaveis;
	}
}