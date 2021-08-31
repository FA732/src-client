package com.prueba;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prueba.entity.Cliente;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PruebaClienteApplicationTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void ClienteControllerTest() throws URISyntaxException {
		
		final String baseUrl = "http://localhost:"+port+"/client";
        URI uri = new URI(baseUrl);
        
        Cliente client = new Cliente();
        client.setAge(10);
        client.setDoc("document");
        client.setLastname("apellido");
        client.setName("nombre");   
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");      
 
        HttpEntity<Cliente> request = new HttpEntity<Cliente>(client, headers);
         
        ResponseEntity<String> result = this.restTemplate.postForEntity(uri, request, String.class);
		
        System.out.println("Respuesta: "+result);
        
        assertEquals(HttpStatus.OK, result.getStatusCode()); 
        
	}

}
