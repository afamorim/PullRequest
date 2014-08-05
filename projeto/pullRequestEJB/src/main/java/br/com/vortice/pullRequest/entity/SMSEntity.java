package br.com.vortice.pullRequest.entity;

import java.sql.Timestamp;

public class SMSEntity extends PullRequestEntity {
	
	private Long codigo;
	private String conteudo;
	private String destino;
	private Timestamp dataEnvio;
	private Timestamp dataConfirmacao;
	private Timestamp dataCadastro;
	private Timestamp dataAgendamentoEnvio;
	private Integer statusEntrega;
	private Integer retornoEntrega;
	private Integer codigoFornecedorGateway;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}
	public String getConteudo() {
		return conteudo;
	}
	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}
	public String getDestino() {
		return destino;
	}
	public void setDestino(String destino) {
		this.destino = destino;
	}
	public Timestamp getDataEnvio() {
		return dataEnvio;
	}
	public void setDataEnvio(Timestamp dataEnvio) {
		this.dataEnvio = dataEnvio;
	}
	public Timestamp getDataConfirmacao() {
		return dataConfirmacao;
	}
	public void setDataConfirmacao(Timestamp dataConfirmacao) {
		this.dataConfirmacao = dataConfirmacao;
	}
	public Timestamp getDataCadastro() {
		return dataCadastro;
	}
	public void setDataCadastro(Timestamp dataCadastro) {
		this.dataCadastro = dataCadastro;
	}
	public Timestamp getDataAgendamentoEnvio() {
		return dataAgendamentoEnvio;
	}
	public void setDataAgendamentoEnvio(Timestamp dataAgendamentoEnvio) {
		this.dataAgendamentoEnvio = dataAgendamentoEnvio;
	}
	public Integer getStatusEntrega() {
		return statusEntrega;
	}
	public void setStatusEntrega(Integer statusEntrega) {
		this.statusEntrega = statusEntrega;
	}
	public Integer getRetornoEntrega() {
		return retornoEntrega;
	}
	public void setRetornoEntrega(Integer retornoEntrega) {
		this.retornoEntrega = retornoEntrega;
	}
	public Integer getCodigoFornecedorGateway() {
		return codigoFornecedorGateway;
	}
	public void setCodigoFornecedorGateway(Integer codigoFornecedorGateway) {
		this.codigoFornecedorGateway = codigoFornecedorGateway;
	}

}
