package br.com.vortice.pullrequest.web.faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.vortice.core.exception.AplicacaoException;
import com.vortice.core.util.VorticeUtil;

@SuppressWarnings("serial")
@ManagedBean
@ViewScoped
public class ResponsavelFormFaces extends ResponsavelFaces {

	public ResponsavelFormFaces(){
		initResponsavel();
	}
	
	public void init(){
		if (!FacesContext.getCurrentInstance().isPostback())
		{
			if (getCodigo() != null){
				getResponsavel().setCodigo(new Long(getCodigo()));
				setResponsavel(getResponsavelBean().findByPrimaryKey(getResponsavel()));
			}
		}else{
			String codigoParameter = getRequest().getParameter("codigo");
			if(!VorticeUtil.isEmpty(codigoParameter)){
				getResponsavel().setCodigo(Long.valueOf(codigoParameter));
				setResponsavel(getResponsavelBean().findByPrimaryKey(getResponsavel()));
			}
		}
	}
	
	public void salvar() throws Exception{
//		throw new AplicacaoException("Teste de exception");
		try {
			if (getResponsavel().getCodigo() != null){
				getResponsavelBean().update(getResponsavel());
				addMessageSucesso("Responsável alterado com sucesso.");
			}else{
				getResponsavelBean().insert(getResponsavel());
				addMessageSucesso("Responsável inserido com sucesso.");
			}
		} catch (Exception e) {
			tratarExcecao(e);
		}
	}

}
