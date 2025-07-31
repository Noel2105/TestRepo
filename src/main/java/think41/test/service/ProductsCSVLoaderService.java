package think41.test.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import think41.test.entity.Products;
import think41.test.repository.DistributionCentresRepository;
import think41.test.repository.ProductsRepository;

@Service
public class ProductsCSVLoaderService {

	@Autowired
	private ProductsRepository productsRepository;
	
	@Autowired
	private DistributionCentresRepository distributionCentresRepository;
	
	public void loadCsvData() throws IOException {
		InputStream is = getClass().getResourceAsStream("/csv/products.csv");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			String line;
			reader.readLine();
			while((line = reader.readLine()) != null) {
				String [] data = line.split(",");
				Products products = new Products();
				products.setId(Integer.parseInt(data[0]));
				products.setCost(Double.parseDouble(data[1]));
				products.setCategory(data[2]);
				products.setName(data[3]);
				products.setBrand(data[4]);
				products.setRetailPrice(Double.parseDouble(data[5]));				
//				products.setDepartment(data[6]);
				products.setSku(data[7]);
				products.setDistributionCentres((distributionCentresRepository.findById(Integer.parseInt(data[8])).get()));
				
				productsRepository.save(products);
			}
		}
	}
	
	
}
