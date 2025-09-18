package com.arka.inventario.infrastructure.adapters.output.persistence.repositories;

import com.arka.inventario.infrastructure.adapters.output.persistence.entities.CategoriaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoriaJpaRepository extends JpaRepository<CategoriaEntity, Long> {
    boolean existsByNombre(String nombre);
}