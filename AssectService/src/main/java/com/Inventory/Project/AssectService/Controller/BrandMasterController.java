package com.Inventory.Project.AssectService.Controller;

import java.util.List;

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
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.Project.AssectService.Model.BrandMaster;
import com.Inventory.Project.AssectService.Service.BrandMasterServiceImpl;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("BrandMaster")
public class BrandMasterController {

	@Autowired
	private BrandMasterServiceImpl brandMasterService;

	/*
	 * @Autowired private BrandMasterDao brandMasterDao;
	 */

	private static Logger LOGGER = org.apache.logging.log4j.LogManager.getLogger(BrandMasterServiceImpl.class);

	@PostMapping("save")
	public ResponseEntity<?> insert(@RequestBody BrandMaster brandMaster) {

		LOGGER.debug("entered into insert method in controller");

		if (brandMaster.getBrand_name().isEmpty() || brandMaster.getBrand_name() == null) {
			return new ResponseEntity<>("the field should not be null", HttpStatus.BAD_REQUEST);
		} else {
			brandMasterService.insert(brandMaster);

			LOGGER.debug("exit from  insert method in controller");

			return new ResponseEntity<>("record inserted successfully", HttpStatus.OK);

		}

	}

	@PutMapping("/{brand_id}")
	public ResponseEntity<?> update(@PathVariable Integer brand_id, @RequestBody BrandMaster brandMaster) {
		LOGGER.debug("entered into update method in controller");

		BrandMaster bm = brandMasterService.update(brand_id, brandMaster);

		if (bm != null) {

			return new ResponseEntity<>("updated", HttpStatus.OK);

		} else {

			LOGGER.debug("exit from update method in controller");

			return new ResponseEntity<>("entered id is not found", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/{brand_id}")
	public ResponseEntity<?> getById(@PathVariable Integer brand_id) {

		LOGGER.debug("entered into getbyid method in controller");

		BrandMaster brandmaster = brandMasterService.getById(brand_id);
		if (brandmaster == null) {
			return new ResponseEntity<>("id is not found in db", HttpStatus.BAD_REQUEST);

		} else {

			LOGGER.debug("exit from getbyid method in controller");
			return new ResponseEntity<>(brandmaster, HttpStatus.OK);

		}

	}

	@GetMapping()
	public ResponseEntity<?> getAll() {

		LOGGER.debug("entered into getall method in controller");

		List<BrandMaster> brandmasterlist = brandMasterService.getAll();
		if (brandmasterlist != null) {
			LOGGER.info("getting list of brandmasters" + brandmasterlist);
			return new ResponseEntity<>(brandmasterlist, HttpStatus.OK);

		} else {

			LOGGER.debug("exit from  getall method in controller");

			return new ResponseEntity<>("list is null", HttpStatus.BAD_REQUEST);
		}

	}

	@DeleteMapping("/{brand_id}")
	public ResponseEntity<?> deleteById(@PathVariable Integer brand_id) {

		LOGGER.debug("entered into deletebyid method in controller");

		BrandMaster bm = brandMasterService.deleteById(brand_id);
		if (bm != null) {
			return new ResponseEntity<>("record deleted", HttpStatus.OK);
		} else {

			LOGGER.debug("exit from deletebyid method in controller");

			return new ResponseEntity<>("id is not found", HttpStatus.BAD_REQUEST);
		}

	}
}
