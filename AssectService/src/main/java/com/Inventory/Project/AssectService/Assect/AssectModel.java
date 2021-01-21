package com.Inventory.Project.AssectService.Assect;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Assect_10")
public class AssectModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long assect_id;

	private String brand;
	private String serial_no;
	private String purchaseDCNo;
	@Temporal(TemporalType.DATE)
	private Date warrentStartDate;
	private String vendor;
	private String assectType;
	private String models;
	@Temporal(TemporalType.DATE)
	private Date purchaseDate;
	private String purchaseInvoiceNo;
	@Temporal(TemporalType.DATE)
	private Date warrentEndDate;
	private Double cost;
	@Lob
	private Byte[] invoiceDoc;
	@Lob
	private Byte[] warantyDoc; 
	private int noOfHardDisks;
	private String hardDiskCapacity;
	private String hardDiskType;
	private int noOfRams;
	private String typeOfRam;
	private String ramCapacity;
	private String location;
	private String floor;

	public long getAssect_id() {
		return assect_id;
	}

	public void setAssect_id(long assect_id) {
		this.assect_id = assect_id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public String getPurchaseDCNo() {
		return purchaseDCNo;
	}

	public void setPurchaseDCNo(String purchaseDCNo) {
		this.purchaseDCNo = purchaseDCNo;
	}

	public Date getWarrentStartDate() {
		return warrentStartDate;
	}

	public void setWarrentStartDate(Date warrentStartDate) {
		this.warrentStartDate = warrentStartDate;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getAssectType() {
		return assectType;
	}

	public void setAssectType(String assectType) {
		this.assectType = assectType;
	}

	public String getModels() {
		return models;
	}

	public void setModels(String models) {
		this.models = models;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

	public String getPurchaseInvoiceNo() {
		return purchaseInvoiceNo;
	}

	public void setPurchaseInvoiceNo(String purchaseInvoiceNo) {
		this.purchaseInvoiceNo = purchaseInvoiceNo;
	}

	public Date getWarrentEndDate() {
		return warrentEndDate;
	}

	public void setWarrentEndDate(Date warrentEndDate) {
		this.warrentEndDate = warrentEndDate;
	}

	public Double getCost() {
		return cost;
	}

	public void setCost(Double cost) {
		this.cost = cost;
	}

	public Byte[] getInvoiceDoc() {
		return invoiceDoc;
	}

	public void setInvoiceDoc(Byte[] invoiceDoc) {
		this.invoiceDoc = invoiceDoc;
	}

	public Byte[] getWarantyDoc() {
		return warantyDoc;
	}

	public void setWarantyDoc(Byte[] warantyDoc) {
		this.warantyDoc = warantyDoc;
	}

	public int getNoOfHardDisks() {
		return noOfHardDisks;
	}

	public void setNoOfHardDisks(int noOfHardDisks) {
		this.noOfHardDisks = noOfHardDisks;
	}

	public String getHardDiskCapacity() {
		return hardDiskCapacity;
	}

	public void setHardDiskCapacity(String hardDiskCapacity) {
		this.hardDiskCapacity = hardDiskCapacity;
	}

	public String getHardDiskType() {
		return hardDiskType;
	}

	public void setHardDiskType(String hardDiskType) {
		this.hardDiskType = hardDiskType;
	}

	public int getNoOfRams() {
		return noOfRams;
	}

	public void setNoOfRams(int noOfRams) {
		this.noOfRams = noOfRams;
	}

	public String getTypeOfRam() {
		return typeOfRam;
	}

	public void setTypeOfRam(String typeOfRam) {
		this.typeOfRam = typeOfRam;
	}

	public String getRamCapacity() {
		return ramCapacity;
	}

	public void setRamCapacity(String ramCapacity) {
		this.ramCapacity = ramCapacity;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

		
}
