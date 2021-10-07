package com.example.service;

import com.example.domain.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductService {

	int addProduct(Product toBeAdded);

	void removeExisting(int id);

	Mono<Product> findById(int id);

	Flux<Product> findAll();

}