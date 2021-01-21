package com.Inventory.Project.AssectService.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventory.Project.AssectService.Dao.RamTypeDao;
import com.Inventory.Project.AssectService.Model.RamTypeMaster;

@Service
public class RamTypeService {

	@Autowired
	private RamTypeDao ramtypedao;
	
	public RamTypeMaster saveRamType(RamTypeMaster ramtype) {
		System.out.println("service save ");
		return ramtypedao.save(ramtype);
	}
	
	public List<RamTypeMaster> saveRamType(List<RamTypeMaster> ramtypes) {
		return ramtypedao.saveAll(ramtypes);
	}
	
	public List<RamTypeMaster> getRamtype(){
		return ramtypedao.findAll();
	}
	
	public RamTypeMaster getRamTypeById(int ramtype_id) {
		return ramtypedao.findById(ramtype_id).orElse(null);
	}
	
//	public RamTypeMaster getRamTypeByName(String ramtype_name) {
//		return ramtypedao.findByName(ramtype_name).orElse(null);
//	}
	
	public String deleteRamType(int ramtype_id) {
		 ramtypedao.deleteById(ramtype_id);
		return "RamType has been deleted..";
	}
	
	public RamTypeMaster updateRamType(RamTypeMaster ramtype) {
		RamTypeMaster existingRamType= ramtypedao.findById(ramtype.getRamtype_id()).orElse(null);
		existingRamType.setRamtype_name(ramtype.getRamtype_name());
		existingRamType.setRamtype_status(ramtype.isRamtype_status());
		return ramtypedao.save(existingRamType);
	}
	
}





