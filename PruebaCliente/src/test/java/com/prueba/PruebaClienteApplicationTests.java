package com.prueba;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.hibernate.query.QueryParameter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.prueba.entity.Cliente;
//this class is where you write unit tests
//first write a final parameter where the value will be "localhost: + {number of your port} +URI Method",then create a instance of
//URI to construct a request you will Test,Create a instance of the object and write the values. next make other instance with HttpHeaders
//where your set type of the content and language, example: "json/xml/etc"
//finally generate an HttpEntity where your values will be send to package Controller and write a sentence of "assertEquals" to catch an only Ok Http Status.
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class PruebaClienteApplicationTests {

	@LocalServerPort
	private int port;
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@Test
	void ClientCreateTest() throws URISyntaxException {
		
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
	@Test
	void ClientDeleteTest() throws URISyntaxException {
		int id = 1;
		final String baseUrl = "http://localhost:"+port+"/client/" + id;
        URI uri = new URI(baseUrl);
                
        ResponseEntity<String> result = this.restTemplate.getForEntity(uri, String.class);
		
        System.out.println("Respuesta: "+result);
        
        assertEquals(HttpStatus.OK, result.getStatusCode()); 
	}

	@Test
	void getChangeClientTest() throws URISyntaxException {
		int id=1;
		final String baseUrl = "http://localhost:"+port+"/client/" + id;
        URI uri = new URI(baseUrl);
        
        Cliente client = new Cliente();
        client.setAge(10);
        client.setDoc("National_Id_Card");
        client.setLastname("Valdes");
        client.setName("nombre");   
        
        HttpHeaders headers = new HttpHeaders();
        headers.set("Content-Type", "application/json");    
        
        HttpEntity<Cliente> request = new HttpEntity<Cliente>(client, headers);
         
        ResponseEntity<String> result = this.restTemplate.exchange(uri,HttpMethod.PUT, request, String.class);
		
        System.out.println("Respuesta: "+result);
        
        assertEquals(HttpStatus.OK, result.getStatusCode()); 
        
        
	}
	@Test
	void findClientsTest() throws URISyntaxException {
		final String baseUrl = "http://localhost:"+port+"/client";
        URI uri = new URI(baseUrl);
         
        ResponseEntity<String> result = this.restTemplate.getForEntity(uri, String.class);
		
        System.out.println("Respuesta: "+result);
        
        assertEquals(HttpStatus.OK, result.getStatusCode()); 
       
	}
}
