package com.Inventory.Project.AssectService.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Inventory.Project.AssectService.Model.RamCapacity;

@Repository
public interface RamCapacityDAO extends JpaRepository<RamCapacity, Integer> {

}
