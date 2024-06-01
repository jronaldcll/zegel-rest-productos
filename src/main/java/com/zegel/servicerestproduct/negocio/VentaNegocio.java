package com.zegel.servicerestproduct.negocio;

import com.zegel.servicerestproduct.entidades.Venta;
import com.zegel.servicerestproduct.repositorio.VentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class VentaNegocio {
    @Autowired
    private VentaRepositorio ventaRepositorio;

    @Transactional
    public Venta grabar(Venta venta) {
        return ventaRepositorio.save(venta);
    }

    @Transactional(readOnly = true)
    public List<Venta> obtenerVentas() {
        return (List<Venta>) ventaRepositorio.findAll();
    }

    @Transactional
    public Venta actualizar(Venta venta){
        Venta p = ventaRepositorio.findById(venta.getNroVenta()).get();
        if(p!= null){
            return ventaRepositorio.save(venta);
        } else {
            return null;
        }
    }

    @Transactional
    public Venta borrarVenta(Long nroVenta){
        Venta venta = ventaRepositorio.findById(nroVenta).get();

        if(venta!=null){
            ventaRepositorio.delete(venta);
        }else {
            return null;
        }
        return venta;
    }
}
