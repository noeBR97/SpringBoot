package com.daw.scrum.controller;

import com.daw.scrum.dto.TareaDTO;
import com.daw.scrum.service.TareaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tareas")
@CrossOrigin(origins = "*") // opcional
public class TareaController {

    @Autowired
    private TareaService tareaService;

    // ---------------------------------------------------------
    // POST: Crear tarea
    // ---------------------------------------------------------
    @PostMapping
    public TareaDTO crear(@RequestBody TareaDTO dto) {
        return tareaService.crear(dto);
    }

    // ---------------------------------------------------------
    // GET: Buscar tarea por ID
    // ---------------------------------------------------------
    @GetMapping("/{id}")
    public TareaDTO buscarPorId(@PathVariable Long id) {
        return tareaService.buscarPorId(id);
    }

    // ---------------------------------------------------------
    // GET: Listar todas las tareas
    // ---------------------------------------------------------
    @GetMapping
    public List<TareaDTO> obtenerTodas() {
        return tareaService.findAll();
    }
}

