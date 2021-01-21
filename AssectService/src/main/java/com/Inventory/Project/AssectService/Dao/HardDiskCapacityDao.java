package com.Inventory.Project.AssectService.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Inventory.Project.AssectService.Model.HardDiskCapacity;

@Repository
public interface HardDiskCapacityDao extends JpaRepository<HardDiskCapacity, Integer> {

	// List<HardDiskCapacity> findByHardDiskType(String harddisk_capacity_type);

}
