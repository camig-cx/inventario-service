package com.arka.inventario.infrastructure.adapters.input.rest;

import com.arka.inventario.application.dtos.requests.CrearCategoriaRequest;
import com.arka.inventario.application.dtos.responses.CategoriaResponse;
import com.arka.inventario.application.ports.input.CategoriaInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaInputPort categoriaInputPort;

    @PostMapping
    public ResponseEntity<CategoriaResponse> crearCategoria(
            @Valid @RequestBody CrearCategoriaRequest request) {
        CategoriaResponse categoria = categoriaInputPort.crearCategoria(request);
        return new ResponseEntity<>(categoria, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaResponse>> obtenerTodasLasCategorias() {
        List<CategoriaResponse> categorias = categoriaInputPort.obtenerTodasLasCategorias();
        return ResponseEntity.ok(categorias);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponse> obtenerCategoriaPorId(@PathVariable Long id) {
        CategoriaResponse categoria = categoriaInputPort.obtenerCategoriaPorId(id);
        return ResponseEntity.ok(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponse> actualizarCategoria(
            @PathVariable Long id,
            @Valid @RequestBody CrearCategoriaRequest request) {
        CategoriaResponse categoria = categoriaInputPort.actualizarCategoria(id, request);
        return ResponseEntity.ok(categoria);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable Long id) {
        categoriaInputPort.eliminarCategoria(id);
        return ResponseEntity.noContent().build();
    }
}