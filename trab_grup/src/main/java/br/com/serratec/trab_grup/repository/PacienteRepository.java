package br.com.serratec.trab_grup.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.serratec.trab_grup.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {

}
