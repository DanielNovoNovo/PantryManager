package com.PantryInc.pantrymanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "consultan")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class UsuarioToReceta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "Id_usuario") // Referencia al campo Id_usuario de la tabla 'consultan' de nuestra BD
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name = "Id_receta") // Referencia al campo Id_receta de la tabla 'consultan' de nuestra BD
    private Receta receta;
    @Column(name = "Indice_match")
    private float indiceMatch;

    public UsuarioToReceta(Usuario usuario, Receta receta, float indiceMatch) {
        this.usuario = usuario;
        this.receta = receta;
        this.indiceMatch = indiceMatch;
    }
}
