package br.com.vortice.pullRequest.business;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import com.vortice.core.exception.AplicacaoException;
import com.vortice.core.util.VorticeUtil;

import br.com.vortice.pullRequest.dao.UsuarioDAO;
import br.com.vortice.pullRequest.entity.UsuarioEntity;

@Stateless
public class UsuarioBean extends GenericBean<UsuarioEntity, Long> {
	
	@EJB
	private PerfilBean	perfilBean;
	
	public UsuarioBean(){
		setDAO(new UsuarioDAO());
	}
	
	@Override
	public UsuarioEntity insert(UsuarioEntity entity) throws AplicacaoException{
		validaRegraNegocio(entity);
		return super.insert(entity);
	}



	@Override
	public void update(UsuarioEntity entity) throws AplicacaoException{
		validaRegraNegocio(entity);
		super.update(entity);
	}


	private void validaRegraNegocio(UsuarioEntity entity) throws AplicacaoException{
		if (!entity.getPerfil().getIsAdmin()){
			if (VorticeUtil.isEmpty(entity.getEstabelecimento()) || VorticeUtil.isEmpty(entity.getEstabelecimento().getCodigo())){
				throw new AplicacaoException("");
			}
		}
	}

	public List<UsuarioEntity> findByFilter(UsuarioEntity aUsuario){
		return getUsuarioDAO().findByFilter(aUsuario);
	}

	public UsuarioEntity findByLoginSenha(UsuarioEntity aUsuario) throws AplicacaoException{
		aUsuario = getUsuarioDAO().findLoginSenha(aUsuario);
		if (aUsuario == null){
			throw new AplicacaoException("Login ou senha incorretos.");
		}
		aUsuario.setPerfil(perfilBean.findByPrimaryKey(aUsuario.getPerfil()));
		return aUsuario;
	}
	
	public UsuarioDAO getUsuarioDAO(){
		return (UsuarioDAO)getDAO();
	}
}