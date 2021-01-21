package com.Inventory.Project.AssectService.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "ModelMaster")
public class ModelService {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "model_id", nullable = false)
	private int model_id;

	@NotNull
	@Column(name = "model_name")
	private String model_name;

	@Column(name = "model_status")
	@NotNull
	private boolean model_status;

	public int getModel_id() {
		return model_id;
	}

	public void setModel_id(int model_id) {
		this.model_id = model_id;
	}

	public String getModel_name() {
		return model_name;
	}

	public void setModel_name(String model_name) {
		this.model_name = model_name;
	}

	public boolean getModel_status() {
		return model_status;
	}

	public void setModel_status(boolean model_status) {
		this.model_status = model_status;
	}

	public ModelService(int model_id, String model_name, boolean model_status) {
		super();
		this.model_id = model_id;
		this.model_name = model_name;
		this.model_status = model_status;

	}

	public ModelService() {
		super();
	}

	@Override
	public String toString() {
		return "ModelService [model_id=" + model_id + ", model_name=" + model_name + ", model_status=" + model_status
				+ "]";
	}

}
