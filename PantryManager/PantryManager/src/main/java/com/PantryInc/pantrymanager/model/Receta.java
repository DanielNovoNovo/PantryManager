package com.PantryInc.pantrymanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


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


}
