package com.arka.inventario.domain.entities.shared;

public record MarcaId(Long value) {
    public MarcaId {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("El ID de la marca debe ser un valor positivo");
        }
    }
}