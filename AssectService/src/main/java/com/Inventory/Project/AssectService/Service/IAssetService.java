package com.Inventory.Project.AssectService.Service;

import java.util.List;
import java.util.Optional;

import com.Inventory.Project.AssectService.Model.AssetTypeMasterEx;

public interface IAssetService {
	public Integer saveAssetType(AssetTypeMasterEx atx);

	public void updateAssetType(AssetTypeMasterEx atx);

	public void deleteAssetType(Integer id);

	public Optional<AssetTypeMasterEx> getOneAssetTypeMasterEx(Integer id);

	public List<AssetTypeMasterEx> getAllAssetTypeMasterExs();

	public boolean isPresent(Integer id);
}
