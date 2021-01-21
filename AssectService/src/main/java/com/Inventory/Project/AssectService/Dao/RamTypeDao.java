package com.Inventory.Project.AssectService.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Inventory.Project.AssectService.Model.RamTypeMaster;

@Repository
public interface RamTypeDao extends JpaRepository<RamTypeMaster, Integer> {

//	Optional<RamTypeMaster> findByName(String ramtype_name);

}