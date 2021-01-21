package com.Inventory.Project.AssectService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "HardDiskCapacity")
public class HardDiskCapacity {
//	public static final String hardDiskCapacityId = null;

	@Id

	@NotNull
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hardDiskCapacity_id")
	private int harddisk_capacity_id;

	@NotNull

	@Column(name = "hardDiskCapacity_type", columnDefinition = "VARCHAR(20)")
	private String harddisk_capacity_type;

	@Column(name = "hardDiskCapacity_status")
	private boolean harddisk_capacity_status;

	public boolean isHarddisk_capacity_status() {
		return harddisk_capacity_status;
	}

	public void setHarddisk_capacity_status(boolean harddisk_capacity_status) {
		this.harddisk_capacity_status = harddisk_capacity_status;
	}

	public int getHarddisk_capacity_id() {
		return harddisk_capacity_id;
	}

	public void setHarddisk_capacity_id(int harddisk_capacity_id) {
		this.harddisk_capacity_id = harddisk_capacity_id;
	}

	public String getHarddisk_capacity_type() {
		return harddisk_capacity_type;
	}

	public void setHarddisk_capacity_type(String harddisk_capacity_type) {
		this.harddisk_capacity_type = harddisk_capacity_type;
	}

}