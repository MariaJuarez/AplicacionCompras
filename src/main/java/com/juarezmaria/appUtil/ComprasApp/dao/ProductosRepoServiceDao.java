package com.juarezmaria.appUtil.ComprasApp.dao;

import com.juarezmaria.appUtil.ComprasApp.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductosRepoServiceDao extends JpaRepository<Producto, Integer> {
    public List<Producto> findByNombreProducto(String nombre);
    public List<Producto> findByFechaCompletaAgoteProducto(String fechacompra);

}
