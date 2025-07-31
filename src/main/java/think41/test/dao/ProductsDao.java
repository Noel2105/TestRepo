package think41.test.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Repository;

import think41.test.entity.Products;
import think41.test.repository.ProductsRepository;

@Repository
public class ProductsDao {

	@Autowired
	private ProductsRepository productsRepository;

	public List<Products> getAllProducts() {
		return productsRepository.getAll();
	}

	public Page<Products> getPage(int pageNumber, int pageSize) {
		return productsRepository.findAll(PageRequest.of(pageNumber, pageSize));
	}
	
	public Optional<Products> getProductById(Integer id) {
		return productsRepository.findById(id);
	}

	public Products add(Products p) {
		return productsRepository.save(p);
	}
	
	
}
