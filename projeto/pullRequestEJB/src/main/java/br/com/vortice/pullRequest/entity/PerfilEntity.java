package br.com.vortice.pullRequest.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="PERFIL")
public class PerfilEntity extends PullRequestEntity {

	private String		nome;
	private Boolean		isAdmin;
	private List<URL>	urls;
	
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

	@ManyToMany
	@JoinTable(name="perfil_url", 
		joinColumns=@JoinColumn(name="perfil_codigo"), 
		inverseJoinColumns=@JoinColumn(name="url_codigo"))
	public List<URL> getUrls() {
		return urls;
	}
	public void setUrls(List<URL> urls) {
		this.urls = urls;
	}
}