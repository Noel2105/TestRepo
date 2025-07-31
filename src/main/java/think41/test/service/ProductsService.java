package think41.test.service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import think41.test.dao.ProductsDao;
import think41.test.dto.ResponseStructure;
import think41.test.entity.Products;
import think41.test.exception.IdNotFoundException;
import think41.test.exception.NoRecordsFoundException;

@Service
public class ProductsService {

	@Autowired
	private ProductsDao productsDao;
	
	@Autowired
	private DistributionCentresCSVLoaderService centresCSVLoaderService;
	
	@Autowired
	private ProductsCSVLoaderService productsCSVLoaderService;
	
	public ResponseStructure<List<Products>> getAllProducts() {
		ResponseStructure<List<Products>> response = new ResponseStructure<List<Products>>();
		List<Products> products = productsDao.getAllProducts();
		if(!products.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Products fetched successfully");
			response.setData(products);
			
			return response;
		}
		throw new NoRecordsFoundException("No products found in the database");
	}

	public void loadCsvData() throws IOException {
		centresCSVLoaderService.loadCsvData();
		productsCSVLoaderService.loadCsvData();
	}

	public ResponseStructure<Products> getProductByID(Integer id) {
		ResponseStructure<Products> response = new ResponseStructure<Products>();
		Optional<Products> products = productsDao.getProductById(id);
		if(products.isPresent()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Product fetched successfully");
			response.setData(products.get());
			
			return response;
		}
		throw new IdNotFoundException("No product with given ID :"+id);
	}

	public ResponseStructure<Page<Products>> getPage(int pageNumber, int pageSize) {
		ResponseStructure<Page<Products>> response = new ResponseStructure<Page<Products>>();
		Page<Products> products = productsDao.getPage(pageNumber, pageSize);
		if(!products.isEmpty()) {
			response.setStatusCode(HttpStatus.OK.value());
			response.setMessage("Products fetched successfully");
			response.setData(products);
			
			return response;
		}
		throw new NoRecordsFoundException("No products found in the database");
	}

}
