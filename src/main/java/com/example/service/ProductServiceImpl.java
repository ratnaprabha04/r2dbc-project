package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dal.ProductRepository;
import com.example.domain.Product;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


@Service
public class ProductServiceImpl implements ProductService {
	
	ProductRepository dao; // = new ProductDAOInMemImpl(); //was doing new b4 using DI
	
	@Autowired
	public void setDao(ProductRepository dao) {
		this.dao = dao;
		
	}
	
	@Override
	public int addProduct(Product toBeAdded) {
		if(toBeAdded.getPrice() * toBeAdded.getQoh() >= 10000) {
			Mono<Product> added = dao.save(toBeAdded);
			return added.block().getId();
		}else {
			throw new IllegalArgumentException("Product Value must be GTEQ 10k");
		}
	}
	
	@Override
	public void removeExisting(int id) {
		Product existing = dao.findById(id).block();
		
		if(existing.getPrice() * existing.getQoh() < 100000) {
			dao.deleteById(id);
		}else {
			throw new IllegalStateException("Product worth more than 100k, can't just be deleted!");
		}
	}

	@Override
	public Mono<Product> findById(int id) {
		return dao.findById(id);
	}

	@Override
	public Flux<Product> findAll() {
		return dao.findAll();
	}

	
	
}
