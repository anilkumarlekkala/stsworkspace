package com.Inventory.Project.AssectService.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Inventory.Project.AssectService.Model.BrandMaster;

@Repository
public interface BrandMasterDao extends JpaRepository<BrandMaster, Integer> {

}