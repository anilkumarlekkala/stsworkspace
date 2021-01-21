package com.Inventory.Project.AssectService.Controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.Project.AssectService.Model.HardDiskTypeModel;
import com.Inventory.Project.AssectService.Service.HardDiskTypeServiceImpl;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("hardDiskOfType")
public class HardDiskTypeController {

	private static final Logger logger = LogManager.getLogger(HardDiskTypeController.class);

	@Autowired
	private HardDiskTypeServiceImpl hardDiskServiceImpl;

	@PostMapping(value = "/addHardDiskType")
	public ResponseEntity<?> saveHardDiskType(@RequestBody HardDiskTypeModel hardDiskTypeModel) {

		if (hardDiskTypeModel == null) {

			logger.error("HarddiskType Object is null in popst");
			return new ResponseEntity<>("HardDiskType Object is null", HttpStatus.UNPROCESSABLE_ENTITY);

		}

		if (hardDiskTypeModel.getHardDiskType() == null || hardDiskTypeModel.getHardDiskStatus() == null) {

			logger.error("fields of HardDisktype Object are null in post");
			return new ResponseEntity<>("fields of HardDiskType Object are null", HttpStatus.UNPROCESSABLE_ENTITY);
		}

		hardDiskServiceImpl.insertHardDisktTpe(hardDiskTypeModel);

		logger.info("HardDiskType is added or created");
		return new ResponseEntity<>(hardDiskTypeModel, HttpStatus.OK);

	}

	@GetMapping(value = "/getHardDiskType")
	public ResponseEntity<List<HardDiskTypeModel>> getHardDiskTypeList() {

		List<HardDiskTypeModel> listOfHardDiskTypes = hardDiskServiceImpl.getListOfHardDiskTypes();

		if (listOfHardDiskTypes.isEmpty()) {
			logger.error("No records found");
			return new ResponseEntity<>( HttpStatus.NOT_FOUND);
		}
		logger.info("getting list of records" + listOfHardDiskTypes);
		return new ResponseEntity<>(listOfHardDiskTypes, HttpStatus.OK);
	}

	@GetMapping("getHardDiskTypeById/{hardDiskId}")
	public ResponseEntity<?> getHardDiskTypeById(@PathVariable Integer hardDiskId) {

		if (hardDiskId == null) {
			logger.error("HradDiskTypeId is null in getMapping");

			return new ResponseEntity<>("HardDiskTypeId is null", HttpStatus.BAD_REQUEST);

		}

		HardDiskTypeModel hardDiskTypeModel = null;

		Optional<HardDiskTypeModel> hardDiskTypeById = hardDiskServiceImpl.getHardDiskTypeById(hardDiskId);

		if (hardDiskTypeById.isPresent()) {
			hardDiskTypeModel = hardDiskTypeById.get();
		} else {
			return new ResponseEntity<>("records not found", HttpStatus.NOT_FOUND);
		}
		logger.info("getting HarsDiskType based in its Id");
		return new ResponseEntity<>(hardDiskTypeModel, HttpStatus.OK);
	}

	@GetMapping("getHardDiskTypeByType/{hardDiskType}")
	public ResponseEntity<?> getHardDiskTypeByType(@PathVariable String hardDiskType) {

		if (hardDiskType == null) {
			logger.error("HradDiskType is null in getMapping");

			return new ResponseEntity<>("HardDiskType is null", HttpStatus.BAD_REQUEST);

		}

		List<HardDiskTypeModel> hardDiskTypeModel = null;

		hardDiskTypeModel = hardDiskServiceImpl.getHardDiskTypeByType(hardDiskType);
		if (!hardDiskTypeModel.isEmpty()) {
			logger.info("HardDiskType is get by its Type" + hardDiskType);

		}

		else {
			logger.error("no records found with HardDiskType Type" + hardDiskType);
			return new ResponseEntity<>("no records found ", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(hardDiskTypeModel, HttpStatus.OK);

	}

	@DeleteMapping("deleteharddisktype/{hardDiskId}")
	@ResponseBody
	public ResponseEntity<?> deleteharddisktypeById(@PathVariable Integer hardDiskId) {

		if (hardDiskId == null) {
			logger.error("HardDsikTypeId is null in DeleteMapping");
			return new ResponseEntity<>("HardDiskTypeId is null", HttpStatus.BAD_REQUEST);
		}

		try {
			if (hardDiskServiceImpl.getHardDiskTypeById(hardDiskId).get() != null) {
				hardDiskServiceImpl.deleteHardDiskTypeById(hardDiskId);
				logger.info("deleted HardDiskType successfully" + hardDiskId);
			}

		} catch (Exception e) {
			logger.error("no records found with HardDiskType Id");
			return new ResponseEntity<>("no records found ", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>("deleted succesfully", HttpStatus.OK);

	}

	@PutMapping(value = "/updateHardDiskType")
	public ResponseEntity<?> updateHardDiskType(@RequestBody HardDiskTypeModel hardDiskTypeModel) {

		if (hardDiskTypeModel == null) {

			logger.error("HarddiskType Object is null in PutMapping");
			return new ResponseEntity<>("HardDiskType Object is null", HttpStatus.UNPROCESSABLE_ENTITY);

		}

		if (hardDiskTypeModel.getHardDiskId() == null || hardDiskTypeModel.getHardDiskType() == null
				|| hardDiskTypeModel.getHardDiskStatus() == null) {

			logger.error("fields of HardDisktype Object are null in PutMapping");
			return new ResponseEntity<>("fields of HardDiskType Object are null", HttpStatus.UNPROCESSABLE_ENTITY);
		}

			if (hardDiskServiceImpl.getHardDiskTypeById(hardDiskTypeModel.getHardDiskId()).isPresent()) {
				hardDiskServiceImpl.updateHardDiskType(hardDiskTypeModel);
				logger.info("HardDiskType is added or updated");
			}

			else {
			logger.error("no records found with HardDiskType Id" + hardDiskTypeModel.getHardDiskId());
			return new ResponseEntity<>("no records found ", HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(hardDiskTypeModel, HttpStatus.OK);

	}
}

