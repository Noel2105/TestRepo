package think41.test.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import think41.test.entity.Products;
import think41.test.repository.ProductsRepository;

@Repository
public class ProductsDao {

	@Autowired
	private ProductsRepository productsRepository;

	public List<Products> getAllProducts() {
		return productsRepository.findAll();
	}

	public Optional<Products> getProductById(Integer id) {
		return productsRepository.findById(id);
	}
	
	
}
