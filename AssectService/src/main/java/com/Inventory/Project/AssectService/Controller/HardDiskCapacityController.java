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
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.Project.AssectService.Model.HardDiskCapacity;
import com.Inventory.Project.AssectService.Service.HardDiskCapacityImp;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hardDiskCapacity")
public class HardDiskCapacityController {
	
	@Autowired
	private HardDiskCapacityImp hardDiskCapacityService;
	
    private static final Logger logger = LogManager.getLogger(HardDiskCapacityController.class);

	
	@PostMapping("/addHardDiskCapacity")
	public  ResponseEntity<?> saveHardDiskCapacity( @RequestBody HardDiskCapacity hardDiskCapacity)
	{
//		if(hardDiskCapacity == null)
//		{
//			logger.info("HardDiskCapacity Object given null values");
//			return new ResponseEntity<>("HardDiskCapacity Object is null",HttpStatus.UNPROCESSABLE_ENTITY);
//		}
	
		
		if(hardDiskCapacity.getHarddisk_capacity_type() == null)
		{
			logger.info("HardDiskCapacity Fields are null");
			return new ResponseEntity<>("HardDiskCapacity Fields are null",HttpStatus.UNPROCESSABLE_ENTITY);
		}
			
		hardDiskCapacityService.saveHardDiskCapacity(hardDiskCapacity);
		logger.info("HardDiskCapacity data inserted");
		return new ResponseEntity<>(hardDiskCapacity,HttpStatus.OK);
		}
	
	

	@GetMapping("/getAllHardDiskCapacities")
	public ResponseEntity<List<HardDiskCapacity>>getAllHardDiskCapacity()
	{
		List<HardDiskCapacity> hardDiskCapacities = hardDiskCapacityService.getAllHardDiskCapacityList();
		if(hardDiskCapacities.isEmpty())
		{
			logger.error("HardDiskCapacity list is not Found");
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
			logger.info("getting all the hardDiskCapacity list" +hardDiskCapacities);
			return new ResponseEntity<>(hardDiskCapacities,HttpStatus.OK);
	}
	
	@GetMapping("/hardDiskcapacityById/{harddisk_capacity_id}")
	public ResponseEntity<?> getById(@PathVariable(required = true) Integer harddisk_capacity_id)
	{
		if(harddisk_capacity_id==null)
		{
			logger.error("HardDiskCappacity Id Is null");
			return new ResponseEntity<>("HardDiskCappacity Id is nulls",HttpStatus.BAD_REQUEST);
		}
		HardDiskCapacity hardDiskCapacity = null;
		Optional<HardDiskCapacity> hardDiskCapacityId = hardDiskCapacityService.getById(harddisk_capacity_id);
		if(hardDiskCapacityId.isPresent())
		{
			hardDiskCapacity = hardDiskCapacityId.get();
		}else
		{
			return new ResponseEntity<>("Record not found",HttpStatus.NOT_FOUND);
		}
			logger.info("Gettting records Based on hardDiskCapacity id");
			return new ResponseEntity<>(hardDiskCapacity,HttpStatus.OK);
 //hardDiskCapacityService.getById(harddisk_capacity_id);
		
	}
	
//	@GetMapping("/getHardDiskType/{harddisk_capacity_type}")
//	public ResponseEntity<?> getByType(@PathVariable(required = true) String harddisk_capacity_type)
//	{
//		
//		if(harddisk_capacity_type == null)
//		{
//			logger.error("HarddiskCapacity type is null");
//			return new ResponseEntity<>("HarddiskCapacity type is null",HttpStatus.BAD_REQUEST);
//		}
//		List<HardDiskCapacity>hardDiskCapacity = null;
//		
//		HardDiskCapacity hardDiskCapacityType = (HardDiskCapacity) hardDiskCapacityService.getByType(harddisk_capacity_type);
//		if(!((List<HardDiskCapacity>) hardDiskCapacityType).isEmpty())
//		{
//		 //hardDiskCapacity = hardDiskCapacityType.get();
//			logger.info("getting records" +harddisk_capacity_type);
//		}
//		else
//		{
//			logger.info("no record found" +harddisk_capacity_type);
//			return new ResponseEntity<>("no records not found",HttpStatus.BAD_REQUEST);
//		}
//		logger.info("getting records");
//		return new ResponseEntity<>(hardDiskCapacity,HttpStatus.OK);
//		
//	}
//	
	
	@DeleteMapping("/deleteHardDiskCapacity/{harddisk_capacity_id}")
	public ResponseEntity<?> delete(@PathVariable(required = true )  Integer harddisk_capacity_id)
	{
		if(harddisk_capacity_id==null)
		{
			logger.error("harddisk_capacity_id is null");
			return new ResponseEntity<>("harddisk_capacity_id is null",HttpStatus.BAD_REQUEST);
		}
		try {
			if(hardDiskCapacityService.getById(harddisk_capacity_id).get()!=null)
			{
				hardDiskCapacityService.delete(harddisk_capacity_id);
				logger.info("deleted hardDiskCapacity by Id");
			}
		}
		catch (Exception e) {
			
				logger.error("no records found by id");
				return new ResponseEntity<>("harddiskcapacity id  not found",HttpStatus.NOT_FOUND);
				// TODO: handle exception
			}
			 	return new ResponseEntity<>("record deleted",HttpStatus.OK);
		}
		 
    
	@PutMapping("/updateHardDiskCapacity")
	    public ResponseEntity<?>update(@RequestBody HardDiskCapacity hardDiskCapacity) {

			if(hardDiskCapacity == null)
			{
				logger.error("harddiskcapacity object is null");
				return new ResponseEntity<>("harddiskcapacity object is null",HttpStatus.UNPROCESSABLE_ENTITY);
			}
			if(hardDiskCapacity.getHarddisk_capacity_type()==null)
			{
				logger.error("hardDiskcapacity fields are null");
				return new ResponseEntity<>("hardDiskcapacity fields are null",HttpStatus.UNPROCESSABLE_ENTITY);
			}
			try
			{
				if(hardDiskCapacityService.getById(hardDiskCapacity.getHarddisk_capacity_id())!=null)
				{
					hardDiskCapacityService.update(hardDiskCapacity);
					logger.info("harddiskcapacity is updated");
		
				}
			}
			catch (Exception e) 
			{
				// TODO: handle exception
				logger.error("no such records not found byId"+hardDiskCapacity.getHarddisk_capacity_id());
				return new ResponseEntity<>("no such records not found byId",HttpStatus.NOT_FOUND);
			}
			 	return  new ResponseEntity<>(hardDiskCapacity,HttpStatus.OK);
		
		

	}


}

