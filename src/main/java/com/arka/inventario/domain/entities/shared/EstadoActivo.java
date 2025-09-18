package com.arka.inventario.domain.entities.shared;

public enum EstadoActivo {
    ACTIVO(true, "Activo"),
    INACTIVO(false, "Inactivo");

    private final boolean valor;
    private final String descripcion;

    EstadoActivo(boolean valor, String descripcion) {
        this.valor = valor;
        this.descripcion = descripcion;
    }

    public boolean getValor() {
        return valor;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public static EstadoActivo fromBoolean(boolean valor) {
        return valor ? ACTIVO : INACTIVO;
    }
}