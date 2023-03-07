package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Usuario;
import com.PantryInc.pantrymanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService{

    @Autowired
    private UsuarioRepository repository;

    @Override
    @Transactional
    public List<Usuario> buscarTodo() {
        return null;
    }

    @Override
    @Transactional
    public Optional<Usuario> consultar(Integer id) {
        return Optional.empty();
    }

    @Override
    @Transactional
    public Optional<Usuario> consultarPorNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    @Transactional
    public Usuario guardar(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    @Transactional
    public void borrar(Integer id) {

    }
}
