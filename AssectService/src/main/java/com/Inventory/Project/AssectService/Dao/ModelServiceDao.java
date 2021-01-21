package com.Inventory.Project.AssectService.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.Inventory.Project.AssectService.Model.ModelService;

public interface ModelServiceDao extends JpaRepository<ModelService, Integer>{
	@Query(value = "select count(model_id) from model_master where model_status=:model_status",nativeQuery = true)
	public long CountByStatus(@Param("model_status") boolean model_status);
	
	@Query(value = "select * from model_master where model_name=:model_name",nativeQuery = true)
	public List<String> findByModelname(@Param("model_name") String model_name);


}
