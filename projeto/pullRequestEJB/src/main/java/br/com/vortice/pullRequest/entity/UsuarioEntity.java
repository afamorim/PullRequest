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
@Table(name="USUARIO")
public class UsuarioEntity extends PullRequestEntity {

	private static final long serialVersionUID = 231490282200875354L;
	
	private String					nome;
	private String					login;
	private String					senha;
	private Date					dataCadastro;
	private Date					dataUltimoAcesso;
	private Boolean					ativo;
	private PerfilEntity			perfil;
	
	private EstabelecimentoEntity	estabelecimento;
	
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

	@Column(name="login")
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}

	@Column(name="senha")
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Column(name="data_cadastro")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	@Column(name="data_ultimo_acesso")
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDataUltimoAcesso() {
		return dataUltimoAcesso;
	}
	public void setDataUltimoAcesso(Date dataUltimoAcesso) {
		this.dataUltimoAcesso = dataUltimoAcesso;
	}

	@Column(name="flg_ativo")
	public Boolean getAtivo() {
		return ativo;
	}
	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@ManyToOne
	@JoinColumn(name="perfil_codigo")
	public PerfilEntity getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilEntity perfil) {
		this.perfil = perfil;
	}

	@ManyToOne
	@JoinColumn(name="estabelecimento_codigo")
	public EstabelecimentoEntity getEstabelecimento() {
		return estabelecimento;
	}
	public void setEstabelecimento(EstabelecimentoEntity estabelecimento) {
		this.estabelecimento = estabelecimento;
	}
	
	
}