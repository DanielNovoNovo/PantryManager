package com.PantryInc.pantrymanager.controller;

import com.PantryInc.pantrymanager.dto.ErrorRecetaDTO;
import com.PantryInc.pantrymanager.dto.RecetaDTO;
import com.PantryInc.pantrymanager.model.Receta;
import com.PantryInc.pantrymanager.service.RecetaService;
import com.PantryInc.pantrymanager.service.RecetaToIngredienteService;
import com.PantryInc.pantrymanager.util.ErroresReceta;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/receta")
@Tag(name = "Receta", description = "Recetas")
public class RecetaController {

@Autowired
private RecetaService servicio;

@PostMapping
@Operation(summary = "Inserta una receta")
public ResponseEntity<?> crearReceta(@RequestBody RecetaDTO recetaDTO) {
    Receta recetaGuardada = servicio.guardar(recetaDTO.convertirModel());
    recetaDTO.crearDTO(recetaGuardada);
    return ResponseEntity.status(HttpStatus.CREATED).body(recetaDTO);
}

public ResponseEntity<?> crear (@RequestBody RecetaDTO recetaDTO) {
    Optional<Receta> recetaConsultada = servicio.consultarPorNombre(recetaDTO.getNombre());
    if (!recetaConsultada.isPresent()) {
        Receta recetaGuardada = servicio.guardar(recetaDTO.convertirModel());
        return ResponseEntity.status(HttpStatus.CREATED).body(recetaDTO.crearDTO(recetaGuardada));
    }else {
        ErrorRecetaDTO errorRecetaDTO = new ErrorRecetaDTO(ErroresReceta.COD_ERROR_DUPLICADO, ErroresReceta.MEN_ERROR_DUPLICADO);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorRecetaDTO);
    }
 }
}
