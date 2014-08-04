package br.com.vortice.pullRequest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="URL")
public class URL extends PullRequestEntity {

	private String url;
	
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
	
}
