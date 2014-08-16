package br.com.vortice.pullRequest.business;

import javax.ejb.Stateless;

import br.com.vortice.pullRequest.dao.SMSDAO;
import br.com.vortice.pullRequest.entity.SMSEntity;

@Stateless
public class SMSBean extends GenericBean<SMSEntity, Long>{

	public SMSBean(){
		setDAO(new SMSDAO());
	}
}
