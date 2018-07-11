package com.juarezmaria.appUtil.ComprasApp.dao;

import com.juarezmaria.appUtil.ComprasApp.entity.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface ProductosRepoServiceDao extends JpaRepository<Producto, Integer> {


}
