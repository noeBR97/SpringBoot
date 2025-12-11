package com.daw.scrum.service;

import com.daw.scrum.dto.TareaDTO;
import com.daw.scrum.model.Estado;
import com.daw.scrum.model.Prioridad;
import com.daw.scrum.model.Programador;
import com.daw.scrum.model.Tarea;
import com.daw.scrum.repository.EstadoRepository;
import com.daw.scrum.repository.PrioridadRepository;
import com.daw.scrum.repository.ProgramadorRepository;
import com.daw.scrum.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;
    @Autowired
    private ProgramadorRepository programadorRepository;
    @Autowired
    private PrioridadRepository prioridadRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    // ---------------------------------------------------------
    // CREAR TAREA
    // ---------------------------------------------------------
    public TareaDTO crear(TareaDTO dto) {

        Programador programador = programadorRepository.findById(dto.getProgramadorId())
                .orElseThrow(() -> new RuntimeException("Programador no encontrado"));

        Prioridad prioridad = prioridadRepository.findById(dto.getPrioridadId())
                .orElseThrow(() -> new RuntimeException("Prioridad no encontrada"));

        Estado estado = estadoRepository.findById(dto.getEstadoId())
                .orElseThrow(() -> new RuntimeException("Estado no encontrado"));

        Tarea t = new Tarea();
        t.setTitulo(dto.getTitulo());
        t.setDescripcion(dto.getDescripcion());
        t.setStoryPoints(dto.getStoryPoints());
        t.setPrioridad(prioridad);
        t.setEstado(estado);
        t.setProgramadorResponsable(programador);
        t.setEstimacionHoras(dto.getEstimacionHoras());
        t.setHorasInvertidas(0);

        tareaRepository.save(t);

        return convertirADTO(t);
    }

    // ---------------------------------------------------------
    // BUSCAR POR ID
    // ---------------------------------------------------------
    public TareaDTO buscarPorId(Long id) {
        Tarea t = tareaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Tarea no encontrada"));

        return convertirADTO(t);
    }

    // ---------------------------------------------------------
    // LISTAR TODAS LAS TAREAS
    // ---------------------------------------------------------
    public List<TareaDTO> findAll() {
        return tareaRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // ---------------------------------------------------------
    // CONVERTIR TAREA → DTO
    // ---------------------------------------------------------
    private TareaDTO convertirADTO(Tarea t) {
        return new TareaDTO(
                t.getId(),
                t.getTitulo(),
                t.getDescripcion(),
                t.getStoryPoints(),

                t.getPrioridad() != null ? t.getPrioridad().getId() : null,
                t.getPrioridad() != null ? t.getPrioridad().getNombre() : null,

                t.getEstado() != null ? t.getEstado().getId() : null,
                t.getEstado() != null ? t.getEstado().getNombre() : null,

                t.getProgramadorResponsable() != null ? t.getProgramadorResponsable().getId() : null,
                t.getProgramadorResponsable() != null ? t.getProgramadorResponsable().getNombre() : null,

                t.getEstimacionHoras(),
                t.getHorasInvertidas()
        );
    }
}
