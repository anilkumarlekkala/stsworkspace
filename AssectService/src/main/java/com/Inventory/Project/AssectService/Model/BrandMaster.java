package com.Inventory.Project.AssectService.Model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "brandmaster")
public class BrandMaster {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer brand_id;
	private String brand_name;
	private Boolean brand_status;

	public Integer getBrand_id() {
		return brand_id;
	}

	public void setBrand_id(Integer brand_id) {
		this.brand_id = brand_id;
	}

	public String getBrand_name() {
		return brand_name;
	}

	public void setBrand_name(String brand_name) {
		this.brand_name = brand_name;
	}

	public Boolean getBrand_status() {
		return brand_status;
	}

	public void setBrand_status(Boolean brand_status) {
		this.brand_status = brand_status;
	}

	public BrandMaster(Integer brand_id, String brand_name, Boolean brand_status) {
		super();
		this.brand_id = brand_id;
		this.brand_name = brand_name;
		this.brand_status = brand_status;

	}

	@Override
	public String toString() {
		return "BrandMaster [brand_id=" + brand_id + ", brand_name=" + brand_name + ", brand_status=" + brand_status
				+ "]";
	}

	public BrandMaster() {
		super();
		// TODO Auto-generated constructor stub
	}

}

