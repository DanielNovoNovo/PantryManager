package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Autor;

import java.util.List;
import java.util.Optional;

public interface AutorService {
    public Autor create(Autor autor);

    public Optional<Autor> getById(Integer id);

    public Optional<Autor> getByNombre(String nombre);

    public List<Autor> getByNombreAndApellidoAndPais(String nombre, String apellido, String pais);

    public List<Autor> getAll();

    public Autor update(Autor autor);

    public void deleteById(Integer id);
}
