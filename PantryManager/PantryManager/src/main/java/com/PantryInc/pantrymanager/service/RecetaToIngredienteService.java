package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Ingrediente;
import com.PantryInc.pantrymanager.model.Receta;

import java.util.List;

public interface RecetaToIngredienteService {
    List<Receta> findByIdIngrediente(int idIngrediente);
    List<Ingrediente> findByIdReceta(int idReceta);
}
