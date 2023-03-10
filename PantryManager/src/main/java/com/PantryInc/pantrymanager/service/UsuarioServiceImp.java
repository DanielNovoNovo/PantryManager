package com.PantryInc.pantrymanager.service;

import com.PantryInc.pantrymanager.model.Usuario;
import com.PantryInc.pantrymanager.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioServiceImp implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;

    @Override
    public Usuario create(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public Optional<Usuario> getById(Integer id) {
        return repository.findById(id);
    }

    @Override
    public Optional<Usuario> getByNombre(String nombre) {
        return repository.findByNombre(nombre);
    }

    @Override
    public List<Usuario> getByNombreOrEmail(String nombre, String email) {
        return repository.searchByNombreOrEmail(nombre, email);
    }

    @Override
    public Optional<Usuario> getByNombreOrEmailAndContraseña(String nombre, String email, String contraseña) {
        return repository.searchByNombreOrEmailAndContraseña(nombre, email, contraseña);
    }

    @Override
    public Usuario update(Usuario usuario) {
        return repository.save(usuario);
    }

    @Override
    public void deleteById(Integer id) {
        repository.deleteById(id);
    }
}
