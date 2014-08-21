package br.com.vortice.pullrequest.web.faces;

import br.com.vortice.pullRequest.entity.UsuarioEntity;
import br.com.vortice.pullRequest.util.PullRequestConstantes;

import com.vortice.web.view.BasePageBean;

public class PullRequestFaces extends BasePageBean {

	public UsuarioEntity getUsuarioSessao(){
		return (UsuarioEntity)getHttpSession().getAttribute(PullRequestConstantes.USUARIO_LOGADO);
	}
}
