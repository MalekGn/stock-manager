package com.esprit.stockmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.stockmanager.entities.Operation;

public interface OperationRepo extends JpaRepository<Operation, Long> {

}
