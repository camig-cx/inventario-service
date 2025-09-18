package com.arka.inventario.infrastructure.adapters.output.persistence.mappers;

import com.arka.inventario.domain.entities.categoria.Categoria;
import com.arka.inventario.domain.entities.shared.CategoriaId;
import com.arka.inventario.domain.entities.shared.EstadoActivo;
import com.arka.inventario.infrastructure.adapters.output.persistence.entities.CategoriaEntity;
import org.springframework.stereotype.Component;

@Component
public class CategoriaEntityMapper {

    public Categoria toDomain(CategoriaEntity entity) {
        return Categoria.builder()
                .id(entity.getId() != null ? new CategoriaId(entity.getId()) : null)
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .estado(entity.getActivo() ? EstadoActivo.ACTIVO : EstadoActivo.INACTIVO)
                .fechaCreacion(entity.getFechaCreacion())
                .fechaActualizacion(entity.getFechaActualizacion())
                .build();
    }

    public CategoriaEntity toEntity(Categoria categoria) {
        return CategoriaEntity.builder()
                .id(categoria.getId() != null ? categoria.getId().value() : null)
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .activo(categoria.getEstado() == EstadoActivo.ACTIVO)
                .fechaCreacion(categoria.getFechaCreacion())
                .fechaActualizacion(categoria.getFechaActualizacion())
                .build();
    }
}