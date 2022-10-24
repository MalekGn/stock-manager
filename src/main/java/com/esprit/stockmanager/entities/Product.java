package com.esprit.stockmanager.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product implements Serializable {

	private static final long serialVersionUID = -2408507343449370081L;

	@Id
	@Column(name = "product_number", nullable = false, unique = true, length = 10)
	private String productNumber;

	@Column(name = "product_name", nullable = false, unique = true)
	private String productName;

	@Column(name = "quantity", nullable = false)
	private Long quantity;

	@OneToMany(mappedBy = "product")
	private List<Operation> operations;

	public Product() {
		// constructor from super class
	}

	public Product(String productNumber, String productName, Long quantity) {
		this.productNumber = productNumber;
		this.productName = productName;
		this.quantity = quantity;
	}

	public String getProductNumber() {
		return productNumber;
	}

	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Long getQuantity() {
		return quantity;
	}

	public void setQuantity(Long quantity) {
		this.quantity = quantity;
	}

	public List<Operation> getOperations() {
		if (operations == null) {
			operations = new ArrayList<>();
		}
		return operations;
	}

	public void setOperations(List<Operation> operations) {
		this.operations = operations;
	}

}
