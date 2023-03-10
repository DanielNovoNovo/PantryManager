package com.PantryInc.pantrymanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "Ingredientes")
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

    @OneToMany(mappedBy = "ingrediente") // Referencia al atributo Receta receta de la clase intermedia RecetaToIngrediente
    private Set<RecetaToIngrediente> recetas;

    @OneToMany(mappedBy = "ingrediente") // Referencia al atributo Receta receta de la clase intermedia UsuarioToIngrediente
    private Set<UsuarioToIngrediente> usuarios;

    public Ingrediente(String nombre, String tipo, int calorias, String imagen) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.calorias = calorias;
        this.imagen = imagen;
    }
}
