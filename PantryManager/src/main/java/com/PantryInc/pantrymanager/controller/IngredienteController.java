package com.PantryInc.pantrymanager.controller;

import com.PantryInc.pantrymanager.dto.IngredienteDTO;
import com.PantryInc.pantrymanager.model.Ingrediente;
import com.PantryInc.pantrymanager.service.IngredienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService service;

    @PostMapping("/crear")
    @Operation(summary = "Crea un nuevo ingrediente")
    public ResponseEntity<?> create(@RequestBody IngredienteDTO ingredienteDTO) {
        Optional<Ingrediente> ingredienteConsultado = service.getByNombre(ingredienteDTO.getNombre());

        if (!ingredienteConsultado.isPresent()) {
            Ingrediente ingredienteGuardado = service.create(ingredienteDTO.toModel());
            return ResponseEntity.status(HttpStatus.CREATED).body(ingredienteGuardado);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El ingrediente ya fue añadido previamente");
        }
    }

    @GetMapping("/listar_todo")
    @Operation(summary = "Lista todos los ingrediente")
    public ResponseEntity<?> getAll() {
        List<Ingrediente> ingredientes = service.getAll();

        if (!ingredientes.isEmpty()) {
            return ResponseEntity.ok(ingredientes);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron ingredientes");
        }
    }

    @GetMapping("/listar_por_nombre/{nombre}")
    @Operation(summary = "Lista un ingrediente filtrando por su nombre")
    public ResponseEntity<?> getByNombre(@PathVariable String nombre) {
        Optional<Ingrediente> ingredienteConsultado = service.getByNombre(nombre);

        if (ingredienteConsultado.isPresent()) {
            return ResponseEntity.ok(ingredienteConsultado.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El ingrediente no se encontró");
        }
    }

    @PutMapping("/actualizar")
    @Operation(summary = "Actualiza un ingrediente")
    public ResponseEntity<?> update(@RequestBody IngredienteDTO ingredienteDTO) {
        Integer id = ingredienteDTO.getId();
        String nombre = ingredienteDTO.getNombre();
        String tipo = ingredienteDTO.getTipo();
        int calorias = ingredienteDTO.getCalorias();
        String imagen = ingredienteDTO.getImagen();

        // Buscar el ingrediente por ID
        Optional<Ingrediente> ingredienteConsultado = service.getById(id);

        if (ingredienteConsultado.isPresent()) {
            // Si el ingrediente existe, actualizarlo
            Ingrediente ingredienteActualizado = ingredienteDTO.toModel();
            service.update(ingredienteActualizado);
            return ResponseEntity.ok(ingredienteActualizado);
        } else {
            // Si el ingrediente no existe, devolver una respuesta de error
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El ingrediente no se encontró");
        }
    }

    @DeleteMapping("/borrar_por_id/{id}")
    @Operation(summary = "Borra un ingrediente por su id")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }
}


