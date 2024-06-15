package com.zegel.servicerestproduct.negocio;

import com.zegel.servicerestproduct.entidades.Producto;
import com.zegel.servicerestproduct.repositorio.ProductoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductoNegocio {
    @Autowired
    private ProductoRepositorio productoRepositorio;
    public Producto grabar(Producto producto) {
        return productoRepositorio.save(producto);
    }

    public List<Producto> obtenerProductos() {
        return (List<Producto>) productoRepositorio.findAll();
    }

    public Producto actualizar(Producto producto){
        Producto p = productoRepositorio.findById(producto.getCodigo()).get();
        if(p!= null){
            return productoRepositorio.save(producto);
        } else {
            return null;
        }
    }
    public Producto borrarProducto(Long codigo){
        Producto producto = productoRepositorio.findById(codigo).get();

        if(producto!=null){
            productoRepositorio.delete(producto);
        }else {
            return null;
        }
        return producto;
    }

    public Producto obtenerProductoMayorPrecio(){
        return productoRepositorio.obtenerProductoMayorPrecio();
    }

    public List<Producto> obtenerProductoConPrecioMayorQue(Double precioMinimo){
        return productoRepositorio.obtenerProductoConPrecioMayorQue(precioMinimo);
    }
}
