package com.PantryInc.pantrymanager.controller;

import com.PantryInc.pantrymanager.dto.UsuarioDTO;
import com.PantryInc.pantrymanager.dto.UsuarioErroresDTO;
import com.PantryInc.pantrymanager.model.Usuario;
import com.PantryInc.pantrymanager.service.UsuarioService;
import com.PantryInc.pantrymanager.util.UsuarioErrores;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
@Tag(name = "Usuario", description = "Registro de usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioService service;

    @PostMapping("/insertar")
    @Operation(summary = "Insertar un Usuario")
    public ResponseEntity<?> crearUsuario(@RequestBody UsuarioDTO usuarioDTO) {

        Optional<Usuario> usuarioConsultado = service.consultarPorNombre(usuarioDTO.getNombre());

        if (!usuarioConsultado.isPresent()) {
            Usuario usuarioGuardado = service.guardar(usuarioDTO.convertirModel(usuarioDTO.getId(), usuarioDTO.getNombre(), usuarioDTO.getEmail(), usuarioDTO.getContraseña()));
            usuarioDTO.crearDTO(usuarioGuardado);
            return ResponseEntity.status(HttpStatus.CREATED).body(usuarioGuardado);
        } else {
            UsuarioErroresDTO usuarioErroresDTO = new UsuarioErroresDTO(UsuarioErrores.COD_ERROR_DUPLICADO, UsuarioErrores.MEN_ERROR_DUPLICADO);
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(usuarioErroresDTO);
        }
    }

    @GetMapping("/consultarPorNombre")
    @Operation(summary = "Consultar un Usuario por su nombre")
    public ResponseEntity<?> consultarUsuarioPorNombre(@RequestParam String nombre) {

        Optional<Usuario> usuarioConsultado = service.consultarPorNombre(nombre);

        if (usuarioConsultado.isPresent()) {
            return ResponseEntity.ok(usuarioConsultado.get());
        } else {
            UsuarioErroresDTO usuarioErroresDTO = new UsuarioErroresDTO(UsuarioErrores.COD_ERROR_NO_ENCONTRADO, UsuarioErrores.MEN_ERROR_NO_ENCONTRADO);
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(usuarioErroresDTO);
        }
    }
}
