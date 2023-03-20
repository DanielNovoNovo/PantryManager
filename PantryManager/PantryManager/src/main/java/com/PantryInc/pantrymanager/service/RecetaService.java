package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Receta;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
public interface RecetaService {

    public Optional<Receta> consultarPorNombre(String nombre);

    public Receta guardar(Receta receta);

    public Optional<Receta> eliminar(Integer Id);

    List<Receta> buscarPorNombre(String nombre);
}

