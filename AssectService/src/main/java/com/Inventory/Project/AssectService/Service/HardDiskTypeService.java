package com.Inventory.Project.AssectService.Service;

import java.util.List;
import java.util.Optional;

import com.Inventory.Project.AssectService.Model.HardDiskTypeModel;

public interface HardDiskTypeService {
	
	public void insertHardDisktTpe(HardDiskTypeModel hardDiskTypeModel);
		
	public List<HardDiskTypeModel> getListOfHardDiskTypes();
	
	public Optional<HardDiskTypeModel> getHardDiskTypeById(Integer hardDiskId);
	
	public List<HardDiskTypeModel> getHardDiskTypeByType(String hardDiskSType);
	
	public void deleteHardDiskTypeById(Integer hardDiskId);

	public void updateHardDiskType(HardDiskTypeModel hardDiskTypeModel);
	

}
