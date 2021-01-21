package com.Inventory.Project.AssectService.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.Inventory.Project.AssectService.Dao.AssetRepositry;
import com.Inventory.Project.AssectService.Model.AssetTypeMasterEx;

@Service
@EnableTransactionManagement
public class AssetServiceImpl implements IAssetService {
	
	private static final Logger logger = LogManager.getLogger(AssetServiceImpl.class);
	
	@Autowired
	private AssetRepositry repo;

	public Integer saveAssetType(AssetTypeMasterEx atx) {
		logger.info("inserting assettype");
		return repo.save(atx).getAsset_id();
	}

	public void updateAssetType(AssetTypeMasterEx atx) {
		logger.info("update assettype");
		repo.save(atx);
	}

	public void deleteAssetType(Integer id) {
		logger.info("deleting assettype by id");
		repo.deleteById(id);
	}

	public Optional<AssetTypeMasterEx> getOneAssetTypeMasterEx(Integer id) {
		logger.info("getting  assettype by id");
		return repo.findById(id);
	}


	public List<AssetTypeMasterEx> getAllAssetTypeMasterExs() {
		logger.info("getting  all assettype");
		return repo.findAll();
	}

	public boolean isPresent(Integer id) {
		logger.info("asset type is present");
		return repo.existsById(id);
	}

}

