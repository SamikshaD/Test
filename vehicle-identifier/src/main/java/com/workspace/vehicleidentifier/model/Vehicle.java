package com.workspace.vehicleidentifier.model;


public class Vehicle {
	public Vehicle(){}

	private String id;
	private Frame frame;
	private Wheels wheels;
	private PowerTrain powertrain;
	
	public PowerTrain getPowertrain() {
		return powertrain;
	}

	public void setPowertrain(PowerTrain powertrain) {
		this.powertrain = powertrain;
	}	
	public Frame getFrame() {
		return frame;
	}

	public void setFrame(Frame frame) {
		this.frame = frame;
	}


	public Wheels getWheels() {
		return wheels;
	}

	public void setWheels(Wheels wheels) {
		this.wheels = wheels;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

}
