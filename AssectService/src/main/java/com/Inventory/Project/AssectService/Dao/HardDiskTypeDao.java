package com.Inventory.Project.AssectService.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Inventory.Project.AssectService.Model.HardDiskTypeModel;

@Repository
public interface HardDiskTypeDao extends JpaRepository<HardDiskTypeModel, Integer> {

	List<HardDiskTypeModel> findByHardDiskType(String hardDiSkType);

}
