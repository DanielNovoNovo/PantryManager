package com.PantryInc.pantrymanager.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "Autores")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Nombre")
    private String nombre;
    @Column(name = "Apellido")
    private String apellido;
    @Column(name = "Fecha_nacimiento")
    private Date fechaNacimiento;
    @Column(name = "Pais")
    private String pais;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private Set<Receta> recetas;

    public Autor(String nombre, String apellido, Date fechaNacimiento, String pais) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
    }

    public void addReceta(Receta receta) {
        recetas.add(receta);
        receta.setAutor(this);
    }

    public void removeReceta(Receta receta) {
        recetas.remove(receta);
        receta.setAutor(null);
    }
}
