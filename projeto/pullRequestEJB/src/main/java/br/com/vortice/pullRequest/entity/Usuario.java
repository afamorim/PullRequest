package br.com.vortice.pullRequest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="USUARIO")
public class Usuario extends PullRequestEntidade {

	@Id
	@Override
	public Long getCodigo() {
		return super.getCodigo();
	}

	@Override
	public void setCodigo(Long codigo) {
		super.setCodigo(codigo);
	}
	
}
