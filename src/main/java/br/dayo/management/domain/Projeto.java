package br.dayo.management.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Projeto implements Serializable {
	public static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	
	private String descricao;
	
	private long dataDeCriacao;
	
	private long dataDeInicio;

	private long dataDeEntrega;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="projeto")
	private List<Tarefa> tarefas = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	@JsonIgnore
	private Cliente cliente;
	
	public Projeto() {}
	
	public Projeto(Integer id, String nome, long dataDeCriacao, long dataDeInicio, long dataDeEntrega, String descricao,
			Cliente cliente) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataDeCriacao = dataDeCriacao;
		this.dataDeInicio = dataDeInicio;
		this.dataDeEntrega = dataDeEntrega;
		this.descricao = descricao;
		this.cliente = cliente;
	}
	
	public Projeto(Integer id, String nome, long dataDeCriacao, long dataDeInicio, long dataDeEntrega, String descricao) {
		super();
		this.id = id;
		this.nome = nome;
		this.dataDeCriacao = dataDeCriacao;
		this.dataDeInicio = dataDeInicio;
		this.dataDeEntrega = dataDeEntrega;
		this.descricao = descricao;
	}

	public String getNome() {
		return this.nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public long getDataDeCriacao() {
		return this.dataDeCriacao;
	}
	
	public void setDataDeCriacao(long data) {
		this.dataDeCriacao = data;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public long getDataDeInicio() {
		return dataDeInicio;
	}

	public void setDataDeInicio(long dataDeInicio) {
		this.dataDeInicio = dataDeInicio;
	}

	public long getDataDeEntrega() {
		return this.dataDeEntrega;
	}

	public void setDataDeEntrega(long dataDeEntrega) {
		this.dataDeEntrega = dataDeEntrega;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDeEntrega, cliente, dataDeCriacao, dataDeInicio, descricao, id, nome);
	}
	
	public List<Tarefa> getTarefas() {
		return tarefas;
	}

	public void setTarefas(List<Tarefa> tarefas) {
		this.tarefas = tarefas;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Projeto other = (Projeto) obj;
		return Objects.equals(dataDeEntrega, other.dataDeEntrega) && Objects.equals(cliente, other.cliente)
				&& Objects.equals(dataDeCriacao, other.dataDeCriacao)
				&& Objects.equals(dataDeInicio, other.dataDeInicio) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome);
	}
}
