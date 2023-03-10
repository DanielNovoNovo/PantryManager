package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Receta;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface RecetaService {
    public Receta create(Receta receta);

    public Optional<Receta> getById(Integer id);

    public Optional<Receta> getByNombre(String nombre);

    public List<Receta> getByEstadoAndVotosTotales(String estado, int votosTotales);

    public List<Receta> getByNombreAndTiempoPreparacionAndDificultadAndTipoComidaAndIdAutor
            (String nombre, int tiempoPreparacion, String dificultad, String tipoComida, Integer idAutor);

    public List<Receta> getAll();

    public Receta update(Receta receta);

    public List<Receta> updateList(List<Receta> recetas);

    public void deleteById(Integer id);

    public void deleteRechazadas();
}
