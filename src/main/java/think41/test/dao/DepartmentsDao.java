package think41.test.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import think41.test.entity.Departments;
import think41.test.repository.DepartmentsRepository;

@Repository
public class DepartmentsDao {

	@Autowired
	private DepartmentsRepository departmentsRepository;
	
	public Departments addDepartment(Departments departments) {
		return departmentsRepository.save(departments);
		
	}
}
