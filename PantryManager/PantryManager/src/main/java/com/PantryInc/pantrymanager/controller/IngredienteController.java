package com.PantryInc.pantrymanager.controller;

import com.PantryInc.pantrymanager.dto.IngredienteDTO;
import com.PantryInc.pantrymanager.model.Ingrediente;
import com.PantryInc.pantrymanager.service.IngredienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
