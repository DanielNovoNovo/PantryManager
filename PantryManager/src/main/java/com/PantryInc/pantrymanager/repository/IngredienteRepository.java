package com.PantryInc.pantrymanager.repository;

import com.PantryInc.pantrymanager.model.Ingrediente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IngredienteRepository extends JpaRepository<Ingrediente, Integer> {

    @Query(value = "SELECT * FROM Ingredientes " +
            "WHERE lower(Nombre) = :nombre AND lower(Tipo) = :tipo " +
            "AND lower(Calorias) = :calorias AND lower(Imagen) = :imagen", nativeQuery = true)
    List<Ingrediente> searchByAllFields(@Param("nombre") String p1, @Param("tipo") String p2,
                                        @Param("calorias") int p3, @Param("imagen") String p4);

    Optional<Ingrediente> findByNombre(String nombre);

    /*
    List<Ingrediente> findByNombreContains(String nombre);
    List<Ingrediente> findByNombreContainsOrderByNombreAsc(String nombre);
     */
}
