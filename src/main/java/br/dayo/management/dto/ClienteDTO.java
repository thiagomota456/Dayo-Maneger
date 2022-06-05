package br.dayo.management.dto;

import java.io.Serializable;
import java.util.Objects;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import br.dayo.management.domain.Cliente;
import br.dayo.management.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteDTO implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	@Length(max = 50, message="o valor deve ter no máximo 50 caracteres")
	String nome;
	
	String sobre;
	
	@NotEmpty(message="Preenchimento obrigatorio!")
	@Email(message="Email inválido!")
	String email;
	
	String cpf;
	
	String cnpj;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	String endereco;

	@NotEmpty(message="Preenchimento obrigatorio")
	String cep;
	
	@NotEmpty(message="Preenchimento obrigatorio")
	String telefone;
	
	public ClienteDTO() {}
	
	public ClienteDTO(
			Integer id,
			@NotEmpty(message = "Preenchimento obrigatorio") @Length(max = 50, message = "o valor deve ter no máximo 50 caracteres") String nome,
			String sobre,
			@NotEmpty(message = "Preenchimento obrigatorio!") @Email(message = "Email inválido!") String email,
			String cpf, String cnpj,
			@NotEmpty(message = "Preenchimento obrigatorio") String endereco,
			@NotEmpty(message = "Preenchimento obrigatorio") String cep,
			@NotEmpty(message = "Preenchimento obrigatorio") String telefone) {
		super();
		this.nome = nome;
		this.sobre = sobre;
		this.email = email;
		this.cpf = cpf;
		this.cnpj = cnpj;
		this.endereco = endereco;
		this.cep = cep;
		this.telefone = telefone;
		this.id = id;
	}

	public ClienteDTO(Cliente obj) {
		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();
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

	public Integer getId() {
		return this.id;
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

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getSobre() {
		return sobre;
	}

	public void setSobre(String sobre) {
		this.sobre = sobre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cep, cpf, cnpj, email, endereco, id, nome, sobre, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ClienteDTO other = (ClienteDTO) obj;
		return Objects.equals(cep, other.cep) && Objects.equals(cpf, other.cpf	)
				&& Objects.equals(email, other.email) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(id, other.id) && Objects.equals(nome, other.nome)
				&& Objects.equals(sobre, other.sobre) && Objects.equals(telefone, other.telefone);
	}

	
}
