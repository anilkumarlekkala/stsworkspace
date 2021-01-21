package com.Inventory.Project.AssectService.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventory.Project.AssectService.Dao.HardDiskTypeDao;
import com.Inventory.Project.AssectService.Model.HardDiskTypeModel;

@Service
@Transactional
public class HardDiskTypeServiceImpl implements HardDiskTypeService {

	private static final Logger logger = LogManager.getLogger(HardDiskTypeModel.class);
	@Autowired
	private HardDiskTypeDao hardDiskTypeDao;

	@Override
	public void insertHardDisktTpe(HardDiskTypeModel hardDiskTypeModel) {

		logger.info("inserting HardDiskType");
		hardDiskTypeDao.save(hardDiskTypeModel);

	}

	@Override
	public List<HardDiskTypeModel> getListOfHardDiskTypes() {
		logger.info("get all HardDiskTypes");
		List<HardDiskTypeModel> findAll = hardDiskTypeDao.findAll();
		return findAll;
	}

	@Override
	public Optional<HardDiskTypeModel> getHardDiskTypeById(Integer hardDiskId) {
		logger.info("getting hardDistType by id");
		Optional<HardDiskTypeModel> optional = hardDiskTypeDao.findById(hardDiskId);
		return optional;
	}

	@Override
	public List<HardDiskTypeModel> getHardDiskTypeByType(String hardDiskType) {
		logger.info("getting HarddiskType by its type");

		List<HardDiskTypeModel> hardDiskTypeModel = hardDiskTypeDao.findByHardDiskType(hardDiskType);

		return hardDiskTypeModel;
	}

	@Override
	public void deleteHardDiskTypeById(Integer hardDiskId) {

		logger.info("deleting HarddiskType by its Id");

		hardDiskTypeDao.deleteById(hardDiskId);
	}

	@Override
	public void updateHardDiskType(HardDiskTypeModel harddiskTypeModel) {

		logger.info("updating HardDiskType");
		hardDiskTypeDao.save(harddiskTypeModel);

	}

}
