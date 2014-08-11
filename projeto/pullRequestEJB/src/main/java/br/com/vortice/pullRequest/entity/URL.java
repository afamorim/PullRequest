package br.com.vortice.pullRequest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name="URL")
public class URL extends PullRequestEntity {

	private String url;
	private Boolean	liberada;
	
	@Id
	@Override
	@Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return super.getCodigo();
	}
	@Override
	public void setCodigo(Long codigo) {
		super.setCodigo(codigo);
	}
	
	@Column(name="url")
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	
	@Column(name="liberada")
	public Boolean getLiberada() {
		return liberada;
	}
	public void setLiberada(Boolean liberada) {
		this.liberada = liberada;
	}
}
