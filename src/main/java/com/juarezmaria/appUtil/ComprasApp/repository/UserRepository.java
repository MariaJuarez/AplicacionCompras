package com.juarezmaria.appUtil.ComprasApp.repository;

import com.juarezmaria.appUtil.ComprasApp.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserRepository extends JpaRepository<User,Serializable> {

    public abstract  User findByUsername(String username);
}
