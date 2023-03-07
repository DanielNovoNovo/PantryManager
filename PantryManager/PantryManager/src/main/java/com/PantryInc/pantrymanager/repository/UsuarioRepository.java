package com.PantryInc.pantrymanager.repository;

import com.PantryInc.pantrymanager.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    Optional<Usuario> findByNombre(String nombre);

    List<Usuario> findByNombreContains(String nombre);

    List<Usuario> findByNombreContainsOrderByNombreAsc(String nombre);
}
