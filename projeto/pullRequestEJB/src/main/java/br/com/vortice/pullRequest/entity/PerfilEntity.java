package br.com.vortice.pullRequest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PERFIL")
public class PerfilEntity extends PullRequestEntity {

	private String	nome;
	private Boolean	isAdmin;
	
	@Id
	@Override
	public Long getCodigo() {
		return super.getCodigo();
	}

	@Override
	public void setCodigo(Long codigo) {
		super.setCodigo(codigo);
	}

	@Column(name="descricao")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name="is_admin")
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
}