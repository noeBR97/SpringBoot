package com.daw.scrum.service;

import com.daw.scrum.dto.SprintDTO;
import com.daw.scrum.dto.TareaDTO;
import com.daw.scrum.model.Sprint;
import com.daw.scrum.model.EstadoSprint;
import com.daw.scrum.repository.SprintRepository;
import com.daw.scrum.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SprintService {

    @Autowired
    private SprintRepository sprintRepository;

    @Autowired
    private TareaRepository tareaRepository;

    public SprintDTO crear(SprintDTO dto) {
        Sprint s = new Sprint();
        s.setNombre(dto.getNombre());
        s.setFechaInicio(dto.getFechaInicio());
        s.setFechaFin(dto.getFechaFin());
        s.setObjetivo(dto.getObjetivo());
        s.setEstado(EstadoSprint.valueOf(dto.getEstado()));

        sprintRepository.save(s);

        return convertirADTO(s);
    }

    public SprintDTO buscarPorId(Long id) {
        Sprint s = sprintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sprint no encontrado"));

        return convertirADTO(s);
    }

    public List<SprintDTO> obtenerTodos() {
        return sprintRepository.findAll()
                .stream().map(this::convertirADTO)
                .toList();
    }

    public void cambiarEstado(Long id, String estado) {
        Sprint s = sprintRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Sprint no encontrado"));

        s.setEstado(EstadoSprint.valueOf(estado));
        sprintRepository.save(s);
    }

    // ---- TAREAS ASOCIADAS AL SPRINT ----
    public List<TareaDTO> obtenerTareas(Long sprintId) {
        var tareas = tareaRepository.findBySprintId(sprintId);

        if (tareas.size() < 3)
            throw new RuntimeException("El sprint debe tener al menos 3 tareas");

        return tareas.stream().map(t -> new TareaDTO(
                t.getId(), t.getTitulo(), t.getDescripcion(),
                t.getStoryPoints(),
                t.getPrioridad().getId(), t.getPrioridad().getNombre(),
                t.getEstado().getId(), t.getEstado().getNombre(),
                t.getProgramadorResponsable().getId(),
                t.getProgramadorResponsable().getNombre(),
                t.getEstimacionHoras(), t.getHorasInvertidas()
        )).toList();
    }

    private SprintDTO convertirADTO(Sprint s) {
        return new SprintDTO(
                s.getId(),
                s.getNombre(),
                s.getFechaInicio(),
                s.getFechaFin(),
                s.getObjetivo(),
                s.getEstado().name()
        );
    }
}

