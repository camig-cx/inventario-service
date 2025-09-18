package com.arka.inventario.domain.usecases.categoria;

import com.arka.inventario.domain.entities.categoria.Categoria;
import com.arka.inventario.domain.entities.shared.CategoriaId;
import com.arka.inventario.domain.exceptions.CategoriaNoEncontradaException;
import com.arka.inventario.domain.repositories.CategoriaRepository;

public class ActualizarCategoriaUseCase {

    private final CategoriaRepository categoriaRepository;

    public ActualizarCategoriaUseCase(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria ejecutar(Long id, String nombre, String descripcion) {
        CategoriaId categoriaId = new CategoriaId(id);
        Categoria categoriaExistente = categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new CategoriaNoEncontradaException("Categoría no encontrada con ID: " + id));

        Categoria categoriaActualizada = categoriaExistente.actualizar(nombre, descripcion);
        return categoriaRepository.save(categoriaActualizada);
    }
}