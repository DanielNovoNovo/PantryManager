package com.PantryInc.pantrymanager.dto;

import com.PantryInc.pantrymanager.model.Ingrediente;
import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class IngredienteDTO {
    private Integer id;
    private String nombre;
    private String tipo;
    private int calorias;
    private String imagen;

    public Ingrediente convertirAModel(Integer id, String nombre, String tipo, int calorias, String imagen) {
        Ingrediente ingrediente = new Ingrediente(id, nombre, tipo, calorias, imagen);
        return ingrediente;
    }

    public IngredienteDTO crearDTO(Ingrediente ingrediente) {
        this.setId(ingrediente.getId());
        this.setNombre(ingrediente.getNombre());
        this.setTipo(ingrediente.getTipo());
        this.setCalorias(ingrediente.getCalorias());
        this.setImagen(ingrediente.getImagen());
        return this;
    }
}
