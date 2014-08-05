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
	
	private void tratarRetorno(Response response) throws AplicacaoException{
		int codigoRetorno = Integer.valueOf(response.getReturnCode());
		switch (codigoRetorno) {
		case 100:
		case 110:
		case 120:
		break;
		case 140:
			throw new AplicacaoException("Número não coberto.");
		case 145:
			throw new AplicacaoException("Número inativo.");
		case 150:
		case 160:
		case 161:
		case 162:
		case 170:
		case 171:
			throw new AplicacaoException("A operadora de SMS não confirma o recebimento ("+response.getReturnDescription()+").");
			
		default:
			break;
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
		smsEntity.setDestino("718867a2738");
		smsEntity.setConteudo("teste de envio sms usando API ZEenvia...");
		try{
		new SMSZeenviaGateway().enviarSMS(smsEntity);
		}catch(Exception ex){
			ex.printStackTrace();
		}
	}
	
}
