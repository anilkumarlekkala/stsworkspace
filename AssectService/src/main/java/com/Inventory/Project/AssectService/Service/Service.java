package com.Inventory.Project.AssectService.Service;

import org.springframework.http.ResponseEntity;

import com.Inventory.Project.AssectService.Model.ModelService;
@org.springframework.stereotype.Service
public interface Service {
	
	public ResponseEntity<?> addModelService(ModelService modelservice);
	
	public ResponseEntity<?> deleteById(int model_id);
	
	public ResponseEntity<?> findById(int model_id);
	
	public ResponseEntity<?> findAll();
	
	public ResponseEntity<?> update(int model_id,ModelService modelservice);
	
	public ResponseEntity<?> TotalCountofAssects();
	
	public ResponseEntity<?> CountByStatus(boolean model_status);
	
	public ResponseEntity<?> findByModelName(String model_name);
	
	

}
