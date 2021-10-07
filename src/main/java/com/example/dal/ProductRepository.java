package com.example.dal;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.example.domain.Product;

public interface ProductRepository  extends ReactiveCrudRepository<Product, Integer> {

	  // additional custom query methods go here
}