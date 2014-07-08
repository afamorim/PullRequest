package br.com.vortice.treinamento.business;

import java.util.List;

import javax.ejb.Stateless;

import br.com.vortice.treinamento.dao.ResponsavelDAO;
import br.com.vortice.treinamento.entity.Responsavel;

@Stateless
public class ResponsavelBean extends GenericBean<Responsavel, Long> {

	public ResponsavelBean(){
		setDAO(new ResponsavelDAO());
	}
	
	public List<Responsavel> findByFilter(Responsavel aResponsavel){
		return getResponsavelDAO().findByFilter(aResponsavel);
	}
	
	public ResponsavelDAO getResponsavelDAO(){
		return (ResponsavelDAO)getDAO();
	}
}
