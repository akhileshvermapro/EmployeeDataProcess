package com.example.employee.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.employee.demo.data.EmployeeDataRequest;
import com.example.employee.demo.data.EmployeeDataResponse;
import com.example.employee.demo.entity.Employee;
import com.example.employee.demo.entity.converter.EntityConverter;
import com.example.employee.demo.exception.EmployeeNotFoundException;
import com.example.employee.demo.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	@Autowired
	EmployeeRepository empRepository;
	
	@Autowired
	EntityConverter entityConverter;
	
	public List<EmployeeDataResponse> getAllEmpDetails(){
		
		List<Employee> empRepoAllData= empRepository.findAll();
		List<EmployeeDataResponse> empRespAllData = new ArrayList<>();
		empRespAllData = entityConverter.entityToListDataResponse(empRepoAllData);
		return empRespAllData;
	}
	
	public EmployeeDataResponse getEmpDetailsById (EmployeeDataRequest empDataRequest) {
		Employee empDataRequestedById = empRepository.findById(empDataRequest.getEId()).orElse(new Employee());
		Optional<Employee> employeeOptional = Optional.of(empDataRequestedById);
		EmployeeDataResponse empDataToDisplay = entityConverter.entityToDataResponse(empDataRequestedById);
		return empDataToDisplay;
	}
	
	public EmployeeDataResponse setNewEmpDetails (EmployeeDataRequest empDataRequest) {
		Employee  employee = entityConverter.userDataRequestToEntity(empDataRequest);
		Employee savedEmployee = empRepository.save(employee);
		EmployeeDataResponse employeeDataResponse = entityConverter.entityToDataResponse(savedEmployee);
		return employeeDataResponse;
	}
	
	public EmployeeDataResponse updateEmpFullData(EmployeeDataRequest empDataRequest) throws EmployeeNotFoundException {
		
		Employee employee;
		
		//To update first get entity from database based on id
		Optional<Employee> employeeOptional = empRepository.findById(empDataRequest.getEId());
		//employee = employeeOptional.orElseThrow(()->new EmployeeNotFoundException("Employee not found"));

		
		if(employeeOptional.isEmpty()) {
			
			throw new EmployeeNotFoundException("Employee not found");
		}else {
			employee = employeeOptional.get();
		}
		
		//Make changes in employee from empDataRequest and dont change id
		employee.setFirstName(empDataRequest.getFirstName());
		employee.setLastName(empDataRequest.getLastName());
		employee.setAge(empDataRequest.getAge());
		employee.setAddress(empDataRequest.getAddress());
		employee.setCity(empDataRequest.getCity());
		employee.setZipcode(empDataRequest.getZipcode());
		employee.setPEmail(empDataRequest.getPEmail());
		employee.setOEmail(empDataRequest.getOEmail());
		employee.setPhoneNo(empDataRequest.getPhoneNo());
		employee.setSalary(empDataRequest.getSalary());
		
		// now save the updated entity
		
		Employee updatedEmp = empRepository.save(employee);
		
		return entityConverter.entityToDataResponse(updatedEmp);
	}
	
	public EmployeeDataResponse updateEmpDataById(Integer eid, String fieldName, String fieldValue) throws EmployeeNotFoundException {
	
		Employee employee;
		
		//To update first get entity from database based on id
		Optional<Employee> employeeOptional = empRepository.findById(eid);
		//employee = employeeOptional.orElseThrow(()->new EmployeeNotFoundException("Employee not found"));
		
		if(employeeOptional.isEmpty()) {
			
			throw new EmployeeNotFoundException("Employee not found");
		}else {
			employee = employeeOptional.get();
		}
		
		switch(fieldName) {
			case "firstname": employee.setFirstName(fieldValue);
						 break;
						 
			case "lastname": employee.setLastName(fieldValue);
			 			break;
			
			case "address": employee.setAddress(fieldValue);
			 			 	break;
			 
			case "age": employee.setAge(Integer.parseInt(fieldValue));
			 		    break;
			
			case "city": employee.setCity(fieldValue);
						 break;
						 
			case "zipcode": employee.setZipcode(fieldValue);
			 			    break;
			 			   
			case "oemail": employee.setOEmail(fieldValue);
							break;
							
			case "pemail": employee.setPEmail(fieldValue);
			    			break;
			    			
			case "phoneno": employee.setPhoneNo(fieldValue);
			    			break;
			    			
			case "salary": employee.setSalary(Long.parseLong(fieldValue));
			    			break;
		}
		
		Employee updatedEmp = empRepository.save(employee);
		
		return entityConverter.entityToDataResponse(updatedEmp);
	}
	
	public void deleteEmpDataById(Integer eid) {
		empRepository.deleteById(eid);
	}

}
