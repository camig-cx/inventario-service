package com.arka.inventario.application.ports.input;

import com.arka.inventario.application.dtos.requests.CrearMarcaRequest;
import com.arka.inventario.application.dtos.responses.MarcaResponse;

import java.util.List;

public interface MarcaInputPort {
    MarcaResponse crearMarca(CrearMarcaRequest request);
    List<MarcaResponse> obtenerTodasLasMarcas();
    MarcaResponse obtenerMarcaPorId(Long id);
    MarcaResponse actualizarMarca(Long id, CrearMarcaRequest request);
    void eliminarMarca(Long id);
}