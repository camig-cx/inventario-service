package com.arka.inventario.application.dtos.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CrearMarcaRequest {

    @NotBlank(message = "El nombre de la marca es obligatorio")
    private String nombre;

    private String descripcion;
}