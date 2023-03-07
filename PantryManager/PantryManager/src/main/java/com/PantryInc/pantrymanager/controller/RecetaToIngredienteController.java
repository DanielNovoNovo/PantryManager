package com.PantryInc.pantrymanager.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/recetaToIngrediente")
@Tag(name = "RecetaToIngrediente", description = "RecetaToIngrediente"
public class RecetaToIngredienteController {
    private RecetaToIngredienteService servicio;


}
