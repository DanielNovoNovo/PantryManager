package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Ingrediente;
import com.PantryInc.pantrymanager.repository.IngredienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class IngredienteServiceImp implements IngredienteService {

    @Autowired
    private IngredienteRepository repository;

    @Override
    public Ingrediente create(Ingrediente ingrediente) {
        return repository.save(ingrediente);
    }

    @Override
    public List<Ingrediente> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Ingrediente> getByAllFields(String nombre, String tipo, int calorias, String imagen) {
        return repository.searchByAllFields(nombre, tipo, calorias, imagen);
    }

    @Override
    public Optional<Ingrediente> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Ingrediente> getByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public Ingrediente update(Ingrediente ingrediente) {
        return repository.save(ingrediente);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}