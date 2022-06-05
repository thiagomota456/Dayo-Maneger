package br.dayo.management.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tarefa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String titulo;
	private String descricao;
	private String status;
	
	@ManyToOne
	@JoinColumn(name="projeto_id")
	@JsonIgnore
	private Projeto projeto;
	
	@ElementCollection
	@CollectionTable(name="Obcervacoes")
	@Column(name="obcervacoes")
	private List<String> observacoes = new ArrayList<>();
	
	private long dataDeCriacao;
	
	private long dataFinalizacao;
	
	private String horasTrabalhadas;
	
	private String tempoPrevisto;

	public Tarefa() {
		
	}
	
	public Tarefa(Integer id, String titulo, String descricao, String horasTrabalhadas, String tempoPrevisto, String status) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.status = status;
		this.horasTrabalhadas = horasTrabalhadas;
		this.tempoPrevisto = tempoPrevisto;
	}
	
	public Tarefa(Integer id, String titulo, String descricao, long dataDeCriacao, String horasTrabalhadas, String status) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataDeCriacao = dataDeCriacao;
		this.status = status;
		this.horasTrabalhadas = horasTrabalhadas;
	}
	
	public Tarefa(Integer id, String titulo, String descricao, long dataDeCriacao, String status) {
		this.id = id;
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataDeCriacao = dataDeCriacao;
		this.status = status;
	}
	
	public String getTempoPrevisto() {
		return tempoPrevisto;
	}

	public void setTempoPrevisto(String tempoPrevisto) {
		this.tempoPrevisto = tempoPrevisto;
	}


	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public long getDataDeCriacao() {
		return dataDeCriacao;
	}

	public void setDataDeCriacao(long dataDeCriacao) {
		this.dataDeCriacao = dataDeCriacao;
	}

	public long getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(long dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public void setObcervacoes(List<String> obcervacoes) {
		this.observacoes = obcervacoes;
	}

	public Projeto getProjeto() {
		return projeto;
	}

	public void setProjeto(Projeto projeto) {
		this.projeto = projeto;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<String> getObservacoes() {
		return observacoes;
	}

	public void setObservacao(String observacoes) {
		this.observacoes.add(observacoes);
	}
	
	public void setObcervacao(List<String> obcervacoes) {
		this.observacoes = obcervacoes;
	}

	public String getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(String horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDeCriacao, dataFinalizacao, descricao, horasTrabalhadas, id, observacoes, projeto,
				status, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tarefa other = (Tarefa) obj;
		return Objects.equals(dataDeCriacao, other.dataDeCriacao)
				&& Objects.equals(dataFinalizacao, other.dataFinalizacao) && Objects.equals(descricao, other.descricao)
				&& Objects.equals(id, other.id) && Objects.equals(observacoes, other.observacoes)
				&& Objects.equals(projeto, other.projeto) && Objects.equals(status, other.status)
				&& Objects.equals(titulo, other.titulo);
	}
	
}
