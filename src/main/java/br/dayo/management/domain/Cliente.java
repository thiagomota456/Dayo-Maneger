package br.dayo.management.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String nome;
	private String sobre;
	@Column(unique = true)
	private String email;
	private String cpf;
	private String cnpj;
	private String telefone;
	private String endereco;
	private String cep;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
	private List<Projeto> projetos = new ArrayList<>();

	public Cliente() {}
	
	public Cliente(Integer id, String nome, String sobre, String email, String cpf, String cnpj, String telefone, String cep, String endereco) {
		this.id = id;
		this.nome = nome;
		this.sobre = sobre;
		this.email = email;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.telefone = telefone;
		this.cep = cep;
		this.endereco = endereco;
	}
	
	public String getCnpj() {
		return this.cnpj;
	}
	
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getEndereco() {
		return this.endereco;
	}
	
	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpfOuCnpj) {
		this.cpf = cpfOuCnpj;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public void setProjetos(List<Projeto> projetos) {
		this.projetos = projetos;
	}
	
	public List<Projeto> getProjetos(){
		return this.projetos;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, cpf, email, endereco, id, nome, projetos, sobre, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cpf, other.cpf)
				&& Objects.equals(email, other.email) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(projetos, other.projetos) && Objects.equals(sobre, other.sobre)
				&& Objects.equals(telefone, other.telefone);
	}

		
}
