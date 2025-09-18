package com.arka.inventario.domain.usecases.marca;

import com.arka.inventario.domain.entities.marca.Marca;
import com.arka.inventario.domain.exceptions.MarcaNoEncontradaException;
import com.arka.inventario.domain.repositories.MarcaRepository;

public class CrearMarcaUseCase {

    private final MarcaRepository marcaRepository;

    public CrearMarcaUseCase(MarcaRepository marcaRepository) {
        this.marcaRepository = marcaRepository;
    }

    public Marca ejecutar(String nombre, String descripcion) {
        if (marcaRepository.existsByNombre(nombre)) {
            throw new MarcaNoEncontradaException("Ya existe una marca con el nombre: " + nombre);
        }

        Marca marca = Marca.crearNueva(nombre, descripcion);
        return marcaRepository.save(marca);
    }
}