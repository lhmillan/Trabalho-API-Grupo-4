package br.com.serratec.trab_grup.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import br.com.serratec.trab_grup.model.Consulta;
import br.com.serratec.trab_grup.model.Paciente;
import br.com.serratec.trab_grup.repository.ConsultaRepository;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {
	
	@Autowired
	private ConsultaRepository repository;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Consulta inserirConsulta(@Valid @RequestBody Consulta consulta) {
		return repository.save(consulta);
	}
	
	@GetMapping
	public List<Consulta> listarConsulta(){
		return repository.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Consulta> buscarConsulta(@PathVariable Long id){
		Optional<Consulta> consultaOptional = repository.findById(id);
		if(consultaOptional.isPresent()) {
			return ResponseEntity.ok(consultaOptional.get());
		}
		return ResponseEntity.notFound().build();
	}
	
}
