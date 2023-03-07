package com.PantryInc.pantrymanager.dto;

import com.PantryInc.pantrymanager.model.RecetaToIngrediente;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RecetaToIngredienteDTO {

    private Integer id;
    private int idReceta;
    private int idIngrediente;
    private String cantidad;

    public RecetaToIngrediente toRecetaToIngrediente() {
        return new RecetaToIngrediente(id, idReceta, idIngrediente, cantidad);
    }

    public RecetaToIngredienteDTO fromRecetaToIngrediente(RecetaToIngrediente recetaToIngrediente) {
        return new RecetaToIngredienteDTO(recetaToIngrediente.getId(),
                recetaToIngrediente.getIdReceta(), recetaToIngrediente.getIdIngrediente(),
                recetaToIngrediente.getCantidad());
    }

}
