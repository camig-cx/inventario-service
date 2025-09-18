package com.arka.carrito.domain.usecases;

import com.arka.carrito.domain.entities.Carrito;
import com.arka.carrito.domain.entities.CarritoItem;
import com.arka.carrito.domain.ports.output.CarritoRepository;
import com.arka.carrito.domain.valueobjects.CarritoId;
import com.arka.carrito.domain.valueobjects.CarritoItemId;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
public class ActualizarCantidadItemUseCase {
    
    private final CarritoRepository carritoRepository;

    @Transactional
    public Optional<Carrito> ejecutar(Long carritoId, Long itemId, Integer nuevaCantidad) {
        log.debug("Actualizando cantidad: carritoId={}, itemId={}, nuevaCantidad={}", 
                carritoId, itemId, nuevaCantidad);

        CarritoId cId = new CarritoId(carritoId);
        CarritoItemId iId = new CarritoItemId(itemId);

        // 1. Buscar el carrito
        Optional<Carrito> carritoOpt = carritoRepository.findById(cId);

        if (carritoOpt.isPresent()) {
            Carrito carrito = carritoOpt.get();
            
            // 2. Buscar el item específico
            Optional<CarritoItem> itemOpt = carrito.getItems().stream()
                    .filter(item -> item.getId().equals(iId))
                    .findFirst();
            
            if (itemOpt.isPresent()) {
                CarritoItem item = itemOpt.get();
                
                // 3. Actualizar cantidad usando método de dominio
                if (nuevaCantidad > item.getCantidad()) {
                    // Aumentar cantidad
                    int diferencia = nuevaCantidad - item.getCantidad();
                    item.aumentarCantidad(diferencia);
                } else if (nuevaCantidad < item.getCantidad()) {
                    // Disminuir cantidad
                    int diferencia = item.getCantidad() - nuevaCantidad;
                    item.disminuirCantidad(diferencia);
                }
                // Si nuevaCantidad == cantidad actual, no hacer nada
                
                // 4. Guardar carrito actualizado
                Carrito carritoActualizado = carritoRepository.save(carrito);
                log.debug("Cantidad actualizada exitosamente");
                return Optional.of(carritoActualizado);
            } else {
                log.warn("Item no encontrado: itemId={}", itemId);
                return Optional.empty();
            }
        }

        log.warn("Carrito no encontrado: carritoId={}", carritoId);
        return Optional.empty();
    }
}
