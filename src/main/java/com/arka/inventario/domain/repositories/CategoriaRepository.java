package com.arka.inventario.domain.repositories;

import com.arka.inventario.domain.entities.categoria.Categoria;
import com.arka.inventario.domain.entities.shared.CategoriaId;

import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {
    Optional<Categoria> findById(CategoriaId id);
    Categoria save(Categoria categoria);
    List<Categoria> findAll();
    boolean existsByNombre(String nombre);
    void deleteById(CategoriaId id);
}