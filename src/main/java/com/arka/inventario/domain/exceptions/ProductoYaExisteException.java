package com.arka.inventario.domain.exceptions;

public class ProductoYaExisteException extends DomainException {
    public ProductoYaExisteException(String message) {
        super(message);
    }
}