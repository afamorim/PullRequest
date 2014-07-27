package br.com.vortice.pullRequest.business;

import javax.ejb.Stateless;

import br.com.vortice.pullRequest.dao.PerfilDAO;
import br.com.vortice.pullRequest.entity.PerfilEntity;

@Stateless
public class PerfilBean extends GenericBean<PerfilEntity, Long> {

	public PerfilBean(){
		setDAO(new PerfilDAO());
	}
}
