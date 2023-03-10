package com.PantryInc.pantrymanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "almacenan")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioToIngrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "Id_usuario") // Referencia al campo Id_usuario de la tabla 'almacenan' de nuestra BD
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "Id_ingrediente") // Referencia al campo Id_ingrediente de la tabla 'almacenan' de nuestra BD
    private Ingrediente ingrediente;
    @Column(name = "Cantidad_almacenada")
    private int cantidadAlmacenada;

    public UsuarioToIngrediente(Usuario usuario, Ingrediente ingrediente, int cantidadAlmacenada) {
        this.usuario = usuario;
        this.ingrediente = ingrediente;
        this.cantidadAlmacenada = cantidadAlmacenada;
    }
}
