package br.dayo.management.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

public class TarefaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	private Integer projetoID;
	
	private String titulo;
	
	private String descricao;

	private long dataDeCriacao;

	private long dataFinalizacao;
	
	private String tempoPrevisto;
	
	private List<String> obcervacoes = new ArrayList<>();
	
	private String status; 
	
	private String horasTrabalhadas;
	
	public TarefaDTO() {
	}
	
	public TarefaDTO(@Size(min = 1, message = "Preenchimento obrigatorio") Integer projetoID, @NotEmpty(message = "Preenchimento obrigatorio") String titulo,
			@NotEmpty(message = "Preenchimento obrigatorio") String descricao, long dataDeCriacao, long dataFinalizacao, String status, String horasTrabalhadas, String tempoPrevisto) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.dataDeCriacao = dataDeCriacao;
		this.dataFinalizacao = dataFinalizacao;
		this.status = status;
		this.projetoID = projetoID;
		this.horasTrabalhadas = horasTrabalhadas;
		this.tempoPrevisto = tempoPrevisto;
	}
	
	public String getTempoPrevisto() {
		return tempoPrevisto;
	}

	public void setTempoPrevisto(String tempoPrevisto) {
		this.tempoPrevisto = tempoPrevisto;
	}

	public Integer getProjetoID() {
		return this.projetoID;
	}
	
	public void setProjetoID(Integer projetoID) {
		this.projetoID = projetoID;
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
		this.obcervacoes = obcervacoes;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<String> getObcervacoes() {
		return obcervacoes;
	}

	public void setObcervacao(String obcervacoes) {
		this.obcervacoes.add(obcervacoes);
	}
	
	public void setObcervacao(List<String> obcervacoes) {
		this.obcervacoes = obcervacoes;
	}

	public String getHorasTrabalhadas() {
		return horasTrabalhadas;
	}

	public void setHorasTrabalhadas(String horasTrabalhadas) {
		this.horasTrabalhadas = horasTrabalhadas;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, titulo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TarefaDTO other = (TarefaDTO) obj;
		return Objects.equals(id, other.id) && Objects.equals(titulo, other.titulo);
	}


	
}
