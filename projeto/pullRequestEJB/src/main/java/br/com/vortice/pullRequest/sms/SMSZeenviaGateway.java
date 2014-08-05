package br.com.vortice.pullRequest.sms;

import java.util.Date;
import java.util.List;

import br.com.vortice.pullRequest.entity.SMSEntity;

import com.human.gateway.client.bean.Response;
import com.human.gateway.client.bean.SimpleMessage;
import com.human.gateway.client.exception.ClientHumanException;
import com.human.gateway.client.service.SimpleMessageService;
import com.vortice.core.exception.AmbienteException;
import com.vortice.core.exception.AplicacaoException;

public class SMSZeenviaGateway extends SMSGatewayAb{
	
	@Override
	public void enviarSMSImpl(SMSEntity smsEntity) throws AplicacaoException,AmbienteException {
		//todo parametrizar
		SimpleMessageService clienteZeenvia = new SimpleMessageService("vorticesis.api","rLNz0qIURc");
		SimpleMessage sms = convertToSimpleMessage(smsEntity);
		try {
			List<Response> listaRespostas = clienteZeenvia.send(sms);
			for(Response retorno : listaRespostas) {
			    System.out.println(retorno.getReturnCode());
			    System.out.println(retorno.getReturnDescription());
			    System.out.println(retorno.isError());
			}
		} catch (ClientHumanException e) {
			throw new AplicacaoException("Erro ao tentar enviar SMS pelo Gateway -> "+e.getMessage());
		}

	}
	
	private SimpleMessage convertToSimpleMessage(SMSEntity smsEntity) throws AplicacaoException{
		SimpleMessage simpleMessage = new SimpleMessage();
		simpleMessage.setId(smsEntity.getCodigo().toString());
		simpleMessage.setTo(smsEntity.getDestino());
		simpleMessage.setMessage(smsEntity.getConteudo());
		simpleMessage.setFrom("Pull Request");
		simpleMessage.setSchedule(new Date());
		//simpleMessage.setCallback(CallbackTypeEnum.FINAL);
		return simpleMessage;
	}
	
	@Override
	public int getCodigoFornecedor() {
		return 1;
	}
	
	public static void main(String[] args) throws Exception{
		SMSEntity smsEntity = new SMSEntity();
		smsEntity.setDestino("7188672738");
		smsEntity.setConteudo("teste de envio sms usando API ZEenvia...");
		try{
		new SMSZeenviaGateway().enviarSMS(smsEntity);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
