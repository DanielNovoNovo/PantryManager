package com.PantryInc.pantrymanager.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "almacena")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UsuarioToIngrediente {
    private int id;
    private int idUsuario;
    private int idIngrediente;
    private int cantidadAlmacenada;


}
