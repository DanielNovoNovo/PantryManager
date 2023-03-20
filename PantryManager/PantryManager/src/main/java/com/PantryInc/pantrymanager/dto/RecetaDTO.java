package com.PantryInc.pantrymanager.dto;

import com.PantryInc.pantrymanager.model.Receta;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RecetaDTO {

    private Integer Id;

    private String nombre;

    private String pasos;

    private int tiempo_preparacion;

    private String dificultad;

    private String tipo_comida;

    private String autor;

    private String enlace;

    private String estado;

    private int votos_positivos;

    private int votos_negativos;

    private int votos_totales;

    private int es_personalizada;

    public RecetaDTO(Receta receta) {

    }

    public Receta convertirModel(){

    Receta receta = new Receta();
    receta.setId(this.Id);
    receta.setNombre(this.nombre);
    receta.setPasos(this.pasos);
    receta.setTiempo_preparacion(this.tiempo_preparacion);
    receta.setDificultad(this.dificultad);
    receta.setTipo_comida(this.tipo_comida);
    receta.setAutor(this.autor);
    receta.setEnlace(this.enlace);
    receta.setEstado(this.estado);
    receta.setVotos_positivos(this.votos_positivos);
    receta.setVotos_negativos(this.votos_negativos);
    receta.setVotos_totales(this.votos_totales);
    receta.setEs_personalizada(this.es_personalizada);
    return receta;

    }

    public RecetaDTO crearDTO(Receta receta){
        this.setId(receta.getId());
        this.setNombre(receta.getNombre());
        this.setPasos(receta.getPasos());
        this.setTiempo_preparacion(receta.getTiempo_preparacion());
        this.setDificultad(receta.getDificultad());
        this.setTipo_comida(receta.getTipo_comida());
        this.setAutor(receta.getAutor());
        this.setEnlace(receta.getEnlace());
        this.setEstado(receta.getEstado());
        this.setVotos_positivos(receta.getVotos_positivos());
        this.setVotos_negativos(receta.getVotos_negativos());
        this.setVotos_totales(receta.getVotos_totales());
        this.setEs_personalizada(receta.getEs_personalizada());
        return this;
    }

}
