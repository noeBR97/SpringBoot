package com.daw.scrum.service;

import com.daw.scrum.dto.ProgramadorDTO;
import com.daw.scrum.model.Programador;
import com.daw.scrum.model.Rol;
import com.daw.scrum.repository.ProgramadorRepository;
import com.daw.scrum.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramadorService {

    @Autowired
    private ProgramadorRepository programadorRepository;

    @Autowired
    private RolRepository rolRepository;

    // -----------------------------
    // Crear programador
    // -----------------------------

    public ProgramadorDTO crear(ProgramadorDTO dto) {

        Rol rol = rolRepository.findById(dto.getRolId())
                .orElseThrow(() -> new RuntimeException("Rol no encontrado"));

        Programador p = new Programador();

        p.setNombre(dto.getNombre());
        p.setEmail(dto.getEmail());
        p.setRol(rol);
        p.setCapacidad(dto.getCapacidad());

        programadorRepository.save(p);

        return new ProgramadorDTO(
                p.getId(),
                p.getNombre(),
                p.getEmail(),
                p.getRol().getId(),
                p.getRol().getNombre(),
                p.getCapacidad()
        );
    }

    // -----------------------------
    // Buscar por nombre
    // -----------------------------

    public List<ProgramadorDTO> buscarPorNombre(String nombre) {
        return programadorRepository.findByNombreContainingIgnoreCase(nombre)
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // -----------------------------
    // Buscar por rol
    // -----------------------------

    public List<ProgramadorDTO> buscarPorRol(Long rolId) {
        return programadorRepository.findByRolId(rolId)
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // -----------------------------
    // Buscar por ID
    // -----------------------------

    public ProgramadorDTO buscarPorId(Long id) {
        Programador p = programadorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Programador no encontrado"));

        return convertirADTO(p);
    }

    // -----------------------------
    // Listar todos los programadores
    // -----------------------------

    public List<ProgramadorDTO> obtenerTodos() {
        return programadorRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .toList();
    }

    // -----------------------------
    // Conversor entidad → DTO
    // -----------------------------

    private ProgramadorDTO convertirADTO(Programador p) {
        return new ProgramadorDTO(
                p.getId(),
                p.getNombre(),
                p.getEmail(),
                p.getRol().getId(),
                p.getRol().getNombre(),
                p.getCapacidad()
        );
    }
}
