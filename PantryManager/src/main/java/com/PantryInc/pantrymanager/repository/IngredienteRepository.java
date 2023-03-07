package com.PantryInc.pantrymanager.repository;

import com.PantryInc.pantrymanager.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {
    Optional<Ingrediente> findByNombre(String nombre);
    Optional<Ingrediente> findByCalorias(int calorias);

    List<Ingrediente> findByNombreContains(String nombre);

    List<Ingrediente> findByNombreContainsOrderByNombreAsc(String nombre);
}
