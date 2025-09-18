package com.arka.inventario.infrastructure.adapters.output.persistence.mappers;

import com.arka.inventario.domain.entities.producto.Producto;
import com.arka.inventario.domain.entities.shared.CategoriaId;
import com.arka.inventario.domain.entities.shared.EstadoActivo;
import com.arka.inventario.domain.entities.shared.MarcaId;
import com.arka.inventario.domain.entities.shared.ProductoId;
import com.arka.inventario.infrastructure.adapters.output.persistence.entities.ProductoEntity;
import org.springframework.stereotype.Component;

@Component
public class ProductoEntityMapper {

    public Producto toDomain(ProductoEntity entity) {
        return Producto.builder()
                .id(entity.getId() != null ? new ProductoId(entity.getId()) : null)
                .nombre(entity.getNombre())
                .descripcion(entity.getDescripcion())
                .precio(entity.getPrecio())
                .stock(entity.getStock())
                .estado(entity.getActivo() ? EstadoActivo.ACTIVO : EstadoActivo.INACTIVO)
                .categoriaId(new CategoriaId(entity.getCategoriaId()))
                .marcaId(new MarcaId(entity.getMarcaId()))
                .fechaCreacion(entity.getFechaCreacion())
                .fechaActualizacion(entity.getFechaActualizacion())
                .build();
    }

    public ProductoEntity toEntity(Producto producto) {
        return ProductoEntity.builder()
                .id(producto.getId() != null ? producto.getId().value() : null)
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .activo(producto.getEstado() == EstadoActivo.ACTIVO)
                .categoriaId(producto.getCategoriaId().value())
                .marcaId(producto.getMarcaId().value())
                .fechaCreacion(producto.getFechaCreacion())
                .fechaActualizacion(producto.getFechaActualizacion())
                .build();
    }
}