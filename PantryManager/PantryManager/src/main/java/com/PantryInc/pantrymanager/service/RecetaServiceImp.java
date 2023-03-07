package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Receta;
import com.PantryInc.pantrymanager.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class RecetaServiceImp implements RecetaService {

    @Autowired
    private RecetaRepository repositorio;

    @Override
    @Transactional
    public Optional<Receta> consultarPorNombre(String nombre) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public Receta guardar(Receta receta) {
        return repositorio.save(receta);
    }
}
