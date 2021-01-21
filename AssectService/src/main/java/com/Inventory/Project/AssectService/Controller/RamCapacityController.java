package com.Inventory.Project.AssectService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
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

import com.Inventory.Project.AssectService.Exception.RecordNotFoundException;
import com.Inventory.Project.AssectService.Model.RamCapacity;
import com.Inventory.Project.AssectService.Service.RamCapacityService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ramcapacity")
public class RamCapacityController {

	@Autowired
	private RamCapacityService capacityService;

	// Store the RamCapacity Data into DataBase //
	@PostMapping("/savedata")
	public ResponseEntity<?> saveRamDat(@RequestBody RamCapacity ramMaster) {
		return capacityService.saveRamDeatils(ramMaster);

	}

	// Get All RamCapacity Details //
	@GetMapping("/getRamcapacities")
	public ResponseEntity<List<RamCapacity>> getAllRaminfo() {

		List<RamCapacity> list = capacityService.getAllRamDetails();

		return new ResponseEntity<List<RamCapacity>>(list, new HttpHeaders(), HttpStatus.OK);
	}

	// Get RamCapacity details By Id //
	@GetMapping("/{id}")
	public ResponseEntity<RamCapacity> getRamById(@PathVariable("id") int id) throws RecordNotFoundException {

		RamCapacity ramMaster = capacityService.getRamDetailsById(id);
		return new ResponseEntity<RamCapacity>(ramMaster, new HttpHeaders(), HttpStatus.OK);
	}

	// Updating the RamCapacity ById //
	@PutMapping("/update/{id}")
	public ResponseEntity<RamCapacity> createOrUpdateRamDetailsById(@PathVariable("id") int id,
			@RequestBody RamCapacity master) throws RecordNotFoundException {
		RamCapacity ramMaster = capacityService.updateRamDetailsById(id, master);
		return new ResponseEntity<RamCapacity>(ramMaster, new HttpHeaders(), HttpStatus.OK);
	}

	// Deleting the RamCapacity By Id //
	@DeleteMapping("/{id}")
	public ResponseEntity<RamCapacity> deleteRamDetailsById(@PathVariable("id") int id) throws RecordNotFoundException {
		capacityService.deleteByRamId(id);
		return new ResponseEntity<RamCapacity>(new HttpHeaders(), HttpStatus.OK);
	}

}

