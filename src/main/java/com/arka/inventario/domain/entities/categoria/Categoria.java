package com.arka.inventario.domain.entities.categoria;

import com.arka.inventario.domain.entities.shared.CategoriaId;
import com.arka.inventario.domain.entities.shared.EstadoActivo;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class Categoria {
    private CategoriaId id;
    private String nombre;
    private String descripcion;
    private EstadoActivo estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public static Categoria crearNueva(String nombre, String descripcion) {
        return Categoria.builder()
                .nombre(nombre)
                .descripcion(descripcion)
                .estado(EstadoActivo.ACTIVO)
                .fechaCreacion(LocalDateTime.now())
                .fechaActualizacion(LocalDateTime.now())
                .build();
    }

    public Categoria actualizar(String nombre, String descripcion) {
        return this.toBuilder()
                .nombre(nombre)
                .descripcion(descripcion)
                .fechaActualizacion(LocalDateTime.now())
                .build();
    }
}