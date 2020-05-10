package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.repo.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repo;
	public List<Employee> findAll() {
		return repo.findAll();
	}
	public Employee add(Employee emp) {
		return repo.save(emp);
		
	}
	public Employee update(Employee emp) {
		return repo.update(emp);
	}
	public String delete(String id) {
		return repo.delete(id);
		
	}
	public Employee find(String string) {
		// TODO Auto-generated method stub
		return repo.find(string);
	}

}
