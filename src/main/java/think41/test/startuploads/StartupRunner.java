package think41.test.startuploads;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import think41.test.service.DistributionCentresCSVLoaderService;
import think41.test.service.ProductsCSVLoaderService;

@Component
public class StartupRunner implements CommandLineRunner{

	@Autowired
	private ProductsCSVLoaderService productsCSVLoaderService;
		
	@Autowired
	private DistributionCentresCSVLoaderService distributionCentresCSVLoaderService;
	
	@Override
	public void run(String... args) throws Exception {
		distributionCentresCSVLoaderService.loadCsvData();
		productsCSVLoaderService.loadCsvData();
		System.out.println("CSV Data Loaded");
	}
}
