package br.com.vortice.pullRequest.sms;

import br.com.vortice.pullRequest.entity.SMSEntity;

import com.vortice.core.exception.AmbienteException;
import com.vortice.core.exception.AplicacaoException;

public abstract class SMSGatewayAb implements SMSProxy{
	
	@Override
	public void validarSMS(SMSEntity smsEntity) throws AplicacaoException{
		if(smsEntity != null){
			ValidadorSMS validadorSMS = new ValidadorSMS();
			validadorSMS.validarTelefone(smsEntity);
			validadorSMS.validarMensagem(smsEntity);
		}else{
			throw new AplicacaoException("Não é possível enviar um SMS null.");
		}
	}

	@Override
	public void enviarSMS(SMSEntity smsEntity) throws AplicacaoException,AmbienteException {
		if(isEnvioSMSHabilitado()){
			//auditarEnvioSMS();
			//verificar cota consumo SMS
			validarSMS(smsEntity);
			enviarSMSImpl(smsEntity);
		}else{
			// TODO
			//log que envio esta desabilitado
		}
	}
	
	public boolean isEnvioSMSHabilitado(){
		return true;
	}
	
	public abstract void enviarSMSImpl(SMSEntity smsEntity) throws AplicacaoException,AmbienteException;
	public abstract int getCodigoFornecedor();

}
