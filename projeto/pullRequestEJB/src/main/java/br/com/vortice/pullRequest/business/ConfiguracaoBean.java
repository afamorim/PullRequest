package br.com.vortice.pullRequest.business;

import java.util.List;

import javax.ejb.Stateless;

import br.com.vortice.pullRequest.dao.ConfiguracaoDAO;
import br.com.vortice.pullRequest.entity.ConfiguracaoEntity;

@Stateless
public class ConfiguracaoBean extends GenericBean<ConfiguracaoEntity, Long> {
	
	public ConfiguracaoBean(){
		setDAO(new ConfiguracaoDAO());
	}
	
	public void updateConfiguracoes(List<ConfiguracaoEntity> configuracoes){
		for (ConfiguracaoEntity configuracao : configuracoes){
			getDAO().update(configuracao);
		}
	}
	
	public List<ConfiguracaoEntity> findByFilter(ConfiguracaoEntity aConfiguracao){
		return getConfiguracaoDAO().findByFilter(aConfiguracao);
	}
	
	public ConfiguracaoDAO getConfiguracaoDAO(){
		return (ConfiguracaoDAO)getDAO();
	}
}