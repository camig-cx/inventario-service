package com.arka.inventario.domain.entities.marca;

import com.arka.inventario.domain.entities.shared.EstadoActivo;
import com.arka.inventario.domain.entities.shared.MarcaId;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class Marca {
    private MarcaId id;
    private String nombre;
    private String descripcion;
    private EstadoActivo estado;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public static Marca crearNueva(String nombre, String descripcion) {
        return Marca.builder()
                .nombre(nombre)
                .descripcion(descripcion)
                .estado(EstadoActivo.ACTIVO)
                .fechaCreacion(LocalDateTime.now())
                .fechaActualizacion(LocalDateTime.now())
                .build();
    }

    public Marca actualizar(String nombre, String descripcion) {
        return this.toBuilder()
                .nombre(nombre)
                .descripcion(descripcion)
                .fechaActualizacion(LocalDateTime.now())
                .build();
    }
}