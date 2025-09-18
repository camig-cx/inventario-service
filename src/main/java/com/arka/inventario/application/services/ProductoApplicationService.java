package com.arka.inventario.application.services;

import com.arka.inventario.application.dtos.requests.CrearProductoRequest;
import com.arka.inventario.application.dtos.responses.ProductoResponse;
import com.arka.inventario.application.ports.input.ProductoInputPort;
import com.arka.inventario.domain.entities.producto.Producto;
import com.arka.inventario.domain.repositories.CategoriaRepository;
import com.arka.inventario.domain.repositories.MarcaRepository;
import com.arka.inventario.domain.usecases.producto.ActualizarProductoUseCase;
import com.arka.inventario.domain.usecases.producto.CrearProductoUseCase;
import com.arka.inventario.domain.usecases.producto.EliminarProductoUseCase;
import com.arka.inventario.domain.usecases.producto.ObtenerProductosUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ProductoApplicationService implements ProductoInputPort {

    private final CrearProductoUseCase crearProductoUseCase;
    private final ObtenerProductosUseCase obtenerProductosUseCase;
    private final ActualizarProductoUseCase actualizarProductoUseCase;
    private final EliminarProductoUseCase eliminarProductoUseCase;

    // AGREGAR: Repositories para obtener nombres
    private final CategoriaRepository categoriaRepository;
    private final MarcaRepository marcaRepository;

    @Override
    public ProductoResponse crearProducto(CrearProductoRequest request) {
        Producto producto = crearProductoUseCase.ejecutar(
                request.getNombre(),
                request.getDescripcion(),
                request.getPrecio(),
                request.getStock(),
                request.getCategoriaId(),
                request.getMarcaId()
        );
        return mapToResponse(producto);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProductoResponse> obtenerTodosLosProductos() {
        return obtenerProductosUseCase.obtenerTodos()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public ProductoResponse obtenerProductoPorId(Long id) {
        Producto producto = obtenerProductosUseCase.obtenerPorId(id);
        return mapToResponse(producto);
    }

    @Override
    public ProductoResponse actualizarProducto(Long id, CrearProductoRequest request) {
        Producto producto = actualizarProductoUseCase.ejecutar(
                id,
                request.getNombre(),
                request.getDescripcion(),
                request.getPrecio(),
                request.getStock(),
                request.getCategoriaId(),
                request.getMarcaId()
        );
        return mapToResponse(producto);
    }

    @Override
    public void eliminarProducto(Long id) {
        eliminarProductoUseCase.ejecutar(id);
    }

    private ProductoResponse mapToResponse(Producto producto) {
        // OBTENER NOMBRES DE CATEGORÍA Y MARCA
        String categoriaNombre = categoriaRepository.findById(producto.getCategoriaId())
                .map(categoria -> categoria.getNombre())
                .orElse("Categoría no encontrada");

        String marcaNombre = marcaRepository.findById(producto.getMarcaId())
                .map(marca -> marca.getNombre())
                .orElse("Marca no encontrada");

        return ProductoResponse.builder()
                .id(producto.getId() != null ? producto.getId().value() : null)
                .nombre(producto.getNombre())
                .descripcion(producto.getDescripcion())
                .precio(producto.getPrecio())
                .stock(producto.getStock())
                .estado(producto.getEstado().getDescripcion())
                .categoriaId(producto.getCategoriaId().value())
                .categoriaNombre(categoriaNombre)  // AGREGAR NOMBRE
                .marcaId(producto.getMarcaId().value())
                .marcaNombre(marcaNombre)  // AGREGAR NOMBRE
                .fechaCreacion(producto.getFechaCreacion())
                .fechaActualizacion(producto.getFechaActualizacion())
                .build();
    }
}