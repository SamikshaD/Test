package com.workspace.vehicleidentifier.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Vehicles {

	private List<Vehicle> vehicle;

	@XmlElement
	public List<Vehicle> getVehicle() {
		return vehicle;
	}

	public void setVehicle(List<Vehicle> vehicle) {
		this.vehicle = vehicle;
	}

}
