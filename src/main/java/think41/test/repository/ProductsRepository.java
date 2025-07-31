package think41.test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import think41.test.entity.Products;

public interface ProductsRepository extends JpaRepository<Products, Integer>{

}
