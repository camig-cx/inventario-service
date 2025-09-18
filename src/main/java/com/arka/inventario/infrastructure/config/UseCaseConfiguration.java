package com.arka.inventario.infrastructure.config;

import com.arka.inventario.domain.repositories.CategoriaRepository;
import com.arka.inventario.domain.repositories.MarcaRepository;
import com.arka.inventario.domain.repositories.ProductoRepository;
import com.arka.inventario.domain.usecases.categoria.ActualizarCategoriaUseCase;
import com.arka.inventario.domain.usecases.categoria.CrearCategoriaUseCase;
import com.arka.inventario.domain.usecases.categoria.EliminarCategoriaUseCase;
import com.arka.inventario.domain.usecases.categoria.ObtenerCategoriasUseCase;
import com.arka.inventario.domain.usecases.marca.ActualizarMarcaUseCase;
import com.arka.inventario.domain.usecases.marca.CrearMarcaUseCase;
import com.arka.inventario.domain.usecases.marca.EliminarMarcaUseCase;
import com.arka.inventario.domain.usecases.marca.ObtenerMarcasUseCase;
import com.arka.inventario.domain.usecases.producto.ActualizarProductoUseCase;
import com.arka.inventario.domain.usecases.producto.CrearProductoUseCase;
import com.arka.inventario.domain.usecases.producto.EliminarProductoUseCase;
import com.arka.inventario.domain.usecases.producto.ObtenerProductosUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfiguration {

    // ====================================
    // CASOS DE USO DE PRODUCTO
    // ====================================

    @Bean
    public CrearProductoUseCase crearProductoUseCase(
            ProductoRepository productoRepository,
            CategoriaRepository categoriaRepository,
            MarcaRepository marcaRepository) {
        return new CrearProductoUseCase(productoRepository, categoriaRepository, marcaRepository);
    }

    @Bean
    public ObtenerProductosUseCase obtenerProductosUseCase(ProductoRepository productoRepository) {
        return new ObtenerProductosUseCase(productoRepository);
    }

    @Bean
    public ActualizarProductoUseCase actualizarProductoUseCase(
            ProductoRepository productoRepository,
            CategoriaRepository categoriaRepository,
            MarcaRepository marcaRepository) {
        return new ActualizarProductoUseCase(productoRepository, categoriaRepository, marcaRepository);
    }

    @Bean
    public EliminarProductoUseCase eliminarProductoUseCase(ProductoRepository productoRepository) {
        return new EliminarProductoUseCase(productoRepository);
    }

    // ====================================
    // CASOS DE USO DE CATEGORÍA
    // ====================================

    @Bean
    public CrearCategoriaUseCase crearCategoriaUseCase(CategoriaRepository categoriaRepository) {
        return new CrearCategoriaUseCase(categoriaRepository);
    }

    @Bean
    public ObtenerCategoriasUseCase obtenerCategoriasUseCase(CategoriaRepository categoriaRepository) {
        return new ObtenerCategoriasUseCase(categoriaRepository);
    }

    @Bean
    public ActualizarCategoriaUseCase actualizarCategoriaUseCase(CategoriaRepository categoriaRepository) {
        return new ActualizarCategoriaUseCase(categoriaRepository);
    }

    @Bean
    public EliminarCategoriaUseCase eliminarCategoriaUseCase(CategoriaRepository categoriaRepository) {
        return new EliminarCategoriaUseCase(categoriaRepository);
    }

    // ====================================
    // CASOS DE USO DE MARCA
    // ====================================

    @Bean
    public CrearMarcaUseCase crearMarcaUseCase(MarcaRepository marcaRepository) {
        return new CrearMarcaUseCase(marcaRepository);
    }

    @Bean
    public ObtenerMarcasUseCase obtenerMarcasUseCase(MarcaRepository marcaRepository) {
        return new ObtenerMarcasUseCase(marcaRepository);
    }

    @Bean
    public ActualizarMarcaUseCase actualizarMarcaUseCase(MarcaRepository marcaRepository) {
        return new ActualizarMarcaUseCase(marcaRepository);
    }

    @Bean
    public EliminarMarcaUseCase eliminarMarcaUseCase(MarcaRepository marcaRepository) {
        return new EliminarMarcaUseCase(marcaRepository);
    }
}