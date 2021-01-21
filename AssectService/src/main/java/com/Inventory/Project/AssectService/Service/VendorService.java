package com.Inventory.Project.AssectService.Service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Inventory.Project.AssectService.Dao.VendorRepository;
import com.Inventory.Project.AssectService.Model.Vendor;

@Service
@Transactional
public class VendorService {

	private static final Logger logger = LogManager.getLogger(VendorService.class);

	@Autowired
	private VendorRepository vendorRepository;

	public void insertVendor(Vendor vendor) {

		logger.info("inserting vendor");
		vendorRepository.save(vendor);

	}

	public List<Vendor> getVendorByStatus(Boolean vendorstatus) {

		logger.info("getting list by vendorstatus");
		List<Vendor> list = vendorRepository.findByVendorStatus(vendorstatus);

		return list;

	}

	public List<Vendor> getListOfVendors() {

		logger.info("inserting vendor");
		return vendorRepository.findAll();

	}

	public Optional<Vendor> getVendorById(Integer id) {

		logger.info("getting vendor by Id");

		Optional<Vendor> optional = vendorRepository.findById(id);

		return optional;

	}

	public List<Vendor> getVendorByName(String name) {

		logger.info("getting  vendor by name");

		List<Vendor> vendor = vendorRepository.findByVendorName(name);

		return vendor;
	}

	public void upateVendor(Vendor vendor) {

		logger.info("upadating vendor");
		vendorRepository.save(vendor);

	}

	public void deleteVendorById(Integer id) {

		vendorRepository.deleteById(id);

	}

}
