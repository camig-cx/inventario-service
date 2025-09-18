package com.arka.inventario.domain.usecases.producto;

import com.arka.inventario.domain.entities.producto.Producto;
import com.arka.inventario.domain.entities.shared.CategoriaId;
import com.arka.inventario.domain.entities.shared.MarcaId;
import com.arka.inventario.domain.entities.shared.ProductoId;
import com.arka.inventario.domain.exceptions.CategoriaNoEncontradaException;
import com.arka.inventario.domain.exceptions.MarcaNoEncontradaException;
import com.arka.inventario.domain.exceptions.ProductoNoEncontradoException;
import com.arka.inventario.domain.repositories.CategoriaRepository;
import com.arka.inventario.domain.repositories.MarcaRepository;
import com.arka.inventario.domain.repositories.ProductoRepository;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class ActualizarProductoUseCase {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final MarcaRepository marcaRepository;

    public ActualizarProductoUseCase(ProductoRepository productoRepository,
                                     CategoriaRepository categoriaRepository,
                                     MarcaRepository marcaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.marcaRepository = marcaRepository;
    }

    public Producto ejecutar(Long id, String nombre, String descripcion, BigDecimal precio,
                             Integer stock, Long categoriaId, Long marcaId) {

        // Buscar el producto existente
        ProductoId productoId = new ProductoId(id);
        Producto productoExistente = productoRepository.findById(productoId)
                .orElseThrow(() -> new ProductoNoEncontradoException("Producto no encontrado con ID: " + id));

        // Validar que la categoría exista
        CategoriaId catId = new CategoriaId(categoriaId);
        if (categoriaRepository.findById(catId).isEmpty()) {
            throw new CategoriaNoEncontradaException("Categoría no encontrada con ID: " + categoriaId);
        }

        // Validar que la marca exista
        MarcaId marId = new MarcaId(marcaId);
        if (marcaRepository.findById(marId).isEmpty()) {
            throw new MarcaNoEncontradaException("Marca no encontrada con ID: " + marcaId);
        }

        // Crear producto actualizado
        Producto productoActualizado = productoExistente.toBuilder()
                .nombre(nombre)
                .descripcion(descripcion)
                .precio(precio)
                .stock(stock)
                .categoriaId(catId)
                .marcaId(marId)
                .fechaActualizacion(LocalDateTime.now())
                .build();

        return productoRepository.save(productoActualizado);
    }
}