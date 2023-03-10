package com.PantryInc.pantrymanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@Table(name = "Usuarios")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Email")
    private String email;
    @Column(name = "Contraseña")
    private String contraseña;
    @Column(name = "Rol")
    private String rol;

    @OneToMany(mappedBy = "usuario")
    // Referencia al atributo Usuario usuario de la clase intermedia UsuarioToIngrediente
    private Set<UsuarioToIngrediente> ingredientes;

    @OneToMany(mappedBy = "usuario")
    // Referencia al atributo Usuario usuario de la clase intermedia UsuarioToReceta
    private Set<UsuarioToReceta> recetas;

    public Usuario(String nombre, String email, String contraseña, String rol) {
        this.nombre = nombre;
        this.email = email;
        this.contraseña = contraseña;
        this.rol = rol;
    }
}
