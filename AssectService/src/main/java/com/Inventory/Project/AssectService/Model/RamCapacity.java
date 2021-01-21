package com.Inventory.Project.AssectService.Model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "RamMaster")
public class RamCapacity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int ramId;
	private String ramType;
	private boolean ramStatus;

	public int getRamId() {
		return ramId;
	}

	public void setRamId(int ramId) {
		this.ramId = ramId;
	}

	public String getRamType() {
		return ramType;
	}

	public void setRamType(String ramType) {
		this.ramType = ramType;
	}

	public boolean isRamStatus() {
		return ramStatus;
	}

	public void setRamStatus(boolean ramStatus) {
		this.ramStatus = ramStatus;
	}
	

}

