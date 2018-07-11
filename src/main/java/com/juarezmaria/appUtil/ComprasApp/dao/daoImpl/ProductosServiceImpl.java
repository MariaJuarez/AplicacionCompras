package com.juarezmaria.appUtil.ComprasApp.dao.daoImpl;

import com.juarezmaria.appUtil.ComprasApp.entity.Producto;
import com.juarezmaria.appUtil.ComprasApp.dao.ProductosRepoServiceDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class ProductosServiceImpl {

    @Autowired
    private ProductosRepoServiceDao productosRepoServiceDao;

    public List<Producto> list() {
        return productosRepoServiceDao.findAll();
    }

    public void agregarProducto(Producto producto){
        productosRepoServiceDao.save(producto);
    }

    public boolean editarProducto(Integer productoId, Producto productoEditado){
        if (productosRepoServiceDao.findOne(productoId)==null){
            return false;
        }
        productoEditado.setId(productoId);
        productosRepoServiceDao.save(productoEditado);
        return true;
    }

    public boolean eliminarEmpleado(Integer productoId, Producto productoEliminar){
        if(productosRepoServiceDao.findOne(productoId)==null){
            return false;
        }
        productosRepoServiceDao.delete(productoId);
        return true;
    }
}
