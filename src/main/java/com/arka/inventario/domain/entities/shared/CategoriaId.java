package com.arka.inventario.domain.entities.shared;

public record CategoriaId(Long value) {
    public CategoriaId {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("El ID de la categoría debe ser un valor positivo");
        }
    }
}