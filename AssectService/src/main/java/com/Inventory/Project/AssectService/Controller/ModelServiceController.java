package com.Inventory.Project.AssectService.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.Inventory.Project.AssectService.Model.ModelService;
import com.Inventory.Project.AssectService.Service.ModelServiceImplementation;

//@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/Modelservice")
public class ModelServiceController {

	@Autowired
	public ModelServiceImplementation serviceimplementation;

	/* Adding ModelService */

	@PostMapping("/addModelService")
	@DeleteMapping
	public ResponseEntity<?> addModelService(@RequestBody ModelService modelservice) {
		return serviceimplementation.addModelService(modelservice);

	}

	/* Deleting ModelService Based on ID */
	@DeleteMapping("/deleteModelService/{model_id}")
	public ResponseEntity<?> deleteModelService(@PathVariable("model_id") int model_id) {
		return serviceimplementation.deleteById(model_id);

	}

	/* Finding ModelService Based on ID */
	@GetMapping("/ModelServicefindByid/{model_id}")
	public ResponseEntity<?> findById(@PathVariable("model_id") int model_id) {
		return serviceimplementation.findById(model_id);
	}

	/* Retrieving All ModelService Data */
	@GetMapping("/getAllModelServices")
	public ResponseEntity<?> findAll() {
		return serviceimplementation.findAll();
	}

	@GetMapping("/getByModelname/{model_name}")
	public ResponseEntity<?> findByModelname(@PathVariable("model_name") String model_name) {
		return serviceimplementation.findByModelName(model_name);
	}

	/* Updating ModelService Based on ID */
	@PutMapping("/upadateModelService/{model_id}")
	public ResponseEntity<?> updateById(@PathVariable("model_id") int model_id,
			@RequestBody ModelService modelService) {
		return serviceimplementation.update(model_id, modelService);
	}

	/* Total Count of Models */
	@GetMapping("/TotalCount")
	public ResponseEntity<?> countOfTotalModels() {
		return serviceimplementation.TotalCountofAssects();

	}

	/* Count of Active Models and InActive Models By passing the status */
	@GetMapping("/countByStatus/{model_status}")
	public ResponseEntity<?> countOfAssestsByStatus(@PathVariable("model_status") boolean model_status) {
		return serviceimplementation.CountByStatus(model_status);
	}
}
