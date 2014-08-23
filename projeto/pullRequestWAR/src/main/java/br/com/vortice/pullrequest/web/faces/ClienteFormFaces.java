package br.com.vortice.pullrequest.web.faces;

import java.io.ByteArrayInputStream;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;
import org.primefaces.model.UploadedFile;

import br.com.vortice.pullRequest.business.UsuarioBean;

import com.vortice.core.util.VorticeUtil;

@ViewScoped
@ManagedBean
public class ClienteFormFaces extends ClienteFaces{

	private static final long serialVersionUID = 4427328927142766044L;
	
	private UploadedFile foto;
	
	@EJB
	private UsuarioBean usuarioBean;

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
			if(!VorticeUtil.isEmpty(getCodigo())){
				getEntity().setCodigo(Long.valueOf(getCodigo()));
				setEntity(bean.findByPrimaryKey(getEntity()));
			}
		}
	}
	
	public void upload() {
        if(foto != null) {
        	setEntity(bean.findByPrimaryKey(getEntity()));
            getEntity().setFoto(foto.getContents());
            bean.update(getEntity());
            addMessageSucesso("Foto alterada com sucesso!");
        }
    }
	
	public StreamedContent getFotoCliente(){
		if(getEntity().getFoto()==null){
			return new DefaultStreamedContent();
		}else{
			return new DefaultStreamedContent(new ByteArrayInputStream(getEntity().getFoto()));
		}
	}
	
	public String salvar(){
		try{
			if(getCodigo()==null){
				if(foto != null) {
					getEntity().setFoto(foto.getContents());
				}
				//TODO Usuario Logado
				setEntity(bean.insertEntity(getEntity()));
				addMessageSucesso("Cliente cadastrado com sucesso!");
			}else{
				bean.updateEntity(getEntity());
				addMessageSucesso("Cliente alterado com sucesso!");
			}
		}catch(Exception e){
			tratarExcecao(e);
		}
		
		return null;
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
	
	public UploadedFile getFoto() {
		return foto;
	}

	public void setFoto(UploadedFile foto) {
		this.foto = foto;
	}

}
