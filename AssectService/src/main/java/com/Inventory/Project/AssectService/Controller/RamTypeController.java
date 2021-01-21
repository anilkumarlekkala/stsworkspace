package com.Inventory.Project.AssectService.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.Project.AssectService.Model.RamTypeMaster;
import com.Inventory.Project.AssectService.Service.RamTypeService;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/ram")
public class RamTypeController {

	@Autowired
	private RamTypeService ramtypeservice;

	@PostMapping("/addRamtype")
	public RamTypeMaster addRamType(@RequestBody RamTypeMaster ramtype) {
		System.out.println("save method");
		return ramtypeservice.saveRamType(ramtype);
	}

	@PostMapping("/addRamtypes")
	public List<RamTypeMaster> addRamTypes(@RequestBody List<RamTypeMaster> ramtypes) {
		return ramtypeservice.saveRamType(ramtypes);
	}

	@GetMapping("/getramtypes")
	public List<RamTypeMaster> findAllRamType() {
		return ramtypeservice.getRamtype();
	}

	@GetMapping("/ramtype/{ramtype_id}")
	public RamTypeMaster findRamTypeById(@PathVariable int ramtype_id) {
		return ramtypeservice.getRamTypeById(ramtype_id);
	}

//	@GetMapping("/ramtype/{ramtype_name}")
//	public RamTypeMaster findRamTypeByName(@PathVariable String ramtype_name) {
//		return ramtypeservice.getRamTypeByName(ramtype_name);
//	}

	@PutMapping("/update")
	public RamTypeMaster updateRamType(@RequestBody RamTypeMaster ramtype) {
		return ramtypeservice.updateRamType(ramtype);
	}

	@DeleteMapping("/delete/{ramtype_id}")
	public String deleteRamType(@PathVariable int ramtype_id) {
		return ramtypeservice.deleteRamType(ramtype_id);
	}
}
