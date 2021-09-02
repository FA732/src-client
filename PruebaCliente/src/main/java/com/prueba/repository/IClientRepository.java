package com.prueba.repository;
import org.springframework.data.jpa.repository.JpaRepository;

//This class send all the data or values to DB H2.

//The reason of why I'm not using CrudRepository is simple, JpaRepository is a extension more large of crudRepository and is useful 
//in e-commerce sites.

import com.prueba.entity.Cliente;
public interface IClientRepository extends JpaRepository<Cliente,Long>{

}
