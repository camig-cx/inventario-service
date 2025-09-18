package com.arka.inventario.application.services;

import com.arka.inventario.application.dtos.requests.CrearMarcaRequest;
import com.arka.inventario.application.dtos.responses.MarcaResponse;
import com.arka.inventario.application.ports.input.MarcaInputPort;
import com.arka.inventario.domain.entities.marca.Marca;
import com.arka.inventario.domain.usecases.marca.ActualizarMarcaUseCase;
import com.arka.inventario.domain.usecases.marca.CrearMarcaUseCase;
import com.arka.inventario.domain.usecases.marca.EliminarMarcaUseCase;
import com.arka.inventario.domain.usecases.marca.ObtenerMarcasUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class MarcaApplicationService implements MarcaInputPort {

    private final CrearMarcaUseCase crearMarcaUseCase;
    private final ObtenerMarcasUseCase obtenerMarcasUseCase;
    private final ActualizarMarcaUseCase actualizarMarcaUseCase;
    private final EliminarMarcaUseCase eliminarMarcaUseCase;

    @Override
    public MarcaResponse crearMarca(CrearMarcaRequest request) {
        Marca marca = crearMarcaUseCase.ejecutar(
                request.getNombre(),
                request.getDescripcion()
        );
        return mapToResponse(marca);
    }

    @Override
    @Transactional(readOnly = true)
    public List<MarcaResponse> obtenerTodasLasMarcas() {
        return obtenerMarcasUseCase.obtenerTodas()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public MarcaResponse obtenerMarcaPorId(Long id) {
        Marca marca = obtenerMarcasUseCase.obtenerPorId(id);
        return mapToResponse(marca);
    }

    @Override
    public MarcaResponse actualizarMarca(Long id, CrearMarcaRequest request) {
        Marca marca = actualizarMarcaUseCase.ejecutar(id, request.getNombre(), request.getDescripcion());
        return mapToResponse(marca);
    }

    @Override
    public void eliminarMarca(Long id) {
        eliminarMarcaUseCase.ejecutar(id);
    }

    private MarcaResponse mapToResponse(Marca marca) {
        return MarcaResponse.builder()
                .id(marca.getId() != null ? marca.getId().value() : null)
                .nombre(marca.getNombre())
                .descripcion(marca.getDescripcion())
                .estado(marca.getEstado().getDescripcion())
                .fechaCreacion(marca.getFechaCreacion())
                .fechaActualizacion(marca.getFechaActualizacion())
                .build();
    }
}