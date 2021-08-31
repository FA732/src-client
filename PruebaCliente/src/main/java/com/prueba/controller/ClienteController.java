package com.prueba.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.prueba.entity.Cliente;
import com.prueba.exceptions.ErrorMessageClient;
import com.prueba.repository.IClientRepository;


@RestController
public class ClienteController{

	@Autowired
	IClientRepository cli;
	
	@GetMapping("/client")
	  List<Cliente> all() {
	    return cli.findAll();
	  }
	  
	  @PostMapping("/client")
	  Cliente newClient(@RequestBody Cliente newClient) {
	    return cli.save(newClient);
	  }
	 
	  @GetMapping("/client/{id}")
	  Cliente findClient(@PathVariable Long id) {
	    
	    return cli.findById(id)
	      .orElseThrow(() -> new ErrorMessageClient(id));
	  }

	  @PutMapping("/client/{id}")
	  Cliente ModifyClient(@RequestBody Cliente newClient, @PathVariable Long id) {
	    
	    return cli.findById(id)
	      .map(cliente -> {
	        cliente.setName(newClient.getName());
	        cliente.setLastname(newClient.getLastname());
	        cliente.setAge(newClient.getAge());
	        cliente.setDoc(newClient.getDoc());
	        return cli.save(cliente);
	      })
	      .orElseGet(() -> {
	    	  newClient.setId(id);
	        return cli.save(newClient);
	      });
	  }

	  @DeleteMapping("/client/{id}")
	  void deleteEmployee(@PathVariable Long id) {
	    cli.deleteById(id);
	  }
}
