package com.Inventory.Project.AssectService.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Inventory.Project.AssectService.Model.AssetTypeMasterEx;

@Repository
public interface AssetRepositry extends JpaRepository<AssetTypeMasterEx, Integer> {

}