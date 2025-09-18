package com.arka.inventario.application.dtos.responses;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductoResponse {
    private Long id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private String estado;
    private Long categoriaId;
    private String categoriaNombre;
    private Long marcaId;
    private String marcaNombre;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;
}