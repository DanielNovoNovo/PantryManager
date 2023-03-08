package com.PantryInc.pantrymanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;


@Entity
@Table(name = "Receta")
@NoArgsConstructor //lombok - Crea
@AllArgsConstructor
@Data
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id")
    private Integer id;

    @Column(name = "Nombre")
    private String nombre;

    @Column(name = "Pasos")
    private String pasos;

    @Column(name = "Tiempo_preparacion")
    private int tiempo_preparacion;

    @Column(name = "Dificultad")
    private String dificultad;

    @Column(name = "Tipo_comida")
    private String tipo_comida;

    @Column(name = "Autor")
    private String autor;

    @Column(name = "Enlace")
    private String enlace;

    @OneToMany(mappedBy = "receta")
    private Set<RecetaToIngrediente> recetaToIngrediente;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPasos() {
        return pasos;
    }

    public void setPasos(String pasos) {
        this.pasos = pasos;
    }

    public int getTiempo_preparacion() {
        return tiempo_preparacion;
    }

    public void setTiempo_preparacion(int tiempo_preparacion) {
        this.tiempo_preparacion = tiempo_preparacion;
    }

    public String getDificultad() {
        return dificultad;
    }

    public void setDificultad(String dificultad) {
        this.dificultad = dificultad;
    }

    public String getTipo_comida() {
        return tipo_comida;
    }

    public void setTipo_comida(String tipo_comida) {
        this.tipo_comida = tipo_comida;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String enlace) {
        this.enlace = enlace;
    }

    public Set<RecetaToIngrediente> getRecetaToIngrediente() {
        return recetaToIngrediente;
    }

    public void setRecetaToIngrediente(Set<RecetaToIngrediente> recetaToIngrediente) {
        this.recetaToIngrediente = recetaToIngrediente;
    }
}
