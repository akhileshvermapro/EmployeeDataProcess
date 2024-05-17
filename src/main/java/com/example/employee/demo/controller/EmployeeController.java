package com.example.employee.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee.demo.data.EmployeeDataRequest;
import com.example.employee.demo.data.EmployeeDataResponse;
import com.example.employee.demo.exception.EmployeeNotFoundException;
import com.example.employee.demo.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeService empService;
	
	//Get all details - GET
	@GetMapping("/emp/getAllDetails")
	public ResponseEntity<List<EmployeeDataResponse>> allEmpData(){
		ResponseEntity<List<EmployeeDataResponse>> allData = ResponseEntity.ok(empService.getAllEmpDetails());
		return allData;
	}
	
	//Get particular details - GET
	@GetMapping("/emp/getDetails/{eid}")
	public ResponseEntity<EmployeeDataResponse> getUserbyId(@PathVariable("eid") EmployeeDataRequest empDataRequest){
		ResponseEntity<EmployeeDataResponse> getDetailsById = ResponseEntity.ok(empService.getEmpDetailsById(empDataRequest));
		return getDetailsById;
	}
	
	//Post new employee data - POST
	@PostMapping("/emp/enterNewEmployeeData")
	public ResponseEntity<EmployeeDataResponse> newEmpData(@RequestBody EmployeeDataRequest empDataRequest){
		ResponseEntity<EmployeeDataResponse> newData = ResponseEntity.ok(empService.setNewEmpDetails(empDataRequest));
		return newData;
	}
	
	//update existing data with whole column data - PUT
	@PutMapping("/emp/updateEmpWholeData")
	public ResponseEntity<EmployeeDataResponse> updateEmpFullData(@RequestBody EmployeeDataRequest empDataRequest) throws EmployeeNotFoundException{
		ResponseEntity<EmployeeDataResponse> updateFullData = ResponseEntity.ok(empService.updateEmpFullData(empDataRequest));
		return updateFullData;
	}
	
	//update particular data using id - PATCH
	@PatchMapping("/emp/updateEmpDataById/{eid}/{fieldName}/{fieldValue}")
	public ResponseEntity<EmployeeDataResponse> updateEmpDataById(@PathVariable("eid")Integer eid, @PathVariable("fieldName")String fieldName, @PathVariable("fieldValue")String fieldValue ) throws EmployeeNotFoundException{
		ResponseEntity<EmployeeDataResponse> updateDataById = ResponseEntity.ok(empService.updateEmpDataById(eid, fieldName, fieldValue));
		return updateDataById;
	}
	
	//delete one entry - DELETE
	@DeleteMapping("/emp/deleteEmpDataById/{eid}")
	public ResponseEntity<String> deleteEmpDataById(@PathVariable("eid") Integer eid){
		empService.deleteEmpDataById(eid);
		return ResponseEntity.ok("Data deleted successfully!");
	}
	

}
