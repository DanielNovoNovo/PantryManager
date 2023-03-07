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
        return this;
    }



}
