package br.com.vortice.pullrequest.sistema.web.faces;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import br.com.vortice.pullRequest.business.SMSBean;

import com.vortice.web.view.BasePageBean;

@ManagedBean
@ViewScoped
@SuppressWarnings("serial")
public class SmsFaces extends BasePageBean{

	@EJB
	private SMSBean	smsBean;

	
	public SMSBean getSmsBean() {
		return smsBean;
	}
}
