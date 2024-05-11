package com.zegel.servicerestproduct.repositorio;

import com.zegel.servicerestproduct.entidades.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepositorio extends CrudRepository<Producto, Long> {
}
