package com.arka.inventario.infrastructure.adapters.output.persistence.mappers;

import com.arka.inventario.domain.entities.marca.Marca;
import com.arka.inventario.domain.entities.shared.EstadoActivo;
import com.arka.inventario.domain.entities.shared.MarcaId;
import com.arka.inventario.infrastructure.adapters.output.persistence.entities.MarcaEntity;
import org.springframework.stereotype.Component;

@Component
public class MarcaEntityMapper {

    public Marca toDomain(MarcaEntity entity) {
        return Marca.builder()
                .id(entity.getId() != null ? new MarcaId(entity.getId()) : null)
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                // Usar la columna enum 'estado'
                .estado(entity.getEstado() == MarcaEntity.EstadoEnum.ACTIVO ?
                        EstadoActivo.ACTIVO : EstadoActivo.INACTIVO)
                .fechaCreacion(entity.getFechaCreacion())
                .fechaActualizacion(entity.getFechaActualizacion())
                .build();
    }

    public MarcaEntity toEntity(Marca marca) {
        return MarcaEntity.builder()
                .id(marca.getId() != null ? marca.getId().value() : null)
                .nombre(marca.getNombre())
                .descripcion(marca.getDescripcion())
                // Mapear tanto 'activo' como 'estado'
                .activo(marca.getEstado() == EstadoActivo.ACTIVO)
                .estado(marca.getEstado() == EstadoActivo.ACTIVO ?
                        MarcaEntity.EstadoEnum.ACTIVO : MarcaEntity.EstadoEnum.INACTIVO)
                .fechaCreacion(marca.getFechaCreacion())
                .fechaActualizacion(marca.getFechaActualizacion())
                .build();
    }
}