package com.PantryInc.pantrymanager.repository;

import com.PantryInc.pantrymanager.model.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Integer> {

   Optional<Receta> findByNombre(String nombre);

   List<Receta> findByNombreContains(String nombre);

   List<Receta> findByNombreContainsOrderByNombreAsc(String nombre);



}
