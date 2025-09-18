package com.arka.inventario.infrastructure.adapters.input.rest;

import com.arka.inventario.application.dtos.requests.CrearMarcaRequest;
import com.arka.inventario.application.dtos.responses.MarcaResponse;
import com.arka.inventario.application.ports.input.MarcaInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/marcas")
@RequiredArgsConstructor
public class MarcaController {

    private final MarcaInputPort marcaInputPort;

    @PostMapping
    public ResponseEntity<MarcaResponse> crearMarca(
            @Valid @RequestBody CrearMarcaRequest request) {
        MarcaResponse marca = marcaInputPort.crearMarca(request);
        return new ResponseEntity<>(marca, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<MarcaResponse>> obtenerTodasLasMarcas() {
        List<MarcaResponse> marcas = marcaInputPort.obtenerTodasLasMarcas();
        return ResponseEntity.ok(marcas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<MarcaResponse> obtenerMarcaPorId(@PathVariable Long id) {
        MarcaResponse marca = marcaInputPort.obtenerMarcaPorId(id);
        return ResponseEntity.ok(marca);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MarcaResponse> actualizarMarca(
            @PathVariable Long id,
            @Valid @RequestBody CrearMarcaRequest request) {
        MarcaResponse marca = marcaInputPort.actualizarMarca(id, request);
        return ResponseEntity.ok(marca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarMarca(@PathVariable Long id) {
        marcaInputPort.eliminarMarca(id);
        return ResponseEntity.noContent().build();
    }
}