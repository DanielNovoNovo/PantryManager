package com.PantryInc.pantrymanager.controller;

import com.PantryInc.pantrymanager.model.Ingrediente;
import com.PantryInc.pantrymanager.model.Receta;
import com.PantryInc.pantrymanager.service.RecetaToIngredienteService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/recetaToIngrediente")
public class RecetaToIngredienteController {

    @Autowired
    private RecetaToIngredienteService servicio;

    @GetMapping("/receta/{id}")
    @Operation(summary = "Devuelve las recetas que contienen el ingrediente")
    public List<Receta> findByIdIngrediente(@PathVariable("id") int idIngrediente) {
        return servicio.findByIdIngrediente(idIngrediente);
    }

    @GetMapping("ingredientes/{id}")
    @Operation(summary = "Devuelve los ingredientes de una receta")
    public List<Ingrediente> findByIdReceta(@PathVariable("id") int idReceta) {
        return servicio.findByIdReceta(idReceta);
    }
}
