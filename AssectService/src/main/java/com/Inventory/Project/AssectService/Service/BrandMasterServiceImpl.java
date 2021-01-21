package com.Inventory.Project.AssectService.Service;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventory.Project.AssectService.Dao.BrandMasterDao;
import com.Inventory.Project.AssectService.Model.BrandMaster;

@Service
public class BrandMasterServiceImpl implements BrandMasterService {
	@Autowired
	private BrandMasterDao brandMasterDao;

	private static Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(BrandMasterServiceImpl.class);

	@Override
	public void insert(BrandMaster brandMaster) {

		LOGGER.debug("entered into insert method in service class");

		brandMasterDao.save(brandMaster);

		LOGGER.debug("exit from insert method in service class");
	}

	@Override
	public BrandMaster update(Integer brand_id, BrandMaster brandMaster) {
		LOGGER.debug("entered into update method in serviceimpl class");
		java.util.Optional<BrandMaster> optional = brandMasterDao.findById(brand_id);
		if (optional.isPresent()) {
			brandMaster.setBrand_id(brand_id);

			brandMasterDao.save(brandMaster);
			return optional.get();

		}
		LOGGER.debug("exit from update method in serviceimpl class");
		return null;

	}

	@Override
	public BrandMaster getById(Integer brand_id) {
		LOGGER.debug("entered into getbyid method in service class");

		java.util.Optional<BrandMaster> optional = brandMasterDao.findById(brand_id);
		if (optional.isPresent()) {
			return optional.get();
		}
		return null;

	}

	@Override
	public BrandMaster deleteById(Integer brand_id) {

		LOGGER.debug("entered into deletebyid in service class");

		java.util.Optional<BrandMaster> optional = brandMasterDao.findById(brand_id);
		if (optional.isPresent()) {

			brandMasterDao.deleteById(brand_id);

			return optional.get();

		}
		LOGGER.debug("exit from deletebyid in service class");

		return null;

	}

	@Override
	public List<BrandMaster> getAll() {

		LOGGER.debug("entered into getall in service class");

		List<BrandMaster> BrandMasterList = brandMasterDao.findAll();

		LOGGER.debug("exit from  getall in service class");

		return BrandMasterList;

	}
}