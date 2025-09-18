package com.arka.inventario.application.ports.input;

import com.arka.inventario.application.dtos.requests.CrearProductoRequest;
import com.arka.inventario.application.dtos.responses.ProductoResponse;

import java.util.List;

public interface ProductoInputPort {
    ProductoResponse crearProducto(CrearProductoRequest request);
    List<ProductoResponse> obtenerTodosLosProductos();
    ProductoResponse obtenerProductoPorId(Long id);
    ProductoResponse actualizarProducto(Long id, CrearProductoRequest request);
    void eliminarProducto(Long id);
}