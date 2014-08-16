package br.com.vortice.pullRequest.entity.assembler;

import java.util.Date;

import br.com.vortice.pullRequest.entity.SMSEntity;

public class SMSAssembler {

	private SMSEntity	sms;
	
	private Date	dataEnvioInicio;
	private Date	dataEnvioFim;
	
	public SMSEntity getSms() {
		return sms;
	}
	public void setSms(SMSEntity sms) {
		this.sms = sms;
	}
	public Date getDataEnvioInicio() {
		return dataEnvioInicio;
	}
	public void setDataEnvioInicio(Date dataEnvioInicio) {
		this.dataEnvioInicio = dataEnvioInicio;
	}
	public Date getDataEnvioFim() {
		return dataEnvioFim;
	}
	public void setDataEnvioFim(Date dataEnvioFim) {
		this.dataEnvioFim = dataEnvioFim;
	}
}