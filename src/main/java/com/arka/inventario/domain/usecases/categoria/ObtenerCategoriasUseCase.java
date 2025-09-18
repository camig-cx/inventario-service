package com.arka.inventario.domain.usecases.categoria;

import com.arka.inventario.domain.entities.categoria.Categoria;
import com.arka.inventario.domain.entities.shared.CategoriaId;
import com.arka.inventario.domain.exceptions.CategoriaNoEncontradaException;
import com.arka.inventario.domain.repositories.CategoriaRepository;

import java.util.List;

public class ObtenerCategoriasUseCase {

    private final CategoriaRepository categoriaRepository;

    public ObtenerCategoriasUseCase(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public List<Categoria> obtenerTodas() {
        return categoriaRepository.findAll();
    }

    public Categoria obtenerPorId(Long id) {
        CategoriaId categoriaId = new CategoriaId(id);
        return categoriaRepository.findById(categoriaId)
                .orElseThrow(() -> new CategoriaNoEncontradaException("Categoría no encontrada con ID: " + id));
    }
}