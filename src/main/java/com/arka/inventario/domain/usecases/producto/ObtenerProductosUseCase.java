package com.arka.inventario.domain.usecases.producto;

import com.arka.inventario.domain.entities.producto.Producto;
import com.arka.inventario.domain.entities.shared.ProductoId;
import com.arka.inventario.domain.exceptions.ProductoNoEncontradoException;
import com.arka.inventario.domain.repositories.ProductoRepository;

import java.util.List;

public class ObtenerProductosUseCase {

    private final ProductoRepository productoRepository;

    public ObtenerProductosUseCase(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public List<Producto> obtenerTodos() {
        return productoRepository.findAll();
    }

    public Producto obtenerPorId(Long id) {
        ProductoId productoId = new ProductoId(id);
        return productoRepository.findById(productoId)
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado con ID: " + id));
    }
}