package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Autor;
import com.PantryInc.pantrymanager.repository.AutorRepository;
import com.PantryInc.pantrymanager.repository.IngredienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AutorServiceImp implements AutorService {

    @Autowired
    private AutorRepository repository;

    @Override
    public Autor create(Autor autor) {
        return repository.save(autor);
    }

    @Override
    public Optional<Autor> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Autor> getByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public List<Autor> getByNombreAndApellidoAndPais(String nombre, String apellido, String pais) {
        return repository.searchByNombreAndApellidoAndPais(nombre, apellido, pais);
    }

    @Override
    public List<Autor> getAll() {
        return repository.findAll();
    }

    @Override
    public Autor update(Autor autor) {
        return repository.save(autor);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
