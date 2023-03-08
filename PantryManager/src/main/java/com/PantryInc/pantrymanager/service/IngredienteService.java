package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Ingrediente;

import java.util.List;
import java.util.Optional;

public interface IngredienteService {
    public Ingrediente create(Ingrediente ingrediente);

    public List<Ingrediente> getAll();

    public List<Ingrediente> getByAllFields(String nombre, String tipo, int calorias, String imagen);

    public Optional<Ingrediente> getById(Integer id);

    public Optional<Ingrediente> getByNombre(String nombre);

    public Ingrediente update(Ingrediente ingrediente);

    public void deleteById(Integer id);
}
