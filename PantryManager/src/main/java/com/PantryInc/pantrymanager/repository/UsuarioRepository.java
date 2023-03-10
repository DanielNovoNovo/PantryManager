package com.PantryInc.pantrymanager.repository;

import com.PantryInc.pantrymanager.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    @Query(value = "SELECT * FROM Usuarios "
            + "WHERE lower(Nombre) = :nombre "
            + "OR lower(Email) = :email", nativeQuery = true)
    List<Usuario> searchByNombreOrEmail(@Param("nombre") String p1, @Param("email") String p2);

    @Query(value = "SELECT * FROM Usuarios "
            + "WHERE (lower(Nombre) = :nombre OR lower(Email) = :email) "
            + "AND lower(Contraseña = :contraseña)", nativeQuery = true)
    Optional<Usuario> searchByNombreOrEmailAndContraseña
            (@Param("nombre") String p1, @Param("email") String p2, @Param("contraseña") String p3);

    Optional<Usuario> findByNombre(String nombre);
}
