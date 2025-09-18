package com.arka.inventario.domain.usecases.categoria;

import com.arka.inventario.domain.entities.categoria.Categoria;
import com.arka.inventario.domain.exceptions.CategoriaNoEncontradaException;
import com.arka.inventario.domain.repositories.CategoriaRepository;

public class CrearCategoriaUseCase {

    private final CategoriaRepository categoriaRepository;

    public CrearCategoriaUseCase(CategoriaRepository categoriaRepository) {
        this.categoriaRepository = categoriaRepository;
    }

    public Categoria ejecutar(String nombre, String descripcion) {
        // Validar que no exista una categoría con el mismo nombre
        if (categoriaRepository.existsByNombre(nombre)) {
            throw new CategoriaNoEncontradaException("Ya existe una categoría con el nombre: " + nombre);
        }

        Categoria categoria = Categoria.crearNueva(nombre, descripcion);
        return categoriaRepository.save(categoria);
    }
}