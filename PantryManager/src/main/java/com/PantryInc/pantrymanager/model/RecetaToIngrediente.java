package com.PantryInc.pantrymanager.model;

import com.PantryInc.pantrymanager.service.IngredienteService;
import jakarta.persistence.*;
import jdk.jfr.Enabled;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tienen")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class RecetaToIngrediente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "Id_receta") // Referencia al campo Id_receta de la tabla 'tienen' de nuestra BD
    private Receta receta;
    @ManyToOne
    @JoinColumn(name = "Id_ingrediente") // Referencia al campo Id_ingrediente de la tabla 'tienen' de nuestra BD
    private Ingrediente ingrediente;
    @Column(name = "Cantidad")
    private int cantidad;

    public RecetaToIngrediente(Receta receta, Ingrediente ingrediente, int cantidad) {
        this.receta = receta;
        this.ingrediente = ingrediente;
        this.cantidad = cantidad;
    }
}
