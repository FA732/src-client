package com.prueba.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.prueba.entity.Cliente;
public interface IClientRepository extends JpaRepository<Cliente,Long>{

}
