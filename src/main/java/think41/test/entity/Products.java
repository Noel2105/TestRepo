package think41.test.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Products {

	@Id
	private Integer id;
	private Double cost;
	private String category;
	private String name;
	private String brand;
	private Double retailPrice;
	private String department;
	private String sku;
	
	@ManyToOne
	@JoinColumn(name = "distribution_centres_id")
	private DistributionCentres distributionCentres;
	
	@ManyToOne
	@JoinColumn(name = "departments_id")
	private Departments departments;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public Double getRetailPrice() {
		return retailPrice;
	}

	public void setRetailPrice(Double retailPrice) {
		this.retailPrice = retailPrice;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public DistributionCentres getDistributionCentres() {
		return distributionCentres;
	}

	public void setDistributionCentres(DistributionCentres distributionCentres) {
		this.distributionCentres = distributionCentres;
	}

	public Departments getDepartments() {
		return departments;
	}

	public void setDepartments(Departments departments) {
		this.departments = departments;
	}

}
