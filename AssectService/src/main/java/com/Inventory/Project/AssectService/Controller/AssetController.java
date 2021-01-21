package com.Inventory.Project.AssectService.Controller;

import java.util.List;

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

import com.Inventory.Project.AssectService.Model.AssetTypeMasterEx;
import com.Inventory.Project.AssectService.Service.IAssetService;

//@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("/rest/assettype")
public class AssetController {
	
	private static final Logger logger = LogManager.getLogger(AssetController.class);
	
	@Autowired
	private IAssetService serv;
	
	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody AssetTypeMasterEx atx){
		ResponseEntity<String> resp=null;
		try {
			Integer id=serv.saveAssetType(atx);
			logger.info("asset type is added or created");
			resp=new ResponseEntity<String>("Asset '"+id+"'created",HttpStatus.OK);
		} catch (Exception e) {
			logger.info("asset type is through error");
			resp=new ResponseEntity<String>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return resp;
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		ResponseEntity<?> resp=null;
		List<AssetTypeMasterEx> list=serv.getAllAssetTypeMasterExs();
		if(list==null || list.isEmpty()) {
			String message="No Data Found";
			logger.info("getting list of records" + list);
			resp=new ResponseEntity<String>(message,HttpStatus.OK);
		}else {
			logger.info("Not getting list of records" + list);
			resp=new ResponseEntity<List<AssetTypeMasterEx>>(list,HttpStatus.OK);
		}
		return resp;
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> deleteById(@PathVariable Integer id){
		ResponseEntity<String> resp=null;
		boolean present=serv.isPresent(id);
		if(present) {
			serv.deleteAssetType(id);
			logger.info("deleted asset type successfully   " + id);
			resp=new ResponseEntity<String>("Deleted '"+id+"' successfully",HttpStatus.OK);
		}else {
			logger.error("no records found with asset type id in deleteById");
			resp=new ResponseEntity<String>("'"+id+"' Not Exist",HttpStatus.BAD_REQUEST);
		}
		return resp;	
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> update(@RequestBody AssetTypeMasterEx atx){
		ResponseEntity<String> resp=null;
		boolean present=serv.isPresent(atx.getAsset_id());
		if(present) {
			serv.updateAssetType(atx);
			logger.info("asset type is updated successfully");
			resp=new ResponseEntity<String>("Update Successfully",HttpStatus.OK);
		}else {
			logger.error("no records found with asset type ");
			resp=new ResponseEntity<String>("REcord '"+atx.getAsset_id()+"' not found",HttpStatus.BAD_REQUEST);
		}
		return resp;	
	}
}


