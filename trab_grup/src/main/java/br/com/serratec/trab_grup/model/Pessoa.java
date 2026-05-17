package br.com.serratec.trab_grup.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class Pessoa {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long codigo;
	
	@NotBlank(message = "Preencha o nome") 
	//@Max(value = 60, message = "Tamanho maximo de 60 char")
	@Size(max = 60, message = "Tamanho maximo de 60 char")
	protected String nome;
	@NotBlank(message = "Preencha o nome")
	@Email(message = "Email invalido")
	protected String email;
	//nao usar  @Max(value = 11) pois aceita soemnte tipos numericos
	@Size(max=11, message = "Maximo de apenas 11 digitos")
	@Pattern(regexp = "^\\d{10,11}$", message = "Apenas numeros")
	protected String telefone;
	
	public Long getCodigo() {
		return codigo;
	}
	public void setCodigo(Long codigo) {
		this.codigo = codigo;
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
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	
	
}
