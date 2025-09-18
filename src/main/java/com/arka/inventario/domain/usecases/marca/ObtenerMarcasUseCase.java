package com.arka.inventario.domain.usecases.marca;

import com.arka.inventario.domain.entities.marca.Marca;
import com.arka.inventario.domain.entities.shared.MarcaId;
import com.arka.inventario.domain.exceptions.MarcaNoEncontradaException;
import com.arka.inventario.domain.repositories.MarcaRepository;

import java.util.List;

public class ObtenerMarcasUseCase {

    private final MarcaRepository marcaRepository;

    public ObtenerMarcasUseCase(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public List<Marca> obtenerTodas() {
        return marcaRepository.findAll();
    }

    public Marca obtenerPorId(Long id) {
        MarcaId marcaId = new MarcaId(id);
        return marcaRepository.findById(marcaId)
                .orElseThrow(() -> new MarcaNoEncontradaException("Marca no encontrada con ID: " + id));
    }
}