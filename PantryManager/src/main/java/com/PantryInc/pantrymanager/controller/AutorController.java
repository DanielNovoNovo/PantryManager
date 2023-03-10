package com.PantryInc.pantrymanager.controller;

import com.PantryInc.pantrymanager.dto.AutorDTO;
import com.PantryInc.pantrymanager.dto.UsuarioDTO;
import com.PantryInc.pantrymanager.model.Autor;
import com.PantryInc.pantrymanager.model.Ingrediente;
import com.PantryInc.pantrymanager.model.Usuario;
import com.PantryInc.pantrymanager.service.AutorService;
import com.PantryInc.pantrymanager.service.UsuarioService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/autores")
public class AutorController {

    @Autowired
    private AutorService service;

    @PostMapping("/crear")
    @Operation(summary = "Crea un nuevo autor")
    public ResponseEntity<?> create(@RequestBody AutorDTO autorDTO) {
        Optional<Autor> autorConsultado = service.getByNombre(autorDTO.getNombre());

        if (!autorConsultado.isPresent()) {
            Autor autorGuardado = service.create(autorDTO.toModel());
            return ResponseEntity.status(HttpStatus.CREATED).body(autorGuardado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El autor ya fue añadido previamente");
        }
    }

    @GetMapping("/listar_por_nombre_and_apellido_and_pais")
    @Operation(summary = "Listar usuarios filtrando por nombre OR email")
    public ResponseEntity<?> getByNombreAndApellidoAndPais
            (@RequestParam(name = "nombre", required = false) String nombre,
             @RequestParam(name = "apellido", required = false) String apellido,
             @RequestParam(name = "pais", required = false) String pais) {

        if ("".equals(nombre)) {
            nombre = null;
        }
        if ("".equals(apellido)) {
            apellido = null;
        }
        if ("".equals(pais)) {
            pais = null;
        }

        List<Autor> autores = service.getByNombreAndApellidoAndPais(nombre, apellido, pais);

        if (!autores.isEmpty()) {
            return ResponseEntity.ok(autores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Los usuarios no se encontraron");
        }
    }

    @GetMapping("/listar_todo")
    @Operation(summary = "Lista todos los autores")
    public ResponseEntity<?> getAll() {
        List<Autor> autores = service.getAll();

        if (!autores.isEmpty()) {
            return ResponseEntity.ok(autores);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron autores");
        }
    }

    @PutMapping("/actualizar")
    @Operation(summary = "Actualiza un autor")
    public ResponseEntity<?> update(@RequestBody AutorDTO autorDTO) {
        Optional<Autor> autorConsultado = service.getById(autorDTO.getId());

        if (autorConsultado.isPresent()) {
            Autor autorActualizado = autorDTO.toModel();
            service.update(autorActualizado);
            return ResponseEntity.ok(autorActualizado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El autor no se encontró");
        }
    }

    @DeleteMapping("/borrar_por_id/{id}")
    @Operation(summary = "Borra un usuario por su id")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }
}
