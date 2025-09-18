package com.arka.inventario.infrastructure.adapters.output.persistence;

import com.arka.inventario.domain.entities.producto.Producto;
import com.arka.inventario.domain.entities.shared.ProductoId;
import com.arka.inventario.domain.repositories.ProductoRepository;
import com.arka.inventario.infrastructure.adapters.output.persistence.mappers.ProductoEntityMapper;
import com.arka.inventario.infrastructure.adapters.output.persistence.repositories.ProductoJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Primary  // Para que Spring use este en lugar del temporal
@RequiredArgsConstructor
public class ProductoRepositoryImpl implements ProductoRepository {

    private final ProductoJpaRepository jpaRepository;
    private final ProductoEntityMapper mapper;

    @Override
    public Optional<Producto> findById(ProductoId id) {
        return jpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public Producto save(Producto producto) {
        var entity = mapper.toEntity(producto);
        var savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public List<Producto> findAll() {
        return jpaRepository.findAll()
                .stream()
                .map(mapper::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public boolean existsByNombre(String nombre) {
        return jpaRepository.existsByNombre(nombre);
    }

    @Override
    public void deleteById(ProductoId id) {
        jpaRepository.deleteById(id.value());
    }
}