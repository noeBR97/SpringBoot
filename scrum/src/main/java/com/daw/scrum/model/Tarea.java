package com.daw.scrum.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Tarea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descripcion;
    private Integer storyPoints; // 0 - 100

    @ManyToOne
    private Prioridad prioridad;

    @ManyToOne
    private Estado estado;

    @ManyToOne(optional = false)
    private Programador programadorResponsable;

    @ManyToOne
    @JoinColumn(name = "sprint_id", nullable = false)
    private Sprint sprint;

    private Integer estimacionHoras;
    private Integer horasInvertidas;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    public void setCreationDate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    public void setUpdateDate() {
        updatedAt = LocalDateTime.now();
    }

    @ManyToMany
    @JoinTable(
            name = "tarea_etiqueta",
            joinColumns = @JoinColumn(name = "tarea_id"),
            inverseJoinColumns = @JoinColumn(name = "etiqueta_id")
    )
    private Set<Etiqueta> etiquetas = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getStoryPoints() {
        return storyPoints;
    }

    public void setStoryPoints(Integer storyPoints) {
        this.storyPoints = storyPoints;
    }

    public Prioridad getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(Prioridad prioridad) {
        this.prioridad = prioridad;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Programador getProgramadorResponsable() {
        return programadorResponsable;
    }

    public void setProgramadorResponsable(Programador programadorResponsable) {
        this.programadorResponsable = programadorResponsable;
    }

    public Integer getEstimacionHoras() {
        return estimacionHoras;
    }

    public void setEstimacionHoras(Integer estimacionHoras) {
        this.estimacionHoras = estimacionHoras;
    }

    public Integer getHorasInvertidas() {
        return horasInvertidas;
    }

    public void setHorasInvertidas(Integer horasInvertidas) {
        this.horasInvertidas = horasInvertidas;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Sprint getSprint() {
        return sprint;
    }

    public void setSprint(Sprint sprint) {
        this.sprint = sprint;
    }

    public Set<Etiqueta> getEtiquetas() {
        return etiquetas;
    }

    public void setEtiquetas(Set<Etiqueta> etiquetas) {
        this.etiquetas = etiquetas;
    }
}

