package com.esprit.stockmanager.api;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.esprit.stockmanager.entities.Employee;
import com.esprit.stockmanager.enums.Role;

@Controller
@RequestMapping(path = "api/employee")
public class EmployeeApi {
	
	@GetMapping(path = "/list")
	public String getEmployees(Model model){
		model.addAttribute("employees", Arrays.asList(
				new Employee("12345678", "Malik", "GNICHI", new Date(), Arrays.asList("83535", "84653").stream().collect(Collectors.toSet()), Role.CONTRIBUTOR, null),
				new Employee("12345678", "Malek", "GUENICHI", null, null, Role.ADMIN, null)
				));
		return "listEmployees";
	}
}
