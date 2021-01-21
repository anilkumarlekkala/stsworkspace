package com.Inventory.Project.AssectService.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RamTypeMaster")
public class RamTypeMaster {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int ramtype_id;
	private String ramtype_name;
	private boolean ramtype_status;
	
	

	public int getRamtype_id() {
		return ramtype_id;
	}

	public void setRamtype_id(int ramtype_id) {
		this.ramtype_id = ramtype_id;
	}

	public String getRamtype_name() {
		return ramtype_name;
	}

	public void setRamtype_name(String ramtype_name) {
		this.ramtype_name = ramtype_name;
	}

	public boolean isRamtype_status() {
		return ramtype_status;
	}

	public void setRamtype_status(boolean ramtype_status) {
		this.ramtype_status = ramtype_status;
	}

}
