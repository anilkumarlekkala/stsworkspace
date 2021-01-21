package com.Inventory.Project.AssectService.Assect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/Assectservice")
public class AssectController {

	@Autowired
	private AssectService assectservice;

	@PostMapping(value = "/addAssect")
	public ResponseEntity<?> addAssect(@RequestBody AssectModel assectModel) {
		System.out.println("this is controller");
		return assectservice.addAssect(assectModel);

	}

	@GetMapping(value = "/getBrands")
	public ResponseEntity<?> getBrandNames() {
		return assectservice.getBrandNames();
	}

	@GetMapping(value = "/getModels")
	public ResponseEntity<?> getModelNames() {
		return assectservice.getModelNames();
	}

	@GetMapping(value = "/getVendors")
	public ResponseEntity<?> getVendors() {
		return assectservice.getVendors();
	}

	@GetMapping(value = "/getHardDiskType")
	public ResponseEntity<?> getHardDiskType() {
		return assectservice.getHardDiskType();

	}

	@GetMapping(value = "/getHardDiskCapacity")
	public ResponseEntity<?> getHardDiskCapacity() {
		return assectservice.getHardDiskCapacity();
	}

	@GetMapping(value = "/getRamType")
	public ResponseEntity<?> getRamType() {
		return assectservice.getRamType();
	}

	@GetMapping(value = "/getRamCapacity")
	public ResponseEntity<?> getRamCapacity() {
		return assectservice.getRamCapacity();

	}
	@GetMapping(value = "/getAssectType")
	public ResponseEntity<?> getAssectType(){
		return assectservice.getAssectType();
	}
}
