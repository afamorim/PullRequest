package br.com.vortice.pullRequest.business;

import java.util.List;

import javax.ejb.Stateless;

import br.com.vortice.pullRequest.dao.ClienteDAO;
import br.com.vortice.pullRequest.entity.ClienteEntity;

import com.vortice.core.exception.AmbienteException;
import com.vortice.core.exception.AplicacaoException;
import com.vortice.core.util.VorticeUtil;

@Stateless
public class ClienteBean extends GenericBean<ClienteEntity,Long>{

	public ClienteBean(){
		setDAO(new ClienteDAO());
	}
	
	public List<ClienteEntity> findByFilter(ClienteEntity filter){
		return ((ClienteDAO)getDAO()).findByFilter(filter);
	}
	
	public ClienteEntity insertEntity(ClienteEntity entity) throws AmbienteException{
		try{
			if(this.validarForm(entity)){
				return super.insert(entity);
			}
		}catch(Exception e){
			throw new AmbienteException(e); 
		}
		return entity;
	}
	
	public void updateEntity(ClienteEntity entity) throws Exception{
		try{
			if(this.validarForm(entity) && this.validarFormPK(entity)){
				super.update(entity);
			}
		}catch(Exception e){
			throw new AmbienteException(e);
		}
	
	}

	public void deleteEntity(ClienteEntity entity) throws Exception{
		try{
			if(this.validarFormPK(entity)){
				super.insert(entity);
			}
		}catch(Exception e){
			throw new AmbienteException(e); 
		}
	}

	private boolean validarFormPK(ClienteEntity entity) throws AplicacaoException {
		if(VorticeUtil.isEmpty(entity.getCodigo())){
			throw new AplicacaoException("Código é de preenchimento obrigatório!");
		}
		return true;
	}
	
	
	private boolean validarForm(ClienteEntity entity) throws AplicacaoException {
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
		if(VorticeUtil.isEmpty(entity.getUltimoAcesso())){
			throw new AplicacaoException("Ultimo Acesso é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getPrimeiroAcesso())){
			throw new AplicacaoException("Primeiro Acesso é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getEndereco())){
			throw new AplicacaoException("Endereço é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getBairro())){
			throw new AplicacaoException("Bairro é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getFoto())){
			throw new AplicacaoException("Foto é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getApelido())){
			throw new AplicacaoException("Apelido é de preenchimento obrigatório!");
		}
		return true;
	}
}
