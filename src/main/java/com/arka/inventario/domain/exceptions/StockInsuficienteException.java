package com.arka.inventario.domain.exceptions;

public class StockInsuficienteException extends DomainException {
    public StockInsuficienteException(String message) {
        super(message);
    }
}