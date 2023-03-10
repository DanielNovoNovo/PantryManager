package com.PantryInc.pantrymanager.repository;

import com.PantryInc.pantrymanager.model.Ingrediente;
import com.PantryInc.pantrymanager.model.Receta;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecetaRepository extends JpaRepository<Receta, Integer> {
    @Query(value = "SELECT * FROM Recetas "
            + "WHERE (lower(Nombre) = :nombre OR :nombre is NULL) "
            + "AND (lower(Tiempo_preparacion) = :tiempo_preparacion OR :tiempo_preparacion is NULL) "
            + "AND (lower(Dificultad) = :dificultad OR :dificultad is NULL) "
            + "AND (lower(Tipo_comida) = :tipo_comida OR :tipo_comida is NULL) "
            + "AND (lower(Id_autor) = :id_autor OR :id_autor is NULL)", nativeQuery = true)
    List<Receta> searchByNombreAndTiempoPreparacionAndDificultadAndTipoComidaAndIdAutor
            (@Param("nombre") String p1, @Param("tiempo_preparacion") int p2, @Param("dificultad") String p3,
             @Param("tipo_comida") String p4, @Param("id_autor") Integer p5);

    Optional<Receta> findByNombre(String nombre);

    List<Receta> findByEstadoAndVotosTotales(String estado, int votosTotales);

    int deleteByEstado(String estado);
}
