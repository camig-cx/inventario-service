package com.arka.inventario.domain.entities.shared;

public record ProductoId(Long value) {
    public ProductoId {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("El ID del producto debe ser un valor positivo");
        }
    }
}