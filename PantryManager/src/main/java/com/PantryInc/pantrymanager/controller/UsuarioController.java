package com.PantryInc.pantrymanager.controller;

import com.PantryInc.pantrymanager.dto.UsuarioDTO;
import com.PantryInc.pantrymanager.model.Usuario;
import com.PantryInc.pantrymanager.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/crear")
    @Operation(summary = "Crea un nuevo usuario")
    public ResponseEntity<?> create(@RequestBody UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioConsultado = service.getByNombre(usuarioDTO.getNombre());

        if (!usuarioConsultado.isPresent()) {
            Usuario usuarioGuardado = service.create(usuarioDTO.toModel());
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario ya fue añadido previamente");
        }
    }

    @GetMapping("/listar_por_nombre_or_email/{nombre}/{email}")
    @Operation(summary = "Listar usuarios filtrando por nombre OR email")
    public ResponseEntity<?> getByNombreOrEmail(@PathVariable String nombre, @PathVariable String email) {
        List<Usuario> usuarios = service.getByNombreOrEmail(nombre, email);

        if (!usuarios.isEmpty()) {
            return ResponseEntity.ok(usuarios);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Los usuarios no se encontraron");
        }
    }

    @GetMapping("/listar_por_nombre_or_email_and_contraseña/{nombre}/{email}/{contraseña}")
    @Operation(summary = "Listar usuario filtrando por (nombre OR email) AND contraseña")
    public ResponseEntity<?> getByNombreOrEmailAndContraseña
            (@PathVariable String nombre, @PathVariable String email, @PathVariable String contraseña) {
        Optional<Usuario> usuario = service.getByNombreOrEmailAndContraseña(nombre, email, contraseña);

        if (usuario.isPresent()) {
            return ResponseEntity.ok(usuario.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario no se encontró");
        }
    }

    @PutMapping("/actualizar")
    @Operation(summary = "Actualiza un usuario")
    public ResponseEntity<?> update(@RequestBody UsuarioDTO usuarioDTO) {
        Optional<Usuario> usuarioConsultado = service.getById(usuarioDTO.getId());

        if (usuarioConsultado.isPresent()) {
            Usuario usuarioActualizado = usuarioDTO.toModel();
            service.update(usuarioActualizado);
            return ResponseEntity.ok(usuarioActualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El usuario no se encontró");
        }
    }

    @DeleteMapping("/borrar_por_id/{id}")
    @Operation(summary = "Borra un usuario por su id")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
