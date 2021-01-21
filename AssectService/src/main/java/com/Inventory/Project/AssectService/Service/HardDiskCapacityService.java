package com.Inventory.Project.AssectService.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Inventory.Project.AssectService.Model.HardDiskCapacity;

@Service
public interface HardDiskCapacityService 
{
	
     public	void saveHardDiskCapacity(HardDiskCapacity hardDiskCapacity);
	
	public void update(HardDiskCapacity hardDiskCapacity);

	 public List<HardDiskCapacity> getAllHardDiskCapacityList();

	 public Optional<HardDiskCapacity> getById(int harddisk_capacity_id);
	
	 public void delete(int harddisk_capacity_id);

	//List<HardDiskCapacity> getByType(String harddisk_capacity_type);
	 
	// public List<HardDiskCapacity> getByType(String harddisk_capacity_type);


	
}
