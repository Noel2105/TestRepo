package think41.test.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import think41.test.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

	@Query(value = "SELECT * FROM products LIMIT 30", nativeQuery = true)
	List<Products> getAll();

}
