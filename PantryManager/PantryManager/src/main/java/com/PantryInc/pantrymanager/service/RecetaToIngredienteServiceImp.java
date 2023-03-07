package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Ingrediente;
import com.PantryInc.pantrymanager.model.Receta;
import com.PantryInc.pantrymanager.repository.RecetaToIngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecetaToIngredienteServiceImp implements RecetaToIngredienteService {

    @Autowired
    private RecetaToIngredienteRepository repository;

    @Override
    public List<Receta> findByIdIngrediente(int idIngrediente) {
        return repository.findByIdIngrediente(idIngrediente);
    }

    @Override
    public List<Ingrediente> findByIdReceta(int idReceta) {
        return repository.findByIdReceta(idReceta);
    }
}
