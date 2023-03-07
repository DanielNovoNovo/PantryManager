package com.PantryInc.pantrymanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "Usuario")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;
    private String Email;
    private String Contraseña;

    public Usuario(String nombre, String email, String contraseña) {
        this.nombre = nombre;
        this.Email = email;
        this.Contraseña = contraseña;
    }
}
