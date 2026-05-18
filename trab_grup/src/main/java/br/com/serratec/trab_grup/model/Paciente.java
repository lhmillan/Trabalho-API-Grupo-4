package br.com.serratec.trab_grup.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Paciente extends Pessoa {
	
	
	
	//@CPF(message = "cpf invalido")
	@NotBlank(message = "Preencha o CPF")
	@Size(max = 14, message = "Deve ser menor que 14 digitos")
	private String cpf;
	
	@OneToMany(mappedBy = "paciente")
	private List<Consulta> consultas;
	
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public List<Consulta> getConsultas() {
		return consultas;
	}
	
	
}
