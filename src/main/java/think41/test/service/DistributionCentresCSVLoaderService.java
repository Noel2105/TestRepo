package think41.test.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import think41.test.entity.DistributionCentres;
import think41.test.repository.DistributionCentresRepository;

@Service
public class DistributionCentresCSVLoaderService {
	
	@Autowired
	private DistributionCentresRepository distributionCentresRepository;
	
	public void loadCsvData() throws IOException {
		InputStream is = getClass().getResourceAsStream("/csv/distribution_centers.csv");
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(is))) {
			String line;
			reader.readLine();
			while((line = reader.readLine()) != null) {
				String [] data = line.split(",");
				DistributionCentres distributionCentres = new DistributionCentres();
				distributionCentres.setId(Integer.parseInt(data[0]));
				distributionCentres.setName(data[1]);
				distributionCentres.setLattitude(Double.parseDouble(data[2]));
				distributionCentres.setLongitude(Double.parseDouble(data[2]));
				
				distributionCentresRepository.save(distributionCentres);				
			}
		}
	}
}
