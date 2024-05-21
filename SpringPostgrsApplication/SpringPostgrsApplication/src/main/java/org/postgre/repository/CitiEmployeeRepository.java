package org.postgre.repository;

import java.util.List;

import org.postgre.model.CitiEmployee;
import org.springframework.stereotype.Repository;

@Repository
public class CitiEmployeeRepository extends JpaRepository <CitiEmployee, Long> {

	public List<CitiEmployee> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public CitiEmployee save(CitiEmployee employee) {
		// TODO Auto-generated method stub
		return null;
	}

	public CitiEmployee findById(Long employeeId) {
		// TODO Auto-generated method stub
		return null;
	}

	public void delete(CitiEmployee employee) {
		// TODO Auto-generated method stub
		
	}

}
