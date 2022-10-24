package com.esprit.stockmanager.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.stockmanager.entities.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, String> {

}
