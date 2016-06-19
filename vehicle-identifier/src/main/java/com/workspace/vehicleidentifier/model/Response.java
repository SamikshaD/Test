package com.workspace.vehicleidentifier.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Response {
	
	private List<VehicleInfo> vehicleInfo;
	private int bigwheel;
    private int hangGlider;
    private int car;
   
    public int getBigwheel() {
		return bigwheel;
	}
    @XmlElement(nillable=true)
	public void setBigwheel(int bigwheel) {
		this.bigwheel = bigwheel;
	}
	
	
	public int getHangGlider() {
		return hangGlider;
	}
	@XmlElement(nillable=true)
	public void setHangGlider(int hangGlider) {
		this.hangGlider = hangGlider;
	}
	
	public int getCar() {
		return car;
	}
	@XmlElement(nillable=true)
	public void setCar(int car) {
		this.car = car;
	}
	public int getBicyle() {
		return bicyle;
	}
	@XmlElement(nillable=true)
	public void setBicyle(int bicyle) {
		this.bicyle = bicyle;
	}

	public int getMotorCyle() {
		return motorCyle;
	}
	@XmlElement(nillable=true)
	public void setMotorCyle(int motorCyle) {
		this.motorCyle = motorCyle;
	}

	private int bicyle;
    private int motorCyle;

    @XmlElement
	public List<VehicleInfo> getVehicleInfo() {
		return vehicleInfo;
	}
	public void setVehicleInfo(List<VehicleInfo> vehicleInfo) {
		this.vehicleInfo = vehicleInfo;
	} 

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + bicyle;
		result = prime * result + bigwheel;
		result = prime * result + car;
		result = prime * result + hangGlider;
		result = prime * result + motorCyle;
		result = prime * result
				+ ((vehicleInfo == null) ? 0 : vehicleInfo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Response other = (Response) obj;
		if (bicyle != other.bicyle)
			return false;
		if (bigwheel != other.bigwheel)
			return false;
		if (car != other.car)
			return false;
		if (hangGlider != other.hangGlider)
			return false;
		if (motorCyle != other.motorCyle)
			return false;
		if (vehicleInfo == null) {
			if (other.vehicleInfo != null)
				return false;
		} else if (!vehicleInfo.equals(other.vehicleInfo))
			return false;
		return true;
	}

}
