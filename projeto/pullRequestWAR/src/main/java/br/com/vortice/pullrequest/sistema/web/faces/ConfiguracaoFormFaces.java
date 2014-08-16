package br.com.vortice.pullrequest.sistema.web.faces;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import br.com.vortice.pullRequest.business.ConfiguracaoBean;
import br.com.vortice.pullRequest.entity.ConfiguracaoEntity;

import com.vortice.web.view.BasePageBean;

@ManagedBean
@ViewScoped
@SuppressWarnings("serial")
public class ConfiguracaoFormFaces extends BasePageBean {

	private ConfiguracaoEntity		configuracao;
	
	private List<ConfiguracaoEntity>	configuracoes;
	
	@EJB
	private ConfiguracaoBean configuracaooBean;
	
	public ConfiguracaoFormFaces(){
		
	}
	
	@PostConstruct
	public void init(){
		if (!FacesContext.getCurrentInstance().isPostback())
		{
			System.out.println("TESTE");
		}else{
			System.out.println("TESTE 1");
		}
		inicializarModel();
	}
	
	public void inicializarModel(){
		setConfiguracao(new ConfiguracaoEntity());
		setConfiguracoes(getConfiguracaooBean().findByFilter(new ConfiguracaoEntity()));
	}
	
	public void limparFiltro(){
		inicializarModel();
	}
	
	public void salvar(){
		try {
			if (getConfiguracao().getCodigo() == null){
				getConfiguracaooBean().insert(getConfiguracao());
				super.addMessageSucesso("Configuração inserida com sucesso.");
			}else{
				getConfiguracaooBean().update(getConfiguracao());
				super.addMessageSucesso("Configuração alterada com sucesso.");
			}
		} catch (Exception e) {
			tratarExcecao(e);
		}
	}
	
	public void salvarAlteracao(){
		try {
			configuracaooBean.updateConfiguracoes(configuracoes);
			super.addMessageSucesso("Configurações alteradas com sucesso.");
		} catch (Exception e) {
			tratarExcecao(e);
		}
	}

	public ConfiguracaoEntity getConfiguracao() {
		return configuracao;
	}

	public void setConfiguracao(ConfiguracaoEntity configuracao) {
		this.configuracao = configuracao;
	}

	public List<ConfiguracaoEntity> getConfiguracoes() {
		return configuracoes;
	}

	public void setConfiguracoes(List<ConfiguracaoEntity> configuracoes) {
		this.configuracoes = configuracoes;
	}

	public ConfiguracaoBean getConfiguracaooBean() {
		return configuracaooBean;
	}
}