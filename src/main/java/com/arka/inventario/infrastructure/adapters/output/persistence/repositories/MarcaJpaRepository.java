package com.arka.inventario.infrastructure.adapters.output.persistence.repositories;

import com.arka.inventario.infrastructure.adapters.output.persistence.entities.MarcaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MarcaJpaRepository extends JpaRepository<MarcaEntity, Long> {
    boolean existsByNombre(String nombre);
}