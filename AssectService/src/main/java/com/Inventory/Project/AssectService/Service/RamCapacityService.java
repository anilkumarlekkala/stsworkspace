package com.Inventory.Project.AssectService.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Inventory.Project.AssectService.Dao.RamCapacityDAO;
import com.Inventory.Project.AssectService.Exception.RecordNotFoundException;
import com.Inventory.Project.AssectService.Model.RamCapacity;

@Service
public class RamCapacityService {

	private static final Logger logger = LogManager.getLogger(RamCapacityService.class);

	@Autowired
	private RamCapacityDAO capacityDAO;

	public ResponseEntity<?> saveRamDeatils(RamCapacity master) {

		if (master == null) {
			String message = "Not allowed Null Values";
			logger.info("Null values are not allowed");
			return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
		} else {

			RamCapacity ramMaster = capacityDAO.save(master);
			logger.info("Data Inserted Successfully");
			return new ResponseEntity<>(ramMaster, HttpStatus.OK);
		}
	}

	public List<RamCapacity> getAllRamDetails() {

		List<RamCapacity> ramList = capacityDAO.findAll();
		if (ramList.size() > 0) {
			logger.info("Total RamCapacity Data List");
			return ramList;
		} else {
			logger.error("No Data Found");
			return new ArrayList<RamCapacity>();
		}
	}

	public RamCapacity getRamDetailsById(int id) throws RecordNotFoundException {

		Optional<RamCapacity> ramId = capacityDAO.findById(id);
		if (ramId.isPresent()) {
			logger.info("Getting RamCapacity details By Id");
			return ramId.get();
		} else {
			logger.error("No Data Found");
			throw new RecordNotFoundException("No record exist for given id");
		}

	}

	public RamCapacity updateRamDetailsById(int id, RamCapacity master) throws RecordNotFoundException {
		Optional<RamCapacity> ramId = capacityDAO.findById(id);
		if (ramId.isPresent()) {
			RamCapacity ramMaster = ramId.get();
			// ramMaster.setRamId(master.getRamId());
			ramMaster.setRamType(master.getRamType());
			ramMaster.setRamStatus(master.isRamStatus());
			logger.info("RamCapacity Details are updated successfully");
			ramMaster = capacityDAO.save(ramMaster);
			return ramMaster;
		} else {
			logger.error("No RamCapacity present with this Ram_id : " + id);
			throw new RecordNotFoundException("No record exist for given id");
		}
	}

	public void deleteByRamId(int id) throws RecordNotFoundException {
		Optional<RamCapacity> ramId = capacityDAO.findById(id);
		if (ramId.isPresent()) {
			capacityDAO.deleteById(id);
			logger.info("Object deleted successfully");
		} else {
			logger.error("No data present with the Ram_id : " + id);
			throw new RecordNotFoundException("No record exist for given id");
		}
	}

}
