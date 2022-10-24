package com.esprit.stockmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.stockmanager.entities.Product;
import com.esprit.stockmanager.services.ProductService;

@RestController
@RequestMapping(path = "product")
public class ProductController {

	private ProductService productService;

	@Autowired
	public ProductController(ProductService productService) {
		this.productService = productService;
	}

	@GetMapping(path = "/find/number")
	public ResponseEntity<Product> getProductByNumber(@RequestParam(name = "productNumber") String productNumber) {
		Product product = productService.getProductByNumber(productNumber);

		return new ResponseEntity<>(product, HttpStatus.OK);
	}

	@GetMapping(path = "/list/all")
	public ResponseEntity<List<Product>> listProducts() {
		List<Product> products = productService.getAllProducts();

		return new ResponseEntity<>(products, HttpStatus.OK);
	}

	@PostMapping(path = "/create")
	public ResponseEntity<List<Product>> createProducts(@RequestBody List<Product> products) {
		products = productService.addProducts(products);

		return new ResponseEntity<>(products, HttpStatus.CREATED);
	}

	@PutMapping(path = "/update")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product) {
		product = productService.updateProduct(product);

		return new ResponseEntity<>(product, HttpStatus.OK);
	}
}
