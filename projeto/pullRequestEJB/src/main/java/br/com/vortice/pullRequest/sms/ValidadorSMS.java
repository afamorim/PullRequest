package br.com.vortice.pullRequest.sms;

import org.apache.commons.lang3.StringUtils;

import br.com.vortice.pullRequest.entity.SMSEntity;

import com.vortice.core.exception.AplicacaoException;

public class ValidadorSMS {
	
	private static final int MAX_LENGTH_SMS = 140;
	private static final int CODIGO_INTERNACIONAL_BRASIL = 55;
	
	public void validarTelefone(SMSEntity smsEntity) throws AplicacaoException{
		String telefoneDestino = smsEntity.getDestino();
		if(StringUtils.isEmpty(telefoneDestino)){
			throw new AplicacaoException("Não é possível enviar um SMS sem um número destino.Telefone -> "+telefoneDestino);
		}else{
			if(!telefoneDestino.matches("[0-9]*")){
				throw new AplicacaoException("Não é possível enviar um SMS com um número de telefone com caracteres não numéricos.Telefone -> "+telefoneDestino);
			}else if(telefoneDestino.length() < 8){
				throw new AplicacaoException("Não é possível enviar um SMS com um número incompleto. Tamanho inválido -> "+telefoneDestino.length());
			}else if(telefoneDestino.length() == 8 || telefoneDestino.length() == 9){
				throw new AplicacaoException("Não é possível enviar um SMS sem informar o DDD. Telefone -> "+telefoneDestino);
			}else if(telefoneDestino.length() == 10 || telefoneDestino.length() == 11){
				smsEntity.setDestino(CODIGO_INTERNACIONAL_BRASIL+telefoneDestino);
			}else if(telefoneDestino.length() > 13){
				throw new AplicacaoException("Não é possível enviar um SMS com um número com mais de 13 caracteres. Telefone -> "+telefoneDestino);
			}
		}
	}
	
	public void validarMensagem(SMSEntity smsEntity) throws AplicacaoException{ 
		String mensagem = smsEntity.getConteudo();
		if(StringUtils.isEmpty(mensagem)){
			throw new AplicacaoException("Não é possível enviar um SMS sem conteudo.");
		}else if(mensagem.length() > MAX_LENGTH_SMS){
			throw new AplicacaoException("Não é possível enviar um SMS com tamanho superior a "+MAX_LENGTH_SMS+" caracteres.");
		}
	}
	
	public static void main(String[] args) {
		System.out.println("094230402".matches("[0-9]*"));
		System.out.println("094230(402".matches("[0-9]*"));
		System.out.println("0942304-02".matches("[0-9]*"));
		System.out.println("094233042s02".matches("[0-9]*"));
	}

}
