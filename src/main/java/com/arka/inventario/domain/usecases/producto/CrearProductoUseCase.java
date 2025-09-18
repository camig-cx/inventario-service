package com.arka.inventario.domain.usecases.producto;

import com.arka.inventario.domain.entities.producto.Producto;
import com.arka.inventario.domain.entities.shared.CategoriaId;
import com.arka.inventario.domain.entities.shared.MarcaId;
import com.arka.inventario.domain.exceptions.CategoriaNoEncontradaException;
import com.arka.inventario.domain.exceptions.MarcaNoEncontradaException;
import com.arka.inventario.domain.exceptions.ProductoYaExisteException;
import com.arka.inventario.domain.repositories.CategoriaRepository;
import com.arka.inventario.domain.repositories.MarcaRepository;
import com.arka.inventario.domain.repositories.ProductoRepository;

import java.math.BigDecimal;

public class CrearProductoUseCase {

    private final ProductoRepository productoRepository;
    private final CategoriaRepository categoriaRepository;
    private final MarcaRepository marcaRepository;

    public CrearProductoUseCase(ProductoRepository productoRepository,
                                CategoriaRepository categoriaRepository,
                                MarcaRepository marcaRepository) {
        this.productoRepository = productoRepository;
        this.categoriaRepository = categoriaRepository;
        this.marcaRepository = marcaRepository;
    }

    public Producto ejecutar(String nombre, String descripcion, BigDecimal precio,
                             Integer stock, Long categoriaId, Long marcaId) {

        // Validar que no exista un producto con el mismo nombre
        if (productoRepository.existsByNombre(nombre)) {
            throw new ProductoYaExisteException("Ya existe un producto con el nombre: " + nombre);
        }

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

        // Crear el producto
        Producto producto = Producto.crearNuevo(nombre, descripcion, precio, stock, catId, marId);

        return productoRepository.save(producto);
    }
}