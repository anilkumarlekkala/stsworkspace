package com.Inventory.Project.AssectService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "HardDiskTypeMaster")
public class HardDiskTypeModel {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "hard_id")
	private Integer hardDiskId;
	@Column(name = "harddisk_type", columnDefinition = "VARCHAR(50)")
	private String hardDiskType;
	@Column(name = "harddisk_status")
	private Boolean hardDiskStatus;

	public Integer getHardDiskId() {
		return hardDiskId;
	}

	public void setHardDiskId(Integer hardDiskId) {
		this.hardDiskId = hardDiskId;
	}

	public String getHardDiskType() {
		return hardDiskType;
	}

	public void setHardDiskType(String hardDiskType) {
		this.hardDiskType = hardDiskType;
	}

	public Boolean getHardDiskStatus() {
		return hardDiskStatus;
	}

	public void setHardDiskStatus(Boolean hardDiskStatus) {
		this.hardDiskStatus = hardDiskStatus;
	}

}
