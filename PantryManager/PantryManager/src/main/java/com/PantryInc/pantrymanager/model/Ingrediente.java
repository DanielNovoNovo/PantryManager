package com.PantryInc.pantrymanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "Ingrediente")
@NoArgsConstructor
@AllArgsConstructor
@Data

public class Ingrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Tipo")
    private String tipo;
    @Column(name = "Calorias")
    private int calorias;
    @Column(name = "Imagen")
    private String imagen;
    @OneToMany(mappedBy = "ingrediente")
    private Set<RecetaToIngrediente> recetaToIngrediente;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCalorias() {
        return calorias;
    }

    public void setCalorias(int calorias) {
        this.calorias = calorias;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Set<RecetaToIngrediente> getRecetaToIngrediente() {
        return recetaToIngrediente;
    }
    public void setRecetaToIngrediente(Set<RecetaToIngrediente> recetaToIngrediente) {
        this.recetaToIngrediente = recetaToIngrediente;
    }

}
