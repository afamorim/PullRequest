package br.com.vortice.pullRequest.sms;

import com.vortice.core.exception.AmbienteException;
import com.vortice.core.exception.AplicacaoException;

import br.com.vortice.pullRequest.entity.SMSEntity;

public interface SMSProxy {
	
	public void enviarSMS(SMSEntity smsEntity) throws AplicacaoException,AmbienteException;
	
	public void validarSMS(SMSEntity smsEntity) throws AplicacaoException;

}
