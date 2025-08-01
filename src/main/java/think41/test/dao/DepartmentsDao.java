package think41.test.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import think41.test.entity.Departments;
import think41.test.repository.DepartmentsRepository;

@Repository
public class DepartmentsDao {

	@Autowired
	private DepartmentsRepository departmentsRepository;
	
	public List<Departments> getAllDepartments() {
		return departmentsRepository.findAll();
	}

	public Optional<Departments> getDepartmentsById(Integer id) {
		return departmentsRepository.findById(id);
	}
}
