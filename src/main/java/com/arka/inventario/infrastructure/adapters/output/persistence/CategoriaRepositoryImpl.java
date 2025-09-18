package com.arka.inventario.infrastructure.adapters.output.persistence;

import com.arka.inventario.domain.entities.categoria.Categoria;
import com.arka.inventario.domain.entities.shared.CategoriaId;
import com.arka.inventario.domain.repositories.CategoriaRepository;
import com.arka.inventario.infrastructure.adapters.output.persistence.entities.CategoriaEntity;
import com.arka.inventario.infrastructure.adapters.output.persistence.mappers.CategoriaEntityMapper;
import com.arka.inventario.infrastructure.adapters.output.persistence.repositories.CategoriaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class CategoriaRepositoryImpl implements CategoriaRepository {

    private final CategoriaJpaRepository jpaRepository;
    private final CategoriaEntityMapper mapper;

    @Override
    public Optional<Categoria> findById(CategoriaId id) {
        return jpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public Categoria save(Categoria categoria) {
        CategoriaEntity entity = mapper.toEntity(categoria);
        CategoriaEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public List<Categoria> findAll() {
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
    public void deleteById(CategoriaId id) {
        jpaRepository.deleteById(id.value());
    }
}