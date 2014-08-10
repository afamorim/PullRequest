package br.com.vortice.pullRequest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CLIENTE")
public class ClienteEntity extends PullRequestEntity {

	private static final long serialVersionUID = 199835826477115541L;
	
	private Long codigo;
	private UsuarioEntity usuarioCadastro;
	private Date dataCadastro;
	private String nome;
	private Date dataNascimento;
	private String telefone;
	private String email;
	private Date ultimoAcesso;
	private Date primeiroAcesso;
	private String endereco;
	private String bairro;
	private String apelido;
	private byte[] foto;
	
	@Id
	@Override
	@Column(name = "codigo")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	
	@ManyToOne
	@JoinColumn(name="usuario_cadastro")
	public UsuarioEntity getUsuarioCadastro() {
		return usuarioCadastro;
	}
	public void setUsuarioCadastro(UsuarioEntity usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}
	
	@Column(name="data_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="nascimento")
	@Temporal(TemporalType.DATE)
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
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
	
	@Column(name="data_ultimo_acesso")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getUltimoAcesso() {
		return ultimoAcesso;
	}
	public void setUltimoAcesso(Date ultimoAcesso) {
		this.ultimoAcesso = ultimoAcesso;
	}
	
	@Column(name="data_primeiro_acesso")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getPrimeiroAcesso() {
		return primeiroAcesso;
	}
	public void setPrimeiroAcesso(Date primeiroAcesso) {
		this.primeiroAcesso = primeiroAcesso;
	}
	
	@Column(name="endereco")
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Column(name="bairro")
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	@Column(name="apelido")
	public String getApelido() {
		return apelido;
	}
	public void setApelido(String apelido) {
		this.apelido = apelido;
	}
	
	@Column(name="foto_cliente")
	public byte[] getFoto() {
		return foto;
	}
	public void setFoto(byte[] foto) {
		this.foto = foto;
	}
	

}
