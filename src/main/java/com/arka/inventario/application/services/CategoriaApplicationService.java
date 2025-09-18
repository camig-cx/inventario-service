package com.arka.inventario.application.services;

import com.arka.inventario.application.dtos.requests.CrearCategoriaRequest;
import com.arka.inventario.application.dtos.responses.CategoriaResponse;
import com.arka.inventario.application.ports.input.CategoriaInputPort;
import com.arka.inventario.domain.entities.categoria.Categoria;
import com.arka.inventario.domain.usecases.categoria.ActualizarCategoriaUseCase;
import com.arka.inventario.domain.usecases.categoria.CrearCategoriaUseCase;
import com.arka.inventario.domain.usecases.categoria.EliminarCategoriaUseCase;
import com.arka.inventario.domain.usecases.categoria.ObtenerCategoriasUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CategoriaApplicationService implements CategoriaInputPort {

    private final CrearCategoriaUseCase crearCategoriaUseCase;
    private final ObtenerCategoriasUseCase obtenerCategoriasUseCase;
    private final ActualizarCategoriaUseCase actualizarCategoriaUseCase;
    private final EliminarCategoriaUseCase eliminarCategoriaUseCase;

    @Override
    public CategoriaResponse crearCategoria(CrearCategoriaRequest request) {
        Categoria categoria = crearCategoriaUseCase.ejecutar(
                request.getNombre(),
                request.getDescripcion()
        );
        return mapToResponse(categoria);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CategoriaResponse> obtenerTodasLasCategorias() {
        return obtenerCategoriasUseCase.obtenerTodas()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public CategoriaResponse obtenerCategoriaPorId(Long id) {
        Categoria categoria = obtenerCategoriasUseCase.obtenerPorId(id);
        return mapToResponse(categoria);
    }

    @Override
    public CategoriaResponse actualizarCategoria(Long id, CrearCategoriaRequest request) {
        Categoria categoria = actualizarCategoriaUseCase.ejecutar(id, request.getNombre(), request.getDescripcion());
        return mapToResponse(categoria);
    }

    @Override
    public void eliminarCategoria(Long id) {
        eliminarCategoriaUseCase.ejecutar(id);
    }

    private CategoriaResponse mapToResponse(Categoria categoria) {
        return CategoriaResponse.builder()
                .id(categoria.getId() != null ? categoria.getId().value() : null)
                .nombre(categoria.getNombre())
                .descripcion(categoria.getDescripcion())
                .estado(categoria.getEstado().getDescripcion())
                .fechaCreacion(categoria.getFechaCreacion())
                .fechaActualizacion(categoria.getFechaActualizacion())
                .build();
    }
}