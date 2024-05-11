package com.zegel.servicerestproduct.rest;

import com.zegel.servicerestproduct.entidades.Producto;
import com.zegel.servicerestproduct.negocio.ProductoNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductoREST {
    @Autowired
    private ProductoNegocio productoNegocio;

    @PostMapping("/producto")
    public Producto grabar(@RequestBody Producto producto) {
        return productoNegocio.grabar(producto);
    }

    @GetMapping("productos")
    public List<Producto> obtenerProductos() {
        try {
            return productoNegocio.obtenerProductos();
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible obtener los datos");
        }
    }

    @PutMapping("/actualizar")
    public Producto actualizar(@RequestBody Producto producto){
        try{
            return productoNegocio.actualizar(producto);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible actualizar");
        }
    }

    @DeleteMapping("/producto/{codigo}")
    public Producto borrarProducto(@PathVariable(value = "codigo") Long codigo){
        return productoNegocio.borrarProducto(codigo);
    }
}
