package com.daw.scrum.controller;

import com.daw.scrum.dto.SprintDTO;
import com.daw.scrum.dto.TareaDTO;
import com.daw.scrum.service.SprintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sprints")
public class SprintController {

    @Autowired
    private SprintService sprintService;

    @PostMapping
    public ResponseEntity<SprintDTO> crear(@RequestBody SprintDTO dto) {
        return ResponseEntity.ok(sprintService.crear(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SprintDTO> obtener(@PathVariable Long id) {
        return ResponseEntity.ok(sprintService.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<SprintDTO>> obtenerTodos() {
        return ResponseEntity.ok(sprintService.obtenerTodos());
    }

    @PatchMapping("/{id}/estado")
    public ResponseEntity<?> cambiarEstado(@PathVariable Long id,
                                           @RequestParam String estado) {
        sprintService.cambiarEstado(id, estado);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/tareas")
    public ResponseEntity<List<TareaDTO>> obtenerTareas(@PathVariable Long id) {
        return ResponseEntity.ok(sprintService.obtenerTareas(id));
    }
}

