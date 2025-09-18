package com.arka.inventario.domain.usecases.producto;

import com.arka.inventario.domain.entities.shared.ProductoId;
import com.arka.inventario.domain.exceptions.ProductoNoEncontradoException;
import com.arka.inventario.domain.repositories.ProductoRepository;

public class EliminarProductoUseCase {

    private final ProductoRepository productoRepository;

    public EliminarProductoUseCase(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    public void ejecutar(Long id) {
        ProductoId productoId = new ProductoId(id);

        if (productoRepository.findById(productoId).isEmpty()) {
            throw new ProductoNoEncontradoException("Producto no encontrado con ID: " + id);
        }

        productoRepository.deleteById(productoId);
    }
}