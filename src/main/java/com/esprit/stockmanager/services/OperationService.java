package com.esprit.stockmanager.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.stockmanager.entities.Employee;
import com.esprit.stockmanager.entities.Operation;
import com.esprit.stockmanager.entities.Product;
import com.esprit.stockmanager.repositories.OperationRepo;

@Service
public class OperationService {
	private OperationRepo operationRepo;

	@Autowired
	public OperationService(OperationRepo operationRepo) {
		this.operationRepo = operationRepo;
	}
	
	public Operation getOperationById(Long id) {
		return operationRepo.getReferenceById(id);
	}
	
	public List<Operation> getAllOperations(){
		return operationRepo.findAll();
	}
	
	public Operation addOperation(Operation operation) {
		return operationRepo.save(operation);
	}
	
	public Operation updateOperation(Operation operation) {
		return operationRepo.save(operation);
	}
	
	public List<Operation> getOperationsWithinDate(Date startDate, Date endDate) {
		return null;
	}
	
	public List<Operation> getOperationsByEmployee(Employee employee){
		return null;
	}
	
	public List<Operation> getOperationsByProduct(Product product){
		return null;
	}
}
