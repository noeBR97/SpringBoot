package com.daw.scrum.controller;

import com.daw.scrum.dto.ProgramadorDTO;
import com.daw.scrum.service.ProgramadorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programadores")
@CrossOrigin(origins = "*") // opcional
public class ProgramadorController {

    @Autowired
    private ProgramadorService programadorService;

    // ---------------------------------------------------------
    // POST: Crear programador
    // ---------------------------------------------------------
    @PostMapping
    public ProgramadorDTO crear(@RequestBody ProgramadorDTO dto) {
        return programadorService.crear(dto);
    }

    // ---------------------------------------------------------
    // GET: Buscar programadores por nombre
    // ---------------------------------------------------------
    @GetMapping("/nombre/{nombre}")
    public List<ProgramadorDTO> buscarPorNombre(@PathVariable String nombre) {
        return programadorService.buscarPorNombre(nombre);
    }

    // ---------------------------------------------------------
    // GET: Buscar programadores por rol
    // ---------------------------------------------------------
    @GetMapping("/rol/{rolId}")
    public List<ProgramadorDTO> buscarPorRol(@PathVariable Long rolId) {
        return programadorService.buscarPorRol(rolId);
    }

    // ---------------------------------------------------------
    // GET: Buscar programador por ID
    // ---------------------------------------------------------
    @GetMapping("/{id}")
    public ProgramadorDTO buscarPorId(@PathVariable Long id) {
        return programadorService.buscarPorId(id);
    }

    // ---------------------------------------------------------
    // GET: Listar todos los programadores
    // ---------------------------------------------------------
    @GetMapping
    public List<ProgramadorDTO> obtenerTodos() {
        return programadorService.obtenerTodos();
    }
}

