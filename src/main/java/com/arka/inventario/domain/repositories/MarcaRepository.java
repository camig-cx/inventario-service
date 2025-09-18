package com.arka.inventario.domain.repositories;

import com.arka.inventario.domain.entities.marca.Marca;
import com.arka.inventario.domain.entities.shared.MarcaId;

import java.util.List;
import java.util.Optional;

public interface MarcaRepository {
    Optional<Marca> findById(MarcaId id);
    Marca save(Marca marca);
    List<Marca> findAll();
    boolean existsByNombre(String nombre);
    void deleteById(MarcaId id);
}