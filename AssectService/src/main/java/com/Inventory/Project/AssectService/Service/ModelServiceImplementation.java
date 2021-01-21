package com.Inventory.Project.AssectService.Service;

import java.util.List;
import java.util.Optional;

import javax.persistence.NoResultException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.Inventory.Project.AssectService.Dao.ModelServiceDao;
import com.Inventory.Project.AssectService.Model.ModelService;

@org.springframework.stereotype.Service
public class ModelServiceImplementation implements Service {

	private static final Logger log = LogManager.getLogger(ModelServiceImplementation.class);

	@Autowired
	public ModelServiceDao modelservicedao;

	@Override
	public ResponseEntity<?> addModelService(ModelService modelservice) {

		if (modelservice.getModel_name().isEmpty()
				|| modelservicedao.findById(modelservice.getModel_id()).equals(modelservice.getModel_id())) {
			String string = new String("Please do not pass Null values");
			log.error("Here the Input values are Empty");
			return new ResponseEntity<>(string, HttpStatus.BAD_REQUEST);
		} else {

			ModelService service = modelservicedao.save(modelservice);
			log.info("Data Inserted Successfully");
			return new ResponseEntity<ModelService>(service, HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<?> deleteById(int model_id) {

		Optional<ModelService> optional = modelservicedao.findById(model_id);
		if (optional.isPresent()) {
			modelservicedao.deleteById(model_id);
			String string = new String("Model service object deleted successfully");
			log.info("Object deleted successfully");
			return new ResponseEntity<>(string, HttpStatus.OK);
		}
		log.error("No data present with the model_id : " + model_id);
		return new ResponseEntity<ModelService>(HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> findById(int model_id) {
		try {
			Optional<ModelService> optional = modelservicedao.findById(model_id);
			if (optional.isPresent()) {
				Optional<ModelService> list = modelservicedao.findById(model_id);
				log.info("Here the List of Modelservices");
				return new ResponseEntity<>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			log.error("No Data Found");
			NoResultException exception = new NoResultException("Exception Caused : " + e);
			return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
		}
		String string = new String("No Data Found");
		return new ResponseEntity<>(string, HttpStatus.CONFLICT);
	}

	@Override
	public ResponseEntity<?> findAll() {
		List<ModelService> list = modelservicedao.findAll();
		if (list != null) {
			log.info("Total Modelservice Data List");
			return new ResponseEntity<>(list, HttpStatus.OK);
		} else {
			log.error("No Data Found");
			String string = new String("No ModelServiceData Found");
			return new ResponseEntity<>(string, HttpStatus.NOT_FOUND);
		}
	}

	@Override
	public ResponseEntity<?> findByModelName(String model_name) {
		List<String> modelname = modelservicedao.findByModelname(model_name); 
		if (modelname != null) {
			log.info("List of Models By Name");
			return new ResponseEntity<>(modelname, HttpStatus.FOUND);
		} else {
			log.error("No Data Found");
			String string = new String("No Model Found By Name");
			return new ResponseEntity<>(string, HttpStatus.NOT_FOUND);
		}

	}

	@Override
	public ResponseEntity<?> update(int model_id, ModelService modelService) {
		Optional<ModelService> findById = modelservicedao.findById(model_id);

		if (findById.isPresent()) {
			ModelService service = new ModelService();
			service.setModel_id(model_id);
			service.setModel_name(modelService.getModel_name());
			service.setModel_status(modelService.getModel_status());
			log.info("Modelservice updated successfully");
			modelservicedao.save(service);
			return new ResponseEntity<ModelService>(service, HttpStatus.ACCEPTED);
		}
		log.error("No ModelService present with this model_id : " + model_id);
		String string = new String("No ModelService present with this model_id : " + model_id);
		return new ResponseEntity<>(string, HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> TotalCountofAssects() {
		long count = modelservicedao.count();
		String string = new String("Total Counnt Models : " + count);
		log.info("Total No of models are :" + count);
		return new ResponseEntity<String>(string, HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> CountByStatus(boolean model_status) {
		if (model_status == true) {
			long count = modelservicedao.CountByStatus(model_status);
			String string = new String("Count of Actice Models are : " + count);
			log.info("Number of Active Modes are :" + count);
			return new ResponseEntity<String>(string, HttpStatus.OK);
		} else {

			long count = modelservicedao.CountByStatus(model_status);
			String string = new String("Count of InActive Model are : " + count);
			log.info("Number of InActive Models are :" + count);
			return new ResponseEntity<String>(string, HttpStatus.OK);
		}

	}



}
