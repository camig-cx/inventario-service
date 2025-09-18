package com.arka.inventario.infrastructure.adapters.output.persistence.repositories;

import com.arka.inventario.infrastructure.adapters.output.persistence.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductoJpaRepository extends JpaRepository<ProductoEntity, Long> {

    boolean existsByNombre(String nombre);

    List<ProductoEntity> findByCategoriaId(Long categoriaId);

    List<ProductoEntity> findByMarcaId(Long marcaId);

    @Query("SELECT p FROM ProductoEntity p WHERE p.activo = true")
    List<ProductoEntity> findAllActivos();

    @Query("SELECT p FROM ProductoEntity p WHERE p.stock > :minStock")
    List<ProductoEntity> findByStockGreaterThan(@Param("minStock") Integer minStock);
}