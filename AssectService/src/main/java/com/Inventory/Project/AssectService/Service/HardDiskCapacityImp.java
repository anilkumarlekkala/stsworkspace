package com.Inventory.Project.AssectService.Service;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.Inventory.Project.AssectService.Dao.HardDiskCapacityDao;
import com.Inventory.Project.AssectService.Model.HardDiskCapacity;

@Component
public class HardDiskCapacityImp implements HardDiskCapacityService{
	
    private static final Logger logger = LogManager.getLogger(HardDiskCapacityImp.class);


	@Autowired
	HardDiskCapacityDao hardDiskCapacityDao;
	
	@Override
	public void saveHardDiskCapacity(HardDiskCapacity hardDiskCapacity) {
			
		logger.info("Inserting the HardDiskCapacity Data");
		 hardDiskCapacityDao.save(hardDiskCapacity);

		}
	
	
	@Override
	public List<HardDiskCapacity> getAllHardDiskCapacityList() {
		// TODO Auto-generated method stub
		logger.info("getting all the HardDiskCapacity records");
		List<HardDiskCapacity> getAllRecords= hardDiskCapacityDao.findAll();
		return getAllRecords;
	}

	public Optional<HardDiskCapacity> getById(int harddisk_capacity_id)
	{ 
		logger.info("getting HardDiskCapacity record by Id");
		Optional<HardDiskCapacity> hardDiskCapacityById = hardDiskCapacityDao.findById(harddisk_capacity_id);
		
			return hardDiskCapacityById;

	}

	public void delete(int harddisk_capacity_id) {
		
		logger.info("Deleting HardDiskCapacity By Id");
		hardDiskCapacityDao.deleteById(harddisk_capacity_id);
		
	}
		
		
	public void update(HardDiskCapacity hardDiskCapacity) {

		 logger.info("hardDiskcapacity is updated");
		 hardDiskCapacityDao.save(hardDiskCapacity);
		 

    }


	


//	@Override
//	public List<HardDiskCapacity> getByType(String harddisk_capacity_type) {
//		// TODO Auto-generated method stub
//		logger.info("getting hardDiskCapacity by type");
//		//List<HardDiskCapacity> hardDiskBytype = HardDiskCapacityDao.findByHardDiskType(harddisk_capacity_type)
//		List<HardDiskCapacity> hardDiskBytype = hardDiskCapacityDao.findByHardDiskType(harddisk_capacity_type);
//		return hardDiskBytype;
//		
	//}


	}
