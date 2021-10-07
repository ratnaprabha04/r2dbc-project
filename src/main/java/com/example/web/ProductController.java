package com.example.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.domain.Product;
import com.example.service.ProductService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ProductController {
	
	@Autowired
	ProductService service;
	

	
	@RequestMapping(method = RequestMethod.GET ,value="/products")
	public Flux<Product> getAllProducts(){
		return service.findAll();
	}
	
	@GetMapping("/products/{id}") 
	public Mono<ResponseEntity> getProductById(@PathVariable("id")int id) {
		
		return service.findById(id)
			.map(aProduct -> new ResponseEntity(aProduct, HttpStatus.OK))
			.defaultIfEmpty(new ResponseEntity(HttpStatus.NOT_FOUND));

	}


}
