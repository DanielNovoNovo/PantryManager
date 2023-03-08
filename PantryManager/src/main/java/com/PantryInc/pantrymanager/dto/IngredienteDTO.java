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

    public Ingrediente convertirAModel() {
        Ingrediente ingrediente = new Ingrediente();
        ingrediente.setId(this.id);
        ingrediente.setNombre(this.nombre);
        ingrediente.setTipo(this.tipo);
        ingrediente.setCalorias(this.calorias);
        ingrediente.setImagen(this.imagen);

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
