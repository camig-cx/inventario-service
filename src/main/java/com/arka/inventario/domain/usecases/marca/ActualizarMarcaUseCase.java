package com.arka.inventario.domain.usecases.marca;

import com.arka.inventario.domain.entities.marca.Marca;
import com.arka.inventario.domain.entities.shared.MarcaId;
import com.arka.inventario.domain.exceptions.MarcaNoEncontradaException;
import com.arka.inventario.domain.repositories.MarcaRepository;

import java.time.LocalDateTime;

public class ActualizarMarcaUseCase {

    private final MarcaRepository marcaRepository;

    public ActualizarMarcaUseCase(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca ejecutar(Long id, String nombre, String descripcion) {
        MarcaId marcaId = new MarcaId(id);
        Marca marcaExistente = marcaRepository.findById(marcaId)
                .orElseThrow(() -> new MarcaNoEncontradaException("Marca no encontrada con ID: " + id));

        Marca marcaActualizada = marcaExistente.actualizar(nombre, descripcion);
        return marcaRepository.save(marcaActualizada);
    }
}