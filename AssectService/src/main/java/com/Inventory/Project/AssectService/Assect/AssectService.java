package com.Inventory.Project.AssectService.Assect;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.Inventory.Project.AssectService.Dao.AssetRepositry;
import com.Inventory.Project.AssectService.Dao.BrandMasterDao;
import com.Inventory.Project.AssectService.Dao.HardDiskCapacityDao;
import com.Inventory.Project.AssectService.Dao.HardDiskTypeDao;
import com.Inventory.Project.AssectService.Dao.ModelServiceDao;
import com.Inventory.Project.AssectService.Dao.RamCapacityDAO;
import com.Inventory.Project.AssectService.Dao.RamTypeDao;
import com.Inventory.Project.AssectService.Dao.VendorRepository;
import com.Inventory.Project.AssectService.Model.AssetTypeMasterEx;
import com.Inventory.Project.AssectService.Model.BrandMaster;
import com.Inventory.Project.AssectService.Model.HardDiskCapacity;
import com.Inventory.Project.AssectService.Model.HardDiskTypeModel;
import com.Inventory.Project.AssectService.Model.ModelService;
import com.Inventory.Project.AssectService.Model.RamCapacity;
import com.Inventory.Project.AssectService.Model.RamTypeMaster;
import com.Inventory.Project.AssectService.Model.Vendor;

@Service
public class AssectService {

	@Autowired
	private BrandMasterDao brandmasterdao;
	@Autowired
	private HardDiskTypeDao harddisktypedao;
	@Autowired
	private VendorRepository vendordao;
	@Autowired
	private ModelServiceDao modelservicedao;
	@Autowired
	private AssectDao assectDao;
	@Autowired
	private HardDiskCapacityDao harddiskcapacityDao;
	@Autowired
	private RamTypeDao ramtypedao;
	@Autowired
	private RamCapacityDAO ramCapacityDAO;
	@Autowired
	private AssetRepositry assettypedao;

	public ResponseEntity<?> addAssect(AssectModel assectModel) {
		if (assectModel != null) {
			AssectModel save = assectDao.save(assectModel);
			return new ResponseEntity<>(save, HttpStatus.CREATED);
		} else {
			String string = new String("Please Enter the currect valus Fields Should Not be Empty");
			return new ResponseEntity<String>(string, HttpStatus.BAD_REQUEST);
		}

	}

	public ResponseEntity<?> getBrandNames() {
		List<BrandMaster> brands = brandmasterdao.findAll();
		if (brands != null) {
			return new ResponseEntity<>(brands, HttpStatus.FOUND);
		} else {
			String string = new String("No Brand Found");
			return new ResponseEntity<String>(string, HttpStatus.NOT_FOUND);
		}

	}

	public ResponseEntity<?> getModelNames() {
		List<ModelService> models = modelservicedao.findAll();
		if (models != null) {
			return new ResponseEntity<>(models, HttpStatus.FOUND);
		} else {
			String string = new String("No Model Found");
			return new ResponseEntity<String>(string, HttpStatus.NOT_FOUND);

		}

	}

	public ResponseEntity<?> getVendors() {
		List<Vendor> vendors = vendordao.findAll();
		if (vendors != null) {
			return new ResponseEntity<>(vendors, HttpStatus.FOUND);
		} else {
			String string = new String("No Vendor Found");
			return new ResponseEntity<String>(string, HttpStatus.NOT_FOUND);

		}

	}

	public ResponseEntity<?> getHardDiskType() {
		List<HardDiskTypeModel> harddisktype = harddisktypedao.findAll();
		if (harddisktype != null) {
			return new ResponseEntity<>(harddisktype, HttpStatus.FOUND);
		} else {
			String string = new String("No HardDiskType Found");
			return new ResponseEntity<String>(string, HttpStatus.NOT_FOUND);

		}
	}

	public ResponseEntity<?> getHardDiskCapacity() {
		List<HardDiskCapacity> harddiskcapacity = harddiskcapacityDao.findAll();
		if (harddiskcapacity != null) {
			return new ResponseEntity<>(harddiskcapacity, HttpStatus.FOUND);
		} else {
			String string = new String("No HardDiskCapacity Found");
			return new ResponseEntity<String>(string, HttpStatus.NOT_FOUND);

		}
	}

	public ResponseEntity<?> getRamType() {
		List<RamTypeMaster> ramtype = ramtypedao.findAll();
		if (ramtype != null) {
			return new ResponseEntity<>(ramtype, HttpStatus.FOUND);
		} else {
			String string = new String("No RamType Found");
			return new ResponseEntity<String>(string, HttpStatus.NOT_FOUND);

		}

	}

	public ResponseEntity<?> getRamCapacity() {
		List<RamCapacity> ramcapacity = ramCapacityDAO.findAll();
		if (ramcapacity != null) {
			return new ResponseEntity<>(ramcapacity, HttpStatus.FOUND);
		} else {
			String string = new String("No RamCapacity Found");
			return new ResponseEntity<String>(string, HttpStatus.NOT_FOUND);

		}

	}

	public ResponseEntity<?> getAssectType() {
		List<AssetTypeMasterEx> assecttype = assettypedao.findAll();
		if (assecttype != null) {
			return new ResponseEntity<>(assecttype,HttpStatus.FOUND);
		}else {
			String string = new String("No AssectType Found");
			return new ResponseEntity<String>(string, HttpStatus.NOT_FOUND);

		}
	
	}
}
