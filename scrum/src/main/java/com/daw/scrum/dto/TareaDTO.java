package com.daw.scrum.dto;

public class TareaDTO {
    private Long id;
    private String titulo;
    private String descripcion;
    private Integer storyPoints;
    private Long prioridadId;
    private String prioridadNombre;
    private Long estadoId;
    private String estadoNombre;
    private Long programadorId;
    private String programadorNombre;
    private Integer estimacionHoras;
    private Integer horasInvertidas;

    public TareaDTO() {}

    public TareaDTO(Long id, String titulo, String descripcion, Integer storyPoints, Long prioridadId, String prioridadNombre, Long estadoId, String estadoNombre, Long programadorId, String programadorNombre, Integer estimacionHoras, Integer horasInvertidas) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.storyPoints = storyPoints;
        this.prioridadId = prioridadId;
        this.prioridadNombre = prioridadNombre;
        this.estadoId = estadoId;
        this.estadoNombre = estadoNombre;
        this.programadorId = programadorId;
        this.programadorNombre = programadorNombre;
        this.estimacionHoras = estimacionHoras;
        this.horasInvertidas = horasInvertidas;
    }

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

    public Long getPrioridadId() {
        return prioridadId;
    }

    public void setPrioridadId(Long prioridadId) {
        this.prioridadId = prioridadId;
    }

    public String getPrioridadNombre() {
        return prioridadNombre;
    }

    public void setPrioridadNombre(String prioridadNombre) {
        this.prioridadNombre = prioridadNombre;
    }

    public Long getEstadoId() {
        return estadoId;
    }

    public void setEstadoId(Long estadoId) {
        this.estadoId = estadoId;
    }

    public String getEstadoNombre() {
        return estadoNombre;
    }

    public void setEstadoNombre(String estadoNombre) {
        this.estadoNombre = estadoNombre;
    }

    public Long getProgramadorId() {
        return programadorId;
    }

    public void setProgramadorId(Long programadorId) {
        this.programadorId = programadorId;
    }

    public String getProgramadorNombre() {
        return programadorNombre;
    }

    public void setProgramadorNombre(String programadorNombre) {
        this.programadorNombre = programadorNombre;
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

}
