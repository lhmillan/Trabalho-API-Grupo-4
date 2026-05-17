package br.com.serratec.trab_grup.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.trab_grup.model.Paciente;
import br.com.serratec.trab_grup.repository.PacienteRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

	@Autowired
	private PacienteRepository repository;

   
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Paciente inserirPaciente(@Valid @RequestBody Paciente paciente){
		return repository.save(paciente);
	}
	
	
	@PutMapping("{id}")
	public ResponseEntity<Paciente> atualizarPaciente(@Valid @RequestBody Paciente paciente, @PathVariable Long id){
		Optional<Paciente> pacienteOptional = repository.findById(id);
		if(pacienteOptional.isPresent()) {
			paciente.setCodigo(id);
			return ResponseEntity.ok(repository.save(paciente));
		}
		return ResponseEntity.notFound().build();
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<Void> apagarPaciente(@PathVariable Long id){
		if(repository.existsById(id)) {
			repository.deleteById(id);
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.notFound().build();
	}
	
	@GetMapping
	public List<Paciente> listarPaciente(){
		return repository.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Paciente> buscarPaciente(@PathVariable Long id){
		Optional<Paciente> pacienteOptional = repository.findById(id);
		if(pacienteOptional.isPresent()) {
			return ResponseEntity.ok(pacienteOptional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
}
