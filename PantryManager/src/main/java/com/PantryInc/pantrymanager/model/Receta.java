package com.PantryInc.pantrymanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "Recetas")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Receta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Pasos")
    private String pasos;
    @Column(name = "Tiempo_preparacion")
    private Integer tiempoPreparacion;
    @Column(name = "Dificultad")
    private String dificultad;
    @Column(name = "Tipo_comida")
    private String tipoComida;
    @Column(name = "enlace")
    private String enlace;
    @Column(name = "estado")
    private String estado;
    @Column(name = "Votos_positivos")
    private int votosPositivos;
    @Column(name = "Votos_negativos")
    private int votosNegativos;
    @Column(name = "Votos_totales")
    private int votosTotales;
    @Column(name = "Es_personalizada")
    private boolean esPersonalizada;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "Id_autor", referencedColumnName = "id")
    // Referencias a los campos Id_autor de la tabla Recetas e id de la tabla Autores
    private Autor autor;
    @OneToMany(mappedBy = "receta") // Referencia al atributo Receta receta de la clase intermedia RecetaToIngrediente
    private Set<RecetaToIngrediente> ingredientes;

    @OneToMany(mappedBy = "receta") // Referencia al atributo Receta receta de la clase intermedia UsuarioToReceta
    private Set<UsuarioToReceta> usuarios;

    public Receta(String nombre, String pasos, Integer tiempoPreparacion, String dificultad, String tipoComida, String enlace, String estado, int votosPositivos, int votosNegativos, int votosTotales, boolean esPersonalizada, Autor autor) {
        this.nombre = nombre;
        this.pasos = pasos;
        this.tiempoPreparacion = tiempoPreparacion;
        this.dificultad = dificultad;
        this.tipoComida = tipoComida;
        this.enlace = enlace;
        this.estado = estado;
        this.votosPositivos = votosPositivos;
        this.votosNegativos = votosNegativos;
        this.votosTotales = votosTotales;
        this.esPersonalizada = esPersonalizada;
        this.autor = autor;
    }

    public void addIngrediente(Ingrediente ingrediente, int cantidad) {
        RecetaToIngrediente recetaToIngrediente = new RecetaToIngrediente(this, ingrediente, cantidad);
        ingredientes.add(recetaToIngrediente);
        ingrediente.getRecetas().add(recetaToIngrediente);
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
        autor.getRecetas().add(this);
    }
}
