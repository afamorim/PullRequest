package br.com.vortice.pullRequest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name="RESPONSAVEL_ESTABELECIMENTO")
public class ResponsavelEstabelecimentoEntity extends PullRequestEntity{

	private UsuarioEntity			usuarioCadastro;
	private EstabelecimentoEntity	estabelecimento;
	private String					nome;
	private Date					dataCadastro;
	private String					telefone;
	private String					email;
	private	Date					dataNascimento;
	
	@Override
	@Id
	@Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return super.getCodigo();
	}
	@Override
	public void setCodigo(Long codigo) {
		super.setCodigo(codigo);
	}
	
	@ManyToOne
	@JoinColumn(name="usuario_cadastro_codigo")
	public UsuarioEntity getUsuarioCadastro() {
		return usuarioCadastro;
	}
	public void setUsuarioCadastro(UsuarioEntity usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}
	
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="data_cadastro")
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Column(name="telefone")
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Temporal(TemporalType.DATE)
	@Column(name="data_nascimento")
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@OneToOne
	@JoinColumn(name="estabelecimento_codigo")
	public EstabelecimentoEntity getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(EstabelecimentoEntity estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
}