package think41.test.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import think41.test.dto.ResponseStructure;
import think41.test.entity.Products;
import think41.test.service.ProductsService;

@RestController
@RequestMapping("/api/products")
public class ProductsController {

	@Autowired
	private ProductsService productsService; 
	
	@Autowired
	
	@PostMapping("/import")
	public String importCsv() throws IOException {
		productsService.loadCsvData();
		return "Data Loaded Successfully";
	}	
	
	@GetMapping
	public ResponseEntity<ResponseStructure<List<Products>>> getAllProducts(){
		return new ResponseEntity<ResponseStructure<List<Products>>>(productsService.getAllProducts(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Products>> getProductById(@PathVariable int id){
		return new ResponseEntity<ResponseStructure<Products>>(productsService.getProductByID(id), HttpStatus.OK);
	}
	
//	@PutMapping
//	public String updateProducts() {
//		departmentsService.initializeDepts();
//		return "Success";
//	}
	
}
