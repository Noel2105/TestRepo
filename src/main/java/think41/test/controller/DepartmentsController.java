package think41.test.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import think41.test.dto.ResponseStructure;
import think41.test.entity.Departments;
import think41.test.service.DepartmentsService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentsController {

	@Autowired
	private DepartmentsService departmentsService;
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Departments>>> getAllDepartments() {
		return new ResponseEntity<ResponseStructure<List<Departments>>>(departmentsService.getAllDepartments(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Departments>> getDepartmentsById(@PathVariable int id) {
		return new ResponseEntity<ResponseStructure<Departments>>(departmentsService.getDepartmentsById(id), HttpStatus.OK);
	}
}