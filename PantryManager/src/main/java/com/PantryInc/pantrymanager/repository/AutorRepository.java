package com.PantryInc.pantrymanager.repository;

import com.PantryInc.pantrymanager.model.Autor;
import com.PantryInc.pantrymanager.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AutorRepository extends JpaRepository<Autor, Integer> {
    @Query(value = "SELECT * FROM Autores "
            + "WHERE (lower(Nombre) = :nombre OR :nombre is NULL) "
            + "AND (lower(Apellido) = :apellido OR :apellido is NULL) "
            + "AND (lower(Pais) = :pais OR :pais is NULL)", nativeQuery = true)
    List<Autor> searchByNombreAndApellidoAndPais
            (@Param("nombre") String p1, @Param("apellido") String p2, @Param("pais") String p3);

    Optional<Autor> findByNombre(String nombre);
}
