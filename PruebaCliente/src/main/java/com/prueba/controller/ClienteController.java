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

//This class controller is esencial to make client's request,create a client by the method PostMapping "newClient()" where the object 
//is instanced with new parameters obtained in Postman.
//the method "getallClients" searchs on the repository JPA to find all clients stored on H2.
//method "findClient" search a specific client, only writing a existing id. if is not, throws a exception where the message says "Client Not Found or not Exist!, id:(id written) "
//method "DeleteClient" is similar to findclient with one different function, delete an existing client.
//method "getChangeClient" searchs on the repository JPA an existing client, if client not exists,create a new one. Otherwise modify the value of parameters you give in Postman or Unit test. 
@RestController
public class ClienteController{

	@Autowired
	IClientRepository cli;
	
	@GetMapping("/client")
	 public List<Cliente> getAllClients() {
	    return cli.findAll();
	  }
	  
	  @PostMapping("/client")
	  public Cliente newClient(@RequestBody Cliente newClient) {
	    return cli.save(newClient);
	  }
	 
	  @GetMapping("/client/{id}")
	  public Cliente findClient(@PathVariable Long id) {
	    
	    return cli.findById(id)
	      .orElseThrow(() -> new ErrorMessageClient(id));
	  }

	  @PutMapping("/client/{id}")
	  public Cliente getChangeClient(@RequestBody Cliente newClient, @PathVariable Long id) {
	    
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
	  public void deleteClient(@PathVariable Long id) {
	    cli.deleteById(id);
	  }
}
