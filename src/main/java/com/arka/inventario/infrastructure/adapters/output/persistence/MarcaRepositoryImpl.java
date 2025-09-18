package com.arka.inventario.infrastructure.adapters.output.persistence;

import com.arka.inventario.domain.entities.marca.Marca;
import com.arka.inventario.domain.entities.shared.MarcaId;
import com.arka.inventario.domain.repositories.MarcaRepository;
import com.arka.inventario.infrastructure.adapters.output.persistence.mappers.MarcaEntityMapper;
import com.arka.inventario.infrastructure.adapters.output.persistence.repositories.MarcaJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@Primary  // Para que Spring use este en lugar del temporal
@RequiredArgsConstructor
public class MarcaRepositoryImpl implements MarcaRepository {

    private final MarcaJpaRepository jpaRepository;
    private final MarcaEntityMapper mapper;

    @Override
    public Optional<Marca> findById(MarcaId id) {
        return jpaRepository.findById(id.value())
                .map(mapper::toDomain);
    }

    @Override
    public Marca save(Marca marca) {
        var entity = mapper.toEntity(marca);
        var savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public List<Marca> findAll() {
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
    public void deleteById(MarcaId id) {
        jpaRepository.deleteById(id.value());
    }
}