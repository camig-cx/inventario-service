package com.arka.inventario.application.ports.input;

import com.arka.inventario.application.dtos.requests.CrearCategoriaRequest;
import com.arka.inventario.application.dtos.responses.CategoriaResponse;

import java.util.List;

public interface CategoriaInputPort {
    CategoriaResponse crearCategoria(CrearCategoriaRequest request);
    List<CategoriaResponse> obtenerTodasLasCategorias();
    CategoriaResponse obtenerCategoriaPorId(Long id);
    CategoriaResponse actualizarCategoria(Long id, CrearCategoriaRequest request);
    void eliminarCategoria(Long id);
}