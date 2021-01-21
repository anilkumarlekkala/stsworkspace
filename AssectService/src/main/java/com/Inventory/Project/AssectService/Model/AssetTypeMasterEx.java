package com.Inventory.Project.AssectService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "AssetType1")
public class AssetTypeMasterEx {
	@Column(name = "assettype")
	private String asset_type;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "assetid")
	private Integer asset_id;

	@Column(name = "assetstatus")
	private boolean asset_status;

	public AssetTypeMasterEx() {
		super();
	}

	public AssetTypeMasterEx(String asset_type, Integer asset_id, boolean asset_status) {
		super();
		this.asset_type = asset_type;
		this.asset_id = asset_id;
		this.asset_status = asset_status;
	}

	public String getAsset_type() {
		return asset_type;
	}

	public void setAsset_type(String asset_type) {
		this.asset_type = asset_type;
	}

	public Integer getAsset_id() {
		return asset_id;
	}

	public void setAsset_id(Integer asset_id) {
		this.asset_id = asset_id;
	}

	public boolean isAsset_status() {
		return asset_status;
	}

	public void setAsset_status(boolean asset_status) {
		this.asset_status = asset_status;
	}

	@Override
	public String toString() {
		return "AssetTypeMasterEx [asset_type=" + asset_type + ", asset_id=" + asset_id + ", asset_status="
				+ asset_status + "]";
	}

}
