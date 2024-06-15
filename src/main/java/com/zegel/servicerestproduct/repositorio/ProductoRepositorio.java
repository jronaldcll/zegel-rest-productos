package com.zegel.servicerestproduct.repositorio;

import com.zegel.servicerestproduct.entidades.Producto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProductoRepositorio extends CrudRepository<Producto, Long> {

    @Query(value = "CALL obtener_producto_mayor_precio()", nativeQuery = true)
    Producto obtenerProductoMayorPrecio();

    @Query(value = "CALL obtener_producto_con_precio_mayor_que(:precio_minimo)", nativeQuery = true)
    List<Producto> obtenerProductoConPrecioMayorQue(@Param("precio_minimo") Double precioMinimo);
}
