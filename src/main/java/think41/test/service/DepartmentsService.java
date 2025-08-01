package think41.test.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import think41.test.dao.DepartmentsDao;
import think41.test.dto.ResponseStructure;
import think41.test.entity.Departments;
import think41.test.exception.IdNotFoundException;
import think41.test.exception.NoRecordsFoundException;

@Service
public class DepartmentsService {

	@Autowired
	private DepartmentsDao departmentsDao;
	
	public ResponseStructure<List<Departments>> getAllDepartments() {
		ResponseStructure<List<Departments>> response = new ResponseStructure<List<Departments>>();
		List<Departments> depts = departmentsDao.getAllDepartments();
		
		if(!depts.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Departments fetched successfully");
			response.setData(depts);
			
			return response;
		}
		throw new NoRecordsFoundException("No departments in the database");		
	}

	public ResponseStructure<Departments> getDepartmentsById(Integer id) {
		ResponseStructure<Departments> response = new ResponseStructure<Departments>();
		Optional<Departments> dept = departmentsDao.getDepartmentsById(id);
		
		if(dept.isPresent()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Departments fetched successfully");
			response.setData(dept.get());
			
			return response;
		}
		throw new IdNotFoundException("No department with given ID : "+id+" is found");	
	}
}
