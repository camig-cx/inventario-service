package com.arka.inventario.domain.usecases.marca;

import com.arka.inventario.domain.entities.shared.MarcaId;
import com.arka.inventario.domain.exceptions.MarcaNoEncontradaException;
import com.arka.inventario.domain.repositories.MarcaRepository;

public class EliminarMarcaUseCase {

    private final MarcaRepository marcaRepository;

    public EliminarMarcaUseCase(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public void ejecutar(Long id) {
        MarcaId marcaId = new MarcaId(id);
        if (marcaRepository.findById(marcaId).isEmpty()) {
            throw new MarcaNoEncontradaException("Marca no encontrada con ID: " + id);
        }
        marcaRepository.deleteById(marcaId);
    }
}