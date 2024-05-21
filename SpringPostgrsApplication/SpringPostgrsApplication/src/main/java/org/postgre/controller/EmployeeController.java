package org.postgre.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.postgre.model.CitiEmployee;
import org.postgre.repository.CitiEmployeeRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	private CitiEmployeeRepository employeeRepository;
	
	@GetMapping("/employees")
	public List<CitiEmployee> getAllEmployees() {
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<CitiEmployee> getEmployeeById(@PathVariable(value = "id") Long employeeId)
			throws Exception {
		CitiEmployee employee = employeeRepository.findById(employeeId);
				
		return ResponseEntity.ok().body(employee);
	}
	
	@PostMapping("/employees")
	public CitiEmployee createEmployee(@Valid @RequestBody CitiEmployee employee) {
		return employeeRepository.save(employee);
	}
	
	@PutMapping("/employees/{id}")
	public ResponseEntity<CitiEmployee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Valid @RequestBody CitiEmployee employeeDetails) throws Exception {
		CitiEmployee employee = employeeRepository.findById(employeeId);
				

		employee.setEmailId(employeeDetails.getEmailId());
		employee.setLastName(employeeDetails.getLastName());
		employee.setFirstName(employeeDetails.getFirstName());
		final CitiEmployee updatedEmployee = employeeRepository.save(employee);
		return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee(@PathVariable(value = "id") Long employeeId)
			throws Exception {
		CitiEmployee employee = employeeRepository.findById(employeeId);
				

		employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return response;
	}

}
