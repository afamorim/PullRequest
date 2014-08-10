package br.com.vortice.pullrequest.web.faces;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import com.vortice.core.util.VorticeUtil;

@ViewScoped
@ManagedBean
public class ClienteFormFaces extends ClienteFaces{

	private static final long serialVersionUID = 4427328927142766044L;
	
	public ClienteFormFaces(){
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
				addMessageSucesso("Cliente cadastrado com sucesso!");
			}else{
				bean.updateEntity(getEntity());
				addMessageSucesso("Cliente alterado com sucesso!");
			}
		}catch(Exception e){
			tratarExcecao(e);
		}
	}
	
	public String remover(){
		try{
			bean.deleteEntity(getEntity());
			addMessageSucesso("Cliente removido com sucesso!");
			return super.consulta();
		}catch(Exception e){
			tratarExcecao(e);
		}
		return null;
	}

}
