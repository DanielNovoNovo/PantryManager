package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Receta;
import com.PantryInc.pantrymanager.repository.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaServiceImp implements RecetaService {

    @Autowired
    private RecetaRepository repository;

    @Override
    public Receta create(Receta receta) {
        return repository.save(receta);
    }

    @Override
    public Optional<Receta> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Receta> getByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public List<Receta> getByEstadoAndVotosTotales(String estado, int votosTotales) {
        return repository.findByEstadoAndVotosTotales(estado, votosTotales);
    }

    @Override
    public List<Receta> getByNombreAndTiempoPreparacionAndDificultadAndTipoComidaAndIdAutor
            (String nombre, int tiempoPreparacion, String dificultad, String tipoComida, Integer idAutor) {
        return repository.searchByNombreAndTiempoPreparacionAndDificultadAndTipoComidaAndIdAutor
                (nombre, tiempoPreparacion, dificultad, tipoComida, idAutor);
    }

    @Override
    public List<Receta> getAll() {
        return repository.findAll();
    }

    @Override
    public Receta update(Receta receta) {
        return repository.save(receta);
    }

    @Override
    public List<Receta> updateList(List<Receta> recetas) {
        return repository.saveAll(recetas);
    }

    /*
    @Override
    public Optional<Receta> updateVotos(int votosPositivos, int votosNegativos, int votosTotales, Integer id) {
        //repository.updateVotos(votosPositivos, votosNegativos, votosTotales, id);
        return repository.findById(id);
    }
     */

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void deleteRechazadas() {
        repository.deleteByEstado("Rechazada");
    }

    /*
    @Override
    public void deleteRechazadas() {
        repository.deleteRechazadas();
    }
     */
}
