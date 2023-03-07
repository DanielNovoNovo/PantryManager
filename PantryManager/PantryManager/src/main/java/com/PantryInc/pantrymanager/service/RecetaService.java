package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Receta;
import org.springframework.context.annotation.Bean;

import java.util.Optional;
public interface RecetaService {

    public Optional<Receta> consultarPorNombre(String nombre);

    public Receta guardar(Receta receta);

}

