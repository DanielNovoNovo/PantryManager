package com.PantryInc.pantrymanager.controller;

import com.PantryInc.pantrymanager.dto.RecetaDTO;
import com.PantryInc.pantrymanager.model.*;
import com.PantryInc.pantrymanager.service.RecetaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/recetas")
public class RecetaController {
    @Autowired
    private RecetaService service;

    @PostMapping("/crear")
    @Operation(summary = "Crea una nuevo receta")
    public ResponseEntity<?> create(@RequestBody RecetaDTO recetaDTO) {
        Optional<Receta> recetaConsultada = service.getByNombre(recetaDTO.getNombre());

        if (!recetaConsultada.isPresent()) {
            Receta recetaGuardada = service.create(recetaDTO.toModel());
            return ResponseEntity.status(HttpStatus.CREATED).body(recetaGuardada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La receta ya fue añadida previamente");
        }
    }

    @GetMapping("/listar_por_nombre_and_tiempo_preparacion_and_dificultad and tipo_comida and autor")
    @Operation(summary = "Listar recetas filtrando por nombre and tiempo_preparacion and dificultad" +
            "and tipo_comida and idAutor")
    public ResponseEntity<?> getByNombreAndTiempoPreparacionAndDificultadAndTipoComidaAndIdAutor
            (@RequestParam(name = "nombre", required = false) String nombre,
             @RequestParam(name = "tiempo_preparacion", required = false) Integer tiempoPreparacion,
             @RequestParam(name = "dificultad", required = false) String dificultad,
             @RequestParam(name = "tipo_comida", required = false) String tipoComida,
             @RequestParam(name = "autor", required = false) Integer idAutor) {

        if ("".equals(nombre)) {
            nombre = null;
        }
        if ("".equals(tiempoPreparacion)) {
            tiempoPreparacion = null;
        }
        if ("".equals(dificultad)) {
            dificultad = null;
        }
        if ("".equals(tipoComida)) {
            tipoComida = null;
        }
        if ("".equals(idAutor)) {
            idAutor = null;
        }

        List<Receta> recetas = service.getByNombreAndTiempoPreparacionAndDificultadAndTipoComidaAndIdAutor
                (nombre, tiempoPreparacion, dificultad, tipoComida, idAutor);

        if (!recetas.isEmpty()) {
            return ResponseEntity.ok(recetas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Las recetas no se encontraron");
        }
    }

    @GetMapping("/listar_todo")
    @Operation(summary = "Lista todas las recetas")
    public ResponseEntity<?> getAll() {
        List<Receta> recetas = service.getAll();

        if (!recetas.isEmpty()) {
            return ResponseEntity.ok(recetas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron recetas");
        }
    }

    @PutMapping("/actualizar")
    @Operation(summary = "Actualiza una receta")
    public ResponseEntity<?> update(@RequestBody RecetaDTO recetaDTO) {
        Optional<Receta> recetaConsultada = service.getById(recetaDTO.getId());

        if (recetaConsultada.isPresent()) {
            Receta recetaActualizada = recetaDTO.toModel();
            service.update(recetaActualizada);
            return ResponseEntity.ok(recetaActualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La receta no se encontró");
        }
    }

    @PutMapping("/actualizar_votos/{esPositivo}/{id}")
    @Operation(summary = "Actualiza los votos de una receta")
    public ResponseEntity<?> updateVotosById
            (@PathVariable boolean esPositivo, @PathVariable Integer id) {
        Optional<Receta> recetaConsultada = service.getById(id);

        if (recetaConsultada.isPresent()) {
            Receta recetaActualizada = recetaConsultada.get();
            if (esPositivo) {
                recetaActualizada.setVotosPositivos(recetaActualizada.getVotosPositivos() + 1);
                recetaActualizada.setVotosTotales(recetaActualizada.getVotosTotales() + 1);
            } else {
                recetaActualizada.setVotosNegativos(recetaActualizada.getVotosNegativos() + 1);
                recetaActualizada.setVotosTotales(recetaActualizada.getVotosTotales() + 1);
            }

            service.update(recetaActualizada);
            return ResponseEntity.ok(recetaActualizada);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("La receta no se encontró");
        }
    }

    @PutMapping("/actualizar_pendientes")
    @Operation(summary = "Actualiza las recetas en estado 'Pendiente'")
    public ResponseEntity<?> updatePendientes() {
        List<Receta> recetasConsultadas = service.getByEstadoAndVotosTotales("Pendiente", 10);

        if (!recetasConsultadas.isEmpty()) {
            List<Receta> recetasActualizadas = new ArrayList<>(recetasConsultadas);
            for (Receta receta : recetasConsultadas) {
                if (receta.getVotosPositivos() >= 7) {
                    receta.setEstado("Aprobada");
                } else {
                    receta.setEstado("Rechazada");
                }
            }

            service.updateList(recetasActualizadas);
            return ResponseEntity.ok(recetasActualizadas);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No se encontraron recetas");
        }
    }

    @DeleteMapping("/borrar_por_id/{id}")
    @Operation(summary = "Borra una receta por su id")
    public void deleteById(@PathVariable Integer id) {
        service.deleteById(id);
    }

    @DeleteMapping("/borrar_rechazadas")
    @Operation(summary = "Borra todas las recetas rechazadas")
    public void deleteRechazadas() {
        service.deleteRechazadas();
    }
}
