package com.arka.inventario.domain.entities.producto;

import com.arka.inventario.domain.entities.shared.CategoriaId;
import com.arka.inventario.domain.entities.shared.EstadoActivo;
import com.arka.inventario.domain.entities.shared.MarcaId;
import com.arka.inventario.domain.entities.shared.ProductoId;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder(toBuilder = true)
public class Producto {
    private ProductoId id;
    private String nombre;
    private String descripcion;
    private BigDecimal precio;
    private Integer stock;
    private EstadoActivo estado;
    private CategoriaId categoriaId;
    private MarcaId marcaId;
    private LocalDateTime fechaCreacion;
    private LocalDateTime fechaActualizacion;

    public static Producto crearNuevo(String nombre, String descripcion, BigDecimal precio,
                                      Integer stock, CategoriaId categoriaId, MarcaId marcaId) {
        return Producto.builder()
                .nombre(nombre)
                .descripcion(descripcion)
                .precio(precio)
                .stock(stock)
                .estado(EstadoActivo.ACTIVO)
                .categoriaId(categoriaId)
                .marcaId(marcaId)
                .fechaCreacion(LocalDateTime.now())
                .fechaActualizacion(LocalDateTime.now())
                .build();
    }

    public boolean tieneStockDisponible(Integer cantidad) {
        return this.stock != null && this.stock >= cantidad;
    }

    public Producto reducirStock(Integer cantidad) {
        if (!tieneStockDisponible(cantidad)) {
            throw new IllegalArgumentException("Stock insuficiente. Disponible: " + this.stock + ", Requerido: " + cantidad);
        }
        return this.toBuilder()
                .stock(this.stock - cantidad)
                .fechaActualizacion(LocalDateTime.now())
                .build();
    }

    public Producto reponerStock(Integer cantidad) {
        return this.toBuilder()
                .stock(this.stock + cantidad)
                .fechaActualizacion(LocalDateTime.now())
                .build();
    }
}