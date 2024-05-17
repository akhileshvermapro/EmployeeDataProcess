package com.example.employee.demo.entity.converter;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.example.employee.demo.data.EmployeeDataRequest;
import com.example.employee.demo.data.EmployeeDataResponse;
import com.example.employee.demo.entity.Employee;

@Component
public class EntityConverter {
	
	//converting UserRequestData to Entity
	
	public Employee userDataRequestToEntity(EmployeeDataRequest empDataRequest) {
		
		Employee employeeEntity = new Employee();
		employeeEntity.setEId(empDataRequest.getEId());
		employeeEntity.setFirstName(empDataRequest.getFirstName());
		employeeEntity.setLastName(empDataRequest.getLastName());
		employeeEntity.setAge(empDataRequest.getAge());
		employeeEntity.setAddress(empDataRequest.getAddress());
		employeeEntity.setCity(empDataRequest.getCity());
		employeeEntity.setZipcode(empDataRequest.getZipcode());
		employeeEntity.setPEmail(empDataRequest.getPEmail());
		employeeEntity.setOEmail(empDataRequest.getOEmail());
		employeeEntity.setPhoneNo(empDataRequest.getPhoneNo());
		employeeEntity.setSalary(empDataRequest.getSalary());
		return employeeEntity;
	}
	
	public EmployeeDataResponse entityToDataResponse(Employee employeeEntity) {
		
		EmployeeDataResponse empDataResponse = new EmployeeDataResponse();
		empDataResponse.setEId(employeeEntity.getEId());
		empDataResponse.setFirstName(employeeEntity.getFirstName());
		empDataResponse.setLastName(employeeEntity.getLastName());
		empDataResponse.setAge(employeeEntity.getAge());
		empDataResponse.setAddress(employeeEntity.getAddress());
		empDataResponse.setCity(employeeEntity.getCity());
		empDataResponse.setZipcode(employeeEntity.getZipcode());
		empDataResponse.setPEmail(employeeEntity.getPEmail());
		empDataResponse.setOEmail(employeeEntity.getOEmail());
		empDataResponse.setPhoneNo(employeeEntity.getPhoneNo());
		empDataResponse.setSalary(employeeEntity.getSalary());
		
		return empDataResponse;
	}
	
	public List<EmployeeDataResponse> entityToListDataResponse(List<Employee> employeeEntityList){
		
		List<EmployeeDataResponse> empDataAllList = new ArrayList<>();
		empDataAllList = employeeEntityList.stream().map(empData -> entityToDataResponse(empData)).collect(Collectors.toList());
		return empDataAllList;
	}

}
