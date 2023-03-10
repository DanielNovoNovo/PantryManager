package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public Usuario create(Usuario usuario);

    public Optional<Usuario> getById(Integer id);

    public Optional<Usuario> getByNombre(String nombre);

    public List<Usuario> getByNombreOrEmail(String nombre, String email);

    public Optional<Usuario> getByNombreOrEmailAndContraseña(String nombre, String email, String contraseña);

    public Usuario update(Usuario usuario);

    public void deleteById(Integer id);
}
