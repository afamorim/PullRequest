package br.com.vortice.pullrequest.web.faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.vortice.core.util.VorticeUtil;

@ViewScoped
@ManagedBean
public class EstabelecimentoFormFaces extends EstabelecimentoFaces {

	private static final long serialVersionUID = 7494670942517970275L;
	
	public EstabelecimentoFormFaces(){
		this.init();
	}
	
	public void render(){
		if (!FacesContext.getCurrentInstance().isPostback()){
			if(getCodigo()!=null){
				getEntity().setCodigo(getCodigo());
				setEntity(bean.findByPrimaryKey(getEntity()));
			}
		}else{
			String codigoParameter = getRequest().getParameter("codigo");
			if(!VorticeUtil.isEmpty(codigoParameter)){
				getEntity().setCodigo(Long.valueOf(codigoParameter));
				setEntity(bean.findByPrimaryKey(getEntity()));
			}
		}
	}
	
	public void salvar(){
		try{
			if(getCodigo()==null){
				setEntity(bean.insertEntity(getEntity()));
				addMessageSucesso("Estabelecimento cadastrado com sucesso!");
			}else{
				bean.updateEntity(getEntity());
				addMessageSucesso("Estabelecimento alterado com sucesso!");
			}
		}catch(Exception e){
			tratarExcecao(e);
		}
	}
	
	public String remover(){
		try{
			bean.deleteEntity(getEntity());
			addMessageSucesso("Estabelecimento removido com sucesso!");
			return super.consulta();
		}catch(Exception e){
			tratarExcecao(e);
		}
		return null;
	}

}
