package think41.test.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import think41.test.dao.DepartmentsDao;
import think41.test.dto.ResponseStructure;
import think41.test.entity.Departments;
import think41.test.exception.NoRecordsFoundException;

@Service
public class DepartmentsService {
	
	@Autowired
	private DepartmentsDao departmentsDao;
	
//	public void initializeDepts() {
//		List<Map<String, Object>> oldProducts= jdbcTemplate.queryForList("SELECT id,department FROM products");
//		
//		for(Map<String, Object> row : oldProducts) {
//			Integer productId = (Integer) row.get("id");
//			String deptName = (String) row.get("department");
//			
//			if(deptName == null) continue;
//			
//			Departments dept = departmentsRepository.findByName(deptName)
//					.orElseGet(()->{
//						Departments newDept = new Departments();
//						newDept.setName(deptName);
//						return departmentsRepository.save(newDept);
//					});
//			Products p = productsDao.getProductById(productId).orElseThrow();
//			p.setDepartments(dept);
//			productsDao.add(p);
//		}
//	}
	
	public ResponseStructure<List<Departments>> getAllDepartments(){
		ResponseStructure<List<Departments>> response = new ResponseStructure<List<Departments>>();
		List<Departments> depts = departmentsDao.getAllDepartments();
		
		if(!depts.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Departments fetched successfully");
			response.setData(depts);
			
			return response;
		}
		throw new NoRecordsFoundException("No departments in the Database");
	}
}
