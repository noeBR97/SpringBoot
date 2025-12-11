package com.daw.scrum.repository;

import com.daw.scrum.model.Programador;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProgramadorRepository extends JpaRepository<Programador, Long> {
    List<Programador> findByNombreContainingIgnoreCase(String nombre);
    List<Programador> findByRolId(Long rolId);
}
