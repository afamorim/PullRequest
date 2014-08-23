package br.com.vortice.pullrequest.web.faces;

import br.com.vortice.pullRequest.entity.UsuarioEntity;
import br.com.vortice.pullRequest.util.PullRequestConstantes;

import com.vortice.web.view.BasePageBean;

public class PullRequestFaces extends BasePageBean {

	private static final long serialVersionUID = 4610945264834215357L;

	public UsuarioEntity getUsuarioSessao(){
		return (UsuarioEntity)getHttpSession().getAttribute(PullRequestConstantes.USUARIO_LOGADO);
	}
	
	public Boolean getIsAdmin(){
		return getUsuarioSessao().getPerfil().getIsAdmin();
	}
}
