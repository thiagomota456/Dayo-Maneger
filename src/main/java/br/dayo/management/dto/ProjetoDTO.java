package br.dayo.management.dto;

import java.io.Serializable;

public class ProjetoDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer clienteID;
	
	private Integer id;
	
	private String nome;
	
	private long dataDeCriacao;
	
	private long dataDeInicio;
	
	private long dataDeEntrega;
	
	private String descricao;
	
	public ProjetoDTO(Integer id, Integer clienteID, String nome, long dataDeCriacao,
			long dataDeInicio, long dataDeEntrega, String descricao) {
		this.clienteID = clienteID;
		this.nome = nome;
		this.dataDeCriacao = dataDeCriacao;
		this.dataDeInicio = dataDeInicio;
		this.dataDeEntrega = dataDeEntrega;
		this.descricao = descricao;
		this.id = id;
	}
	
	public long getDataDeEntrega() {
		return this.dataDeEntrega;
	}

	public void setDataDeEntrega(long dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}
	
	public Integer getClienteID() {
		return clienteID;
	}

	public void setClienteID(Integer clienteID) {
		this.clienteID = clienteID;
	}

	public long getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(long dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public long getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(long dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}
}
