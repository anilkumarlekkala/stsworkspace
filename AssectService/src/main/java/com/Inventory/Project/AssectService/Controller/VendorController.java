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

import com.Inventory.Project.AssectService.Model.Vendor;
import com.Inventory.Project.AssectService.Service.VendorService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/vendorservice")
public class VendorController {

	private static final Logger logger = LogManager.getLogger(VendorController.class);

	@Autowired
	private VendorService vendorService;

	@PostMapping("/addVendor")
	public ResponseEntity<?> saveVendor(@RequestBody Vendor vendor) {
		if (vendor == null) {
			logger.error("vendor object is null  in post");
			return new ResponseEntity<>("vendor object is null", HttpStatus.UNPROCESSABLE_ENTITY);
		}

		if (vendor.getVendorName() == null || vendor.getVendorName().isEmpty() || vendor.getEmail() == null
				|| vendor.getEmail().isEmpty() || vendor.getGstNumber() == null || vendor.getVendorAgreement() == null
				|| vendor.getContactNumber() == null || vendor.getContactNumber().isEmpty()
				|| vendor.getCityname() == null || vendor.getCityname().isEmpty()) {
			logger.error("feilds of vendor object is null in post ");
			return new ResponseEntity<>("feilds of vendor object are null ", HttpStatus.UNPROCESSABLE_ENTITY);

		}

		vendorService.insertVendor(vendor);

		logger.info("vendor is added or created");
		return new ResponseEntity<>(vendor, HttpStatus.OK);

	}

	@PutMapping("/updateVendot")
	public ResponseEntity<?> upateVendor(@RequestBody Vendor vendor) {
		if (vendor == null) {
			logger.error("vendor object is null  in put");
			return new ResponseEntity<>("vendor object is null", HttpStatus.UNPROCESSABLE_ENTITY);
		}

		if (vendor.getVendorName() == null || vendor.getVendorName().isEmpty() || vendor.getEmail() == null
				|| vendor.getEmail().isEmpty() || vendor.getGstNumber() == null || vendor.getVendorAgreement() == null
				|| vendor.getContactNumber() == null || vendor.getContactNumber().isEmpty()
				|| vendor.getCityname() == null || vendor.getCityname().isEmpty()) {
			logger.error("vendor object is null  in put");
			return new ResponseEntity<>("feilds of vendor object are null ", HttpStatus.UNPROCESSABLE_ENTITY);

		}

		try {
			if (vendorService.getVendorById(vendor.getVendorId()).get() != null) {

				vendorService.upateVendor(vendor);
				logger.info("vendor is updated successfully");
			}
		}

		catch (Exception e) {
			logger.error("no records found with vendor id in put");
			return new ResponseEntity<>("no records found ", HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(vendor, HttpStatus.OK);

	}

	@GetMapping("/getvendors")
	public ResponseEntity<List<Vendor>> getVendorList() {

		List<Vendor> listOfVendors = vendorService.getListOfVendors();

		logger.info("getting list of records" + listOfVendors);

		return new ResponseEntity<>(listOfVendors, HttpStatus.OK);

	}

	@GetMapping("/getByVvendorId/{id}")
	public ResponseEntity<?> getVendorById(@PathVariable("id") Integer id) {

		if (id == null) {

			logger.error("vendor id is null  in getMapping by id");

			return new ResponseEntity<Vendor>(HttpStatus.BAD_REQUEST);
		}
		Vendor vendor = null;

		Optional<Vendor> vendorById = vendorService.getVendorById(id);

		if (vendorById.isPresent()) {
			vendor = vendorById.get();
		} else {

			return new ResponseEntity<>("records not found", HttpStatus.NOT_FOUND);
		}

		/*
		 * if (vendor == null) {
		 * logger.error("no records found with vendor id in getById"); return new
		 * ResponseEntity<Vendor>(HttpStatus.NOT_FOUND);
		 * 
		 * }
		 */
		logger.info("getting vendor based on id" + vendor);
		return new ResponseEntity<>(vendor, HttpStatus.OK);

	}

	@GetMapping("byname/{name}")
	public ResponseEntity<List<Vendor>> getVendorByName(@PathVariable("name") String name) {

		if (name == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		List<Vendor> vendor = vendorService.getVendorByName(name);

		return new ResponseEntity<>(vendor, HttpStatus.OK);

	}

	@GetMapping("bystatus/{status}")
	public ResponseEntity<List<?>> getVendorByName(@PathVariable("status") Boolean status) {

		if (status == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		List<Vendor> list = vendorService.getVendorByStatus(status);

		return new ResponseEntity<>(list, HttpStatus.OK);

	}

	@DeleteMapping("deletevendor/{id}")
	@ResponseBody
	public ResponseEntity<?> deleteVendorById(@PathVariable("id") Integer id) {

		if (id == null) {
			logger.error("vendor id is null  in deletemapping");
			return new ResponseEntity<Vendor>(HttpStatus.BAD_REQUEST);
		}

		try {
			if (vendorService.getVendorById(id).get() != null) {

				vendorService.deleteVendorById(id);
			}

		} catch (Exception e) {
			logger.error("no records found with vendor id in deleteById");
			return new ResponseEntity<>("no records found ", HttpStatus.NOT_FOUND);
		}

		logger.info("deleted vendor successfully" + id);

		return new ResponseEntity<>("deleted succesfully", HttpStatus.OK);

	}

}
