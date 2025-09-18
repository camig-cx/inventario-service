package com.arka.inventario.domain.exceptions;

public class ProductoNoEncontradoException extends DomainException {
    public ProductoNoEncontradoException(String message) {
        super(message);
    }
}