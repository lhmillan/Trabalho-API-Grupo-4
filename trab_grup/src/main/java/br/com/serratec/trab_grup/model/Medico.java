package br.com.serratec.trab_grup.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
public class Medico extends Pessoa{
	
	@NotBlank(message = "Preencha o crm")
	@Size(max = 14, message = "Maximo de apenas 14 digitos")
	private String crm;
	
	private String especialidade;
	
	@OneToMany(mappedBy = "medico")
	private List<Consulta> consultas;
	
	public String getCrm() {
		return crm;
	}
	public void setCrm(String crm) {
		this.crm = crm;
	}
	
	public String getEspecialidade() {
		return especialidade;
	}
	
	public void setEspecialidade(String especialidade) {
		this.especialidade = especialidade;
	}
	
	public List<Consulta> getConsultas() {
		return consultas;
	}
	
	
	
}
