package com.example.demo.repo;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Employee;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Repository
public class EmployeeRepository {

	 MongoClient mongoClient;
	 MongoClient getClient() {
		 if(null == mongoClient) {
				mongoClient = new MongoClient("localhost",27017);
			}
		 return mongoClient;
	 }
	public List<Employee> findAll() {
		MongoClient client = getClient();
		MongoDatabase database =client.getDatabase("test");
		MongoCollection<Document> coll = database.getCollection("employee");
		List<Employee> response = new ArrayList<Employee>();
		for(Document doc : coll.find()) {
			Employee e = new Employee(doc.get("_id").toString(), doc.getString("EmpNo"), doc.getString("EmpName"), doc.getString("EmpAddr"),doc.getString("position"));
			response.add(e);
		}
		return response;
	}
	
	public Employee find(String empId) {
		MongoClient client = getClient();
		MongoDatabase database =client.getDatabase("test");
		MongoCollection<Document> coll = database.getCollection("employee");
		for(Document doc : coll.find()) {
			if(empId.equals(doc.get(doc.get("_id").toString()))){
				Employee emp = new Employee(doc.get("_id").toString(), doc.getString("EmpNo"), doc.getString("EmpName"), doc.getString("EmpAddr"),doc.getString("position"));
				return emp;
			}
		}
		return new Employee();
	}
	public Employee save(Employee emp) {
		MongoClient mongoClient =getClient();
		MongoDatabase database= mongoClient.getDatabase("test");
		MongoCollection<Document> employeecollection = database.getCollection("employee");
		Document document1 = new Document();
		document1.append("EmpNo", emp.getEmpNo());
		document1.append("EmpName", emp.getEmpName());
		document1.append("EmpAddr", emp.getEmpAddr());
		document1.append("position", emp.getPosition());
		String respose;
		try {
			employeecollection.insertOne(document1);
			respose ="added";
		}catch(Exception e) {
			respose ="failed";
		}
		return emp;
	}
	public Employee update(Employee emp) {
		MongoClient mongoClient =getClient();
		MongoDatabase database= mongoClient.getDatabase("test");
		MongoCollection<Document> employeecollection = database.getCollection("employee");
		Document document1 = new Document();
		System.out.println("ID::"+emp.getEmpId());
		document1.append("EmpId", emp.getEmpId());
		document1.append("EmpNo", emp.getEmpNo());
		document1.append("EmpName", emp.getEmpName());
		document1.append("EmpAddr", emp.getEmpAddr());
		document1.append("position", emp.getPosition());
		System.out.println("position"+emp.getPosition());
		
		String respose;
		try {
			BasicDBObject filter = new BasicDBObject("_id", new ObjectId(emp.getEmpId().toString()));
			employeecollection.updateOne(filter, new BasicDBObject("", document1));
			respose ="updated";
			System.out.println(respose);
		}catch(Exception e) {
			respose ="failed";
		}
		return emp;
	}
	public String delete(String id) {
		MongoClient mongoClient =getClient();
		MongoDatabase database= mongoClient.getDatabase("test");
		MongoCollection<Document> employeecollection = database.getCollection("employee");
		Document document1 = new Document();
		document1.append("firstname", "malli123");
		document1.append("lastName", "konatham123");
		document1.append("address", "#07-183,141041");
		String respose;
		try {
			BasicDBObject filter = new BasicDBObject("_id", new ObjectId(id));
			employeecollection.deleteOne(filter);
			respose ="deleted";
		}catch(Exception e) {
			respose ="failed";
		}
		return respose;
			
}
}
