package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Ingrediente;
import com.PantryInc.pantrymanager.repository.IngredienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteServiceImp implements IngredienteService {

    @Autowired
    private IngredienteRepository repository;

    @Override
    public List<Ingrediente> buscarIngrediente() {
        return null;
    }

    @Override
    public Optional<Ingrediente> consultar(Integer id) {
        return Optional.empty();
    }

    @Override
    public Optional<Ingrediente> consultarPorNombre(String nombre) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public Ingrediente guardar(Ingrediente ingrediente) {
        return repository.save(ingrediente);
    }

    @Override
    public void borrar(Integer id) {

    }
}
