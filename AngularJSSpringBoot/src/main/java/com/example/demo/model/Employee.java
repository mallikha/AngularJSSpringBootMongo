package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Employee{
	
    @Id
	private String empId;
    private String empNo;
    private String empName;
    private String empAddr;
    private String position;
 
    public Employee() {
 
    }
 
    public Employee(EmployeeForm empForm) {
    	super();
       this.empId = empForm.getEmpId();
        this.empNo = empForm.getEmpNo();
        this.empName = empForm.getEmpName();
        this.empAddr = empForm.getEmpAddr();
        this.position = empForm.getPosition();
    }
 
    public Employee(String empId, String empNo, String empName, String position,String empAddr) {
        super();
    	this.empId = empId;
        this.empNo = empNo;
        this.empName = empName;
        this.empAddr = empAddr;
        this.position = position;
    }

	public String getEmpId() {
		return empId;
	}

	public void setEmpId(String empId) {
		this.empId = empId;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmpAddr() {
		return empAddr;
	}

	public void setEmpAddr(String empAddr) {
		this.empAddr = empAddr;
	}
    
    
	
}