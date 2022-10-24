package com.esprit.stockmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.stockmanager.entities.Product;

public interface ProductRepo extends JpaRepository<Product, String> {

}
