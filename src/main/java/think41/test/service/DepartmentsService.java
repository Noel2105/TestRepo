package think41.test.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import think41.test.dao.DepartmentsDao;
import think41.test.dao.ProductsDao;
import think41.test.entity.Departments;
import think41.test.entity.Products;
import think41.test.repository.DepartmentsRepository;

@Service
public class DepartmentsService {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	@Autowired
	private DepartmentsRepository departmentsRepository;
	
	@Autowired
	private ProductsDao productsDao;
	
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
}
