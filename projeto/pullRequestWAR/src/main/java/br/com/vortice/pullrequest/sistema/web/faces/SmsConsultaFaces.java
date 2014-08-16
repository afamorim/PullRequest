package br.com.vortice.pullrequest.sistema.web.faces;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vortice.pullRequest.entity.SMSEntity;
import br.com.vortice.pullRequest.entity.assembler.SMSAssembler;

@ManagedBean
@ViewScoped
@SuppressWarnings("serial")
public class SmsConsultaFaces extends SmsFaces {

	private List<SMSEntity> listaSMS;

	private SMSAssembler	smsAssembler;
	
	public SmsConsultaFaces(){
		initFiltro();
	}
	
	private void initFiltro(){
		smsAssembler = new SMSAssembler();
		smsAssembler.setSms(new SMSEntity());
	}
	
	public void limparFiltro(){
		initFiltro();
	}

	public void consultar(){
		listaSMS = getSmsBean().findAll();
	}
	
	public List<SMSEntity> getListaSMS() {
		return listaSMS;
	}
	public void setListaSMS(List<SMSEntity> listaSMS) {
		this.listaSMS = listaSMS;
	}
	public SMSAssembler getSmsAssembler() {
		return smsAssembler;
	}
	public void setSmsAssembler(SMSAssembler smsAssembler) {
		this.smsAssembler = smsAssembler;
	}
}