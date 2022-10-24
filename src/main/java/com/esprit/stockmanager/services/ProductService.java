package com.esprit.stockmanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.stockmanager.entities.Product;
import com.esprit.stockmanager.repositories.ProductRepo;

@Service
public class ProductService {
	private ProductRepo productRepo;

	@Autowired
	public ProductService(ProductRepo productRepo) {
		this.productRepo = productRepo;
	}
	
	public Product getProductByNumber(String productNumber) {
		return productRepo.getReferenceById(productNumber);
	}
	
	public List<Product> getAllProducts(){
		return productRepo.findAll();
	}
	
	public List<Product> addProducts(List<Product> product) {
		return productRepo.saveAll(product);
	}
	
	public Product updateProduct(Product product) {
		return productRepo.save(product);
	}
}
