package com.arka.inventario.infrastructure.adapters.input.rest;

import com.arka.inventario.application.dtos.requests.CrearProductoRequest;
import com.arka.inventario.application.dtos.responses.ProductoResponse;
import com.arka.inventario.application.ports.input.ProductoInputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/productos")
@RequiredArgsConstructor
public class ProductoController {

    private final ProductoInputPort productoInputPort;

    @PostMapping
    public ResponseEntity<ProductoResponse> crearProducto(
            @Valid @RequestBody CrearProductoRequest request) {
        ProductoResponse producto = productoInputPort.crearProducto(request);
        return new ResponseEntity<>(producto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductoResponse>> obtenerTodosLosProductos() {
        List<ProductoResponse> productos = productoInputPort.obtenerTodosLosProductos();
        return ResponseEntity.ok(productos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductoResponse> obtenerProductoPorId(@PathVariable Long id) {
        ProductoResponse producto = productoInputPort.obtenerProductoPorId(id);
        return ResponseEntity.ok(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductoResponse> actualizarProducto(
            @PathVariable Long id,
            @Valid @RequestBody CrearProductoRequest request) {
        ProductoResponse producto = productoInputPort.actualizarProducto(id, request);
        return ResponseEntity.ok(producto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable Long id) {
        productoInputPort.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
}