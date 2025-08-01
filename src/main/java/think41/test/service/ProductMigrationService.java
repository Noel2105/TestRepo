package think41.test.service;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import think41.test.entity.Departments;
import think41.test.entity.Products;
import think41.test.repository.DepartmentsRepository;
import think41.test.repository.ProductsRepository;

@Service
public class ProductMigrationService {

    @Autowired
    private ProductsRepository productRepository;

    @Autowired
    private DepartmentsRepository departmentsRepository;

    @Transactional
    public void migrateDepartmentsToForeignKey() {
        // Step 1: Get distinct department names
        List<String> deptNames = productRepository.findDistinctDepartmentNames();

        // Step 2: Save all unique departments
        List<Departments> departments = deptNames.stream()
            .map(name -> {
                Departments d = new Departments();
                d.setName(name);
                return d;
            })
            .toList();
        departmentsRepository.saveAll(departments);

        // Step 3: Map dept name to Department entity
        Map<String, Departments> nameToDeptMap = departmentsRepository.findAll().stream()
            .collect(Collectors.toMap(Departments::getName, Function.identity()));

        // Step 4: Update products in pages
        int page = 0, pageSize = 1000;
        Page<Products> productPage;
        do {
            productPage = productRepository.findAll(PageRequest.of(page++, pageSize));
            for (Products p : productPage.getContent()) {
                Departments dept = nameToDeptMap.get(p.getDepartment());
                if (dept != null) {
                    p.setDepartments(dept);
                }
            }
            productRepository.saveAll(productPage.getContent());
        } while (productPage.hasNext());
    }
}
