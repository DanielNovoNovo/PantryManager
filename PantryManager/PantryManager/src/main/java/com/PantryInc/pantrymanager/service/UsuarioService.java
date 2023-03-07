package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    public List<Usuario> buscarTodo();
    public Optional<Usuario> consultar(Integer id);
    public Optional<Usuario> consultarPorNombre(String nombre);
    public Usuario guardar(Usuario usuario);
    public void borrar(Integer id);
}
