package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Ingrediente;

import java.util.List;
import java.util.Optional;

public interface IngredienteService {
    public List<Ingrediente> buscarIngrediente();

    public Optional<Ingrediente> consultar(Integer id);

    public Optional<Ingrediente> consultarPorNombre(String nombre);

    public Optional<Ingrediente> consultarPorCalorias(int calorias);

    public Ingrediente guardar(Ingrediente ingrediente);

    public void borrar(Integer id);
}
