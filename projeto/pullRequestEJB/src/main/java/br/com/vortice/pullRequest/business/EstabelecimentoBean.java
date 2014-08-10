package br.com.vortice.pullRequest.business;

import java.util.List;

import javax.ejb.Stateless;

import br.com.vortice.pullRequest.dao.EstabelecimentoDAO;
import br.com.vortice.pullRequest.entity.EstabelecimentoEntity;

import com.vortice.core.exception.AmbienteException;
import com.vortice.core.exception.AplicacaoException;
import com.vortice.core.util.VorticeUtil;

@Stateless
public class EstabelecimentoBean extends GenericBean<EstabelecimentoEntity,Long>{

	public EstabelecimentoBean(){
		setDAO(new EstabelecimentoDAO());
	}
	
	public List<EstabelecimentoEntity> findByFilter(EstabelecimentoEntity filter){
		return ((EstabelecimentoDAO)getDAO()).findByFilter(filter);
	}
	
	public EstabelecimentoEntity insertEntity(EstabelecimentoEntity entity) throws AmbienteException{
		try{
			if(this.validarForm(entity)){
				return super.insert(entity);
			}
		}catch(Exception e){
			throw new AmbienteException(e); 
		}
		return entity;
	}
	
	public void updateEntity(EstabelecimentoEntity entity) throws Exception{
		try{
			if(this.validarForm(entity) && this.validarFormPK(entity)){
				super.update(entity);
			}
		}catch(Exception e){
			throw new AmbienteException(e);
		}
	
	}

	public void deleteEntity(EstabelecimentoEntity entity) throws Exception{
		try{
			if(this.validarFormPK(entity)){
				super.insert(entity);
			}
		}catch(Exception e){
			throw new AmbienteException(e); 
		}
	}

	private boolean validarFormPK(EstabelecimentoEntity entity) throws AplicacaoException {
		if(VorticeUtil.isEmpty(entity.getCodigo())){
			throw new AplicacaoException("Código é de preenchimento obrigatório!");
		}
		return true;
	}
	
	
	private boolean validarForm(EstabelecimentoEntity entity) throws AplicacaoException {
		if(VorticeUtil.isEmpty(entity.getUsuarioCadastro()) ||
				VorticeUtil.isEmpty(entity.getUsuarioCadastro().getCodigo())){
			throw new AplicacaoException("Usuário Cadastro é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getDataCadastro())){
			throw new AplicacaoException("Data Cadastro é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getNome())){
			throw new AplicacaoException("Nome é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getDataCadastro())){
			throw new AplicacaoException("Data Nascimento é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getTelefone())){
			throw new AplicacaoException("Telefone é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getEmail())){
			throw new AplicacaoException("E-mail é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getQuantidadeTotalVagas())){
			throw new AplicacaoException("Quantidade de Vagas é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getResponsavelEstabelecimento()) ||
				VorticeUtil.isEmpty(entity.getResponsavelEstabelecimento().getCodigo())){
			throw new AplicacaoException("Responsável é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getEndereco())){
			throw new AplicacaoException("Endereço é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getLocalizacaoGoogleMaps())){
			throw new AplicacaoException("Localização Google Maps é de preenchimento obrigatório!");
		}
		return true;
	}
}
