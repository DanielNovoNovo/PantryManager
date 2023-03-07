package com.PantryInc.pantrymanager.controller;

import com.PantryInc.pantrymanager.dto.IngredienteDTO;
import com.PantryInc.pantrymanager.model.Ingrediente;
import com.PantryInc.pantrymanager.service.IngredienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/ingredientes")
public class IngredienteController {

    @Autowired
    private IngredienteService servico;

    @PostMapping("/insertar")
    @Operation(summary = "Inserta un ingrediente")
    public ResponseEntity<?> crearIngrediente(@RequestBody IngredienteDTO ingredienteDTO) {
        Optional<Ingrediente> ingredienteConsultado = servico.consultarPorNombre(ingredienteDTO.getNombre());

        if (!ingredienteConsultado.isPresent()) {
            Ingrediente ingredienteGuardado = servico.
                    guardar(ingredienteDTO.convertirAModel(ingredienteDTO.getId(), ingredienteDTO.getNombre(),
                            ingredienteDTO.getTipo(), ingredienteDTO.getCalorias(), ingredienteDTO.getImagen()));
            return ResponseEntity.status(HttpStatus.CREATED).body(ingredienteGuardado);
        } else {
            return null;
        }
    }

    @GetMapping("/consultar_por_nombre")
    @Operation(summary = "Consultar un ingrediente por nombre")
    public ResponseEntity<?> consultarIngrediente(@RequestParam String nombre) {
        Optional<Ingrediente> ingredienteConsultado = servico.consultarPorNombre(nombre);

        if (ingredienteConsultado.isPresent()) {
            return ResponseEntity.ok(ingredienteConsultado.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El ingrediente no se encontró.");
        }
    }

    @GetMapping("/consultar_por_calorias")
    @Operation(summary = "Consultar un ingrediente por calorias")
    public ResponseEntity<?> consultarIngrediente(@RequestParam int calorias) {
        Optional<Ingrediente> ingredienteConsultado = servico.consultarPorCalorias(calorias);

        if (ingredienteConsultado.isPresent()) {
            return ResponseEntity.ok(ingredienteConsultado.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El ingrediente no se encontró.");
        }
    }

    @DeleteMapping("/borrar_por_id")
    @Operation(summary = "Borrar un ingrediente por su id")
    void borrarIngrediente(@RequestParam Integer id) {
        servico.borrar(id);
    }
}
