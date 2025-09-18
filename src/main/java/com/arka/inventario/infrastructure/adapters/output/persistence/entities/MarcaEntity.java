package com.arka.inventario.infrastructure.adapters.output.persistence.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "marcas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MarcaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "marca_id")
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String descripcion;

    // Usar la columna 'activo' que es tinyint(1)
    @Column(name = "activo")
    @Builder.Default
    private Boolean activo = true;

    // Usar la columna 'estado' que es ENUM
    @Enumerated(EnumType.STRING)
    @Column(name = "estado")
    @Builder.Default
    private EstadoEnum estado = EstadoEnum.ACTIVO;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Column(name = "fecha_actualizacion")
    private LocalDateTime fechaActualizacion;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        LocalDateTime now = LocalDateTime.now();
        if (fechaCreacion == null) fechaCreacion = now;
        if (fechaActualizacion == null) fechaActualizacion = now;
        if (createdAt == null) createdAt = now;
        if (updatedAt == null) updatedAt = now;
        if (activo == null) activo = true;
        if (estado == null) estado = EstadoEnum.ACTIVO;
    }

    @PreUpdate
    protected void onUpdate() {
        LocalDateTime now = LocalDateTime.now();
        fechaActualizacion = now;
        updatedAt = now;
    }

    // Enum para el estado
    public enum EstadoEnum {
        ACTIVO, INACTIVO
    }
}