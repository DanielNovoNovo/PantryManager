package com.PantryInc.pantrymanager.repository;

import com.PantryInc.pantrymanager.model.Ingrediente;
import com.PantryInc.pantrymanager.model.Receta;
import com.PantryInc.pantrymanager.model.RecetaToIngrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecetaToIngredienteRepository extends JpaRepository<RecetaToIngrediente, Integer> {
    List<Receta> findByIngredienteId(int Ingrediente.id);
    List<Ingrediente> findByRecetaId(int Receta.id);
}
