package com.PantryInc.pantrymanager.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tiene")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecetaToIngrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "Id_receta")
    private int idReceta;
    @Column(name = "Id_ingrediente")
    private int idIngrediente;
    @Column(name = "Cantidad")
    private String cantidad;
    @ManyToOne
    @JoinColumn(name = "Id_receta", insertable = false, updatable = false)
    private Receta receta;
    @ManyToOne
    @JoinColumn(name = "Id_ingrediente", insertable = false, updatable = false)
    private Ingrediente ingrediente;


    public RecetaToIngrediente(int idReceta, int idIngrediente, String cantidad) {
        this.idReceta = idReceta;
        this.idIngrediente = idIngrediente;
        this.cantidad = cantidad;
    }

    public RecetaToIngrediente(Integer id, int idReceta, int idIngrediente, String cantidad) {
        this.id = id;
        this.idReceta = idReceta;
        this.idIngrediente = idIngrediente;
        this.cantidad = cantidad;
    }

    public int getId() {
        return id;
    }

    public Receta getReceta() {
        return receta;
    }

    public void setReceta(Receta receta) {
        this.receta = receta;
    }

    public Ingrediente getIngrediente() {
        return ingrediente;
    }

    public void setIngrediente(Ingrediente ingrediente) {
        this.ingrediente = ingrediente;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(int idReceta) {
        this.idReceta = idReceta;
    }

    public int getIdIngrediente() {
        return idIngrediente;
    }

    public void setIdIngrediente(int idIngrediente) {
        this.idIngrediente = idIngrediente;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }
}
