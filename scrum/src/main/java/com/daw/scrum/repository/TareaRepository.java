package com.daw.scrum.repository;

import com.daw.scrum.model.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Long> {
    List<Tarea> findBySprintId(Long sprintId);
}

