package com.zegel.servicerestproduct.rest;

import com.zegel.servicerestproduct.entidades.Producto;
import com.zegel.servicerestproduct.entidades.Venta;
import com.zegel.servicerestproduct.negocio.ProductoNegocio;
import com.zegel.servicerestproduct.negocio.VentaNegocio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/api")
public class serviceREST {
    @Autowired
    private ProductoNegocio productoNegocio;
    private VentaNegocio ventaNegocio;

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

    @GetMapping("/producto/mayorprecio")
    public Producto obtenerProductoMayorPrecio(){
        return productoNegocio.obtenerProductoMayorPrecio();
    }


    @GetMapping("/productos/preciomayorque")
    public List<Producto> obtenerProductoConPrecioMayorQue(@RequestParam("precioMinimo") Double precioMinimo){
        return productoNegocio.obtenerProductoConPrecioMayorQue(precioMinimo);
    }

 // Ventas


    @PostMapping("/venta")
    public Venta grabarVenta(@RequestBody Venta venta) {
        return ventaNegocio.grabar(venta);
    }

    @GetMapping("ventas")
    public List<Venta> obtenerVentas() {
        try {
            return ventaNegocio.obtenerVentas();
        }
        catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible obtener los datos");
        }
    }

    @PutMapping("/actualizarVenta")
    public Venta actualizarVentas(@RequestBody Venta venta){
        try{
            return ventaNegocio.actualizar(venta);
        }
        catch (Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No es posible actualizar");
        }
    }

    @DeleteMapping("/venta/{nroVenta}")
    public Venta borrarVenta(@PathVariable(value = "nroVenta") Long nroVenta){
        return ventaNegocio.borrarVenta(nroVenta);
    }
}
