package com.arka.inventario.domain.usecases.categoria;

import com.arka.inventario.domain.entities.shared.CategoriaId;
import com.arka.inventario.domain.exceptions.CategoriaNoEncontradaException;
import com.arka.inventario.domain.repositories.CategoriaRepository;

public class EliminarCategoriaUseCase {

    private final CategoriaRepository categoriaRepository;

    public EliminarCategoriaUseCase(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public void ejecutar(Long id) {
        CategoriaId categoriaId = new CategoriaId(id);
        if (categoriaRepository.findById(categoriaId).isEmpty()) {
            throw new CategoriaNoEncontradaException("Categoría no encontrada con ID: " + id);
        }
        categoriaRepository.deleteById(categoriaId);
    }
}