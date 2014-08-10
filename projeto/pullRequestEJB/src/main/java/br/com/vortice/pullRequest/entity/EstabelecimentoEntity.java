package br.com.vortice.pullRequest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.validator.NotNull;

@Entity
@Table(name="ESTABELECIMENTO")
public class EstabelecimentoEntity extends PullRequestEntity{

	private static final long serialVersionUID = 1064864526905921703L;
	private String	nome;
	private Date	dataCadastro;
	private String	telefone;
	private Integer	quantidadeTotalVagas;
	private String	urlLogo;
	private String	email;
	private String	endereco;
	private String	localizacaoGoogleMaps;
	private UsuarioEntity	responsavelEstabelecimento;
	private UsuarioEntity	usuarioCadastro;
	
	
	@Override
	@Id
	public Long getCodigo() {
		return super.getCodigo();
	}
	@Override
	public void setCodigo(Long codigo) {
		super.setCodigo(codigo);
	}
	
	@NotNull(message="O Nome do estabelecimento não pode ser vazio.")
	@Column(name="nome")
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	@Column(name="data_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
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
	
	@Column(name="quantidade_total_vagas")
	public Integer getQuantidadeTotalVagas() {
		return quantidadeTotalVagas;
	}
	public void setQuantidadeTotalVagas(Integer quantidadeTotalVagas) {
		this.quantidadeTotalVagas = quantidadeTotalVagas;
	}
	
	@Column(name="url_logo")
	public String getUrlLogo() {
		return urlLogo;
	}
	public void setUrlLogo(String urlLogo) {
		this.urlLogo = urlLogo;
	}
	
	@Column(name="email")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="endereco")
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
	@Column(name="localizacao_google_maps")
	public String getLocalizacaoGoogleMaps() {
		return localizacaoGoogleMaps;
	}
	public void setLocalizacaoGoogleMaps(String localizacaoGoogleMaps) {
		this.localizacaoGoogleMaps = localizacaoGoogleMaps;
	}
	
	@OneToOne
	@JoinColumn(name="responsavel_estabelecimento_codigo")
	public UsuarioEntity getResponsavelEstabelecimento() {
		return responsavelEstabelecimento;
	}
	public void setResponsavelEstabelecimento(UsuarioEntity responsavelEstabelecimento) {
		this.responsavelEstabelecimento = responsavelEstabelecimento;
	}
	
	@ManyToOne
	@JoinColumn(name="usuario_cadastro_codigo")
	public UsuarioEntity getUsuarioCadastro() {
		return usuarioCadastro;
	}
	public void setUsuarioCadastro(UsuarioEntity usuarioCadastro) {
		this.usuarioCadastro = usuarioCadastro;
	}
}