package com.Inventory.Project.AssectService.Service;

import java.util.List;

import com.Inventory.Project.AssectService.Model.BrandMaster;

public interface BrandMasterService {

	public void insert(BrandMaster brandMaster);

	public BrandMaster update(Integer brand_id, BrandMaster brandMaster);

	public BrandMaster getById(Integer brand_id);

	public BrandMaster deleteById(Integer brand_id);

	public List<BrandMaster> getAll();

}