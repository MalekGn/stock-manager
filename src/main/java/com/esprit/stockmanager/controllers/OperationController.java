package com.esprit.stockmanager.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.stockmanager.entities.Operation;
import com.esprit.stockmanager.services.OperationService;

@RestController
@RequestMapping(path = "operation")
public class OperationController {
	
	private OperationService operationService;
	
	@Autowired
	public OperationController(OperationService operationService) {
		this.operationService = operationService;
	}
	
	@GetMapping(params = "/filter/list")
	public ResponseEntity<List<Operation>> listOperationsByDate(@RequestParam(name = "startDate") Date startDate, @RequestParam(name = "endDate") Date endDate){
		List<Operation> operations = operationService.getOperationsWithinDate(startDate, endDate);
		
		return new ResponseEntity<>(operations, HttpStatus.OK);
	}
	
	@GetMapping(path = "/list/all")
	public ResponseEntity<List<Operation>> listAllOperations(){
		List<Operation> operations = operationService.getAllOperations();
		
		return new ResponseEntity<>(operations, HttpStatus.OK);
	}
	
	@PostMapping(path = "/create")
	public ResponseEntity<Operation> createOperation(@RequestParam Operation operation){
		operation = operationService.addOperation(operation);
		
		return new ResponseEntity<>(operation, HttpStatus.CREATED);
	}

	@PostMapping(path = "/update")
	public ResponseEntity<Operation> updateOperation(@RequestParam Operation operation){
		operation = operationService.updateOperation(operation);
		
		return new ResponseEntity<>(operation, HttpStatus.OK);
	}

}
