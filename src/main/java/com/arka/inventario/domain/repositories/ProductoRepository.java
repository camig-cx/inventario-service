package com.arka.inventario.domain.repositories;

import com.arka.inventario.domain.entities.producto.Producto;
import com.arka.inventario.domain.entities.shared.ProductoId;

import java.util.List;
import java.util.Optional;

public interface ProductoRepository {
    Optional<Producto> findById(ProductoId id);
    Producto save(Producto producto);
    List<Producto> findAll();
    boolean existsByNombre(String nombre);
    void deleteById(ProductoId id);
}