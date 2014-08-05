package br.com.vortice.pullRequest.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CONFIGURACAO")
public class ConfiguracaoEntity extends PullRequestEntity {

	private String	valor;
	private String	nome;
	
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

	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="valor")
	public String getValor() {
		return valor;
	}
	public void setValor(String valor) {
		this.valor = valor;
	}

}
