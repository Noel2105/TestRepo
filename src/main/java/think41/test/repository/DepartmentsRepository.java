package think41.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import think41.test.entity.Departments;

public interface DepartmentsRepository extends JpaRepository<Departments, Integer>{

}
