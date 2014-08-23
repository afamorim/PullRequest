package br.com.vortice.pullRequest.business;

import java.util.List;

import javax.ejb.Stateless;

import br.com.vortice.pullRequest.dao.ClienteDAO;
import br.com.vortice.pullRequest.entity.ClienteEntity;

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
	
	public ClienteEntity insertEntity(ClienteEntity entity) throws AplicacaoException{
		if(this.validarForm(entity)){
			return super.insert(entity);
		}
		return entity;
	}
	
	public void updateEntity(ClienteEntity entity) throws AplicacaoException{
		if(this.validarForm(entity) && this.validarFormPK(entity)){
			super.update(entity);
		}
	}

	public void deleteEntity(ClienteEntity entity) throws AplicacaoException{
		if(this.validarFormPK(entity)){
			super.insert(entity);
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
		if(entity.getNome()==null || "".equals(entity.getNome().trim())){
			throw new AplicacaoException("Nome é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getDataCadastro())){
			throw new AplicacaoException("Data Nascimento é de preenchimento obrigatório!");
		}
		if(entity.getTelefone()==null || "".equals(entity.getTelefone().trim())){
			throw new AplicacaoException("Telefone é de preenchimento obrigatório!");
		}
		if(entity.getEmail()==null || "".equals(entity.getEmail().trim())){
			throw new AplicacaoException("E-mail é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getUltimoAcesso())){
			throw new AplicacaoException("Ultimo Acesso é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getPrimeiroAcesso())){
			throw new AplicacaoException("Primeiro Acesso é de preenchimento obrigatório!");
		}
		if(entity.getEndereco()==null || "".equals(entity.getEndereco().trim())){
			throw new AplicacaoException("Endereço é de preenchimento obrigatório!");
		}
		if(entity.getBairro()==null || "".equals(entity.getBairro().trim())){
			throw new AplicacaoException("Bairro é de preenchimento obrigatório!");
		}
		if(VorticeUtil.isEmpty(entity.getFoto())){
			throw new AplicacaoException("Foto é de preenchimento obrigatório!");
		}
		if(entity.getApelido()==null || "".equals(entity.getApelido().trim())){
			throw new AplicacaoException("Apelido é de preenchimento obrigatório!");
		}
		return true;
	}
}
