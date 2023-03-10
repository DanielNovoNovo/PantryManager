package com.PantryInc.pantrymanager.dto;

import com.PantryInc.pantrymanager.model.Receta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecetaDTO {
    private Integer id;
    private String nombre;
    private String pasos;
    private int tiempoPreparacion;
    private String dificultad;
    private String tipoComida;
    private Integer idAutor;
    private String enlace;
    private String estado;
    private int votosPositivos;
    private int votosNegativos;
    private int votosTotales;
    private boolean esPersonalizada;

    public Receta toModel() {
        Receta receta = new Receta();

        receta.setId(this.id);
        receta.setNombre(this.nombre);
        receta.setPasos(this.pasos);
        receta.setTiempoPreparacion(this.tiempoPreparacion);
        receta.setDificultad(this.dificultad);
        receta.setTipoComida(this.tipoComida);
        receta.setEnlace(this.enlace);
        receta.setEstado(this.estado);
        receta.setVotosPositivos(this.votosPositivos);
        receta.setVotosNegativos(this.votosNegativos);
        receta.setVotosTotales(this.votosTotales);
        receta.setEsPersonalizada(this.esPersonalizada);

        return receta;
    }

    public RecetaDTO toDTO(Receta receta) {
        this.setId(receta.getId());
        this.setNombre(receta.getNombre());
        this.setPasos(receta.getPasos());
        this.setTiempoPreparacion(receta.getTiempoPreparacion());
        this.setDificultad(receta.getDificultad());
        this.setTipoComida(receta.getTipoComida());
        this.setEnlace(receta.getEnlace());
        this.setEstado(receta.getEstado());
        this.setVotosPositivos(receta.getVotosPositivos());
        this.setVotosNegativos(receta.getVotosNegativos());
        this.setVotosTotales(receta.getVotosTotales());
        this.setEsPersonalizada(receta.isEsPersonalizada());

        return this;
    }
}
