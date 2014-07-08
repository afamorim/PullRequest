package br.com.vortice.treinamento.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.vortice.core.abstracao.Entidade;

@Entity
@Table(name="aluno")
public class Aluno extends Entidade{

	@Column(name="nome")
	private String	nome;
	
	@Column(name="email")
	private String	email;
	
	@Column(name="data_nascimento")
	@Temporal(TemporalType.DATE)
	private Date	dataNascimento;
	
	
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
