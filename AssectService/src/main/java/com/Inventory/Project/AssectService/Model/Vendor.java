package com.Inventory.Project.AssectService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table(name = "Vendor")
public class Vendor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "vendor_id")
	private Integer vendorId;
	@Column(name = "vendor_name")
	private String vendorName;

	private String email;
	@Column(name = "contact_number")
	private String contactNumber;
	@Column(name = "gst_number")
	private String gstNumber;
	@Column(name = " street_line1")
	private String streetLine1;
	@Column(name = "street_line2")
	private String streetLine2;

	private String pincode;

	private String cityname;

	private String state;
	@Column(name = "vendor_status")
	private Boolean vendorStatus;
	@Lob
	@Column(name = "vendor_agreement")
	private Byte[] vendorAgreement;
	public Integer getVendorId() {
		return vendorId;
	}
	public void setVendorId(Integer vendorId) {
		this.vendorId = vendorId;
	}
	public String getVendorName() {
		return vendorName;
	}
	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getContactNumber() {
		return contactNumber;
	}
	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}
	public String getGstNumber() {
		return gstNumber;
	}
	public void setGstNumber(String gstNumber) {
		this.gstNumber = gstNumber;
	}
	public String getStreetLine1() {
		return streetLine1;
	}
	public void setStreetLine1(String streetLine1) {
		this.streetLine1 = streetLine1;
	}
	public String getStreetLine2() {
		return streetLine2;
	}
	public void setStreetLine2(String streetLine2) {
		this.streetLine2 = streetLine2;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getCityname() {
		return cityname;
	}
	public void setCityname(String cityname) {
		this.cityname = cityname;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public Boolean getVendorStatus() {
		return vendorStatus;
	}
	public void setVendorStatus(Boolean vendorStatus) {
		this.vendorStatus = vendorStatus;
	}
	public Byte[] getVendorAgreement() {
		return vendorAgreement;
	}
	public void setVendorAgreement(Byte[] vendorAgreement) {
		this.vendorAgreement = vendorAgreement;
	}

}