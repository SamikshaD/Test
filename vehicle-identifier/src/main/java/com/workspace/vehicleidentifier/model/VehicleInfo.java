package com.workspace.vehicleidentifier.model;


public class VehicleInfo {
	
	private String vehicleId;
	
	private String VehicleType;
	
	public String getVehicleId() {
		return vehicleId;
	}
	public VehicleInfo(){}
	public VehicleInfo(String vehicleId, String vehicleType) {
		super();
		this.vehicleId = vehicleId;
		VehicleType = vehicleType;
	}
	public void setVehicleId(String vehicleId) {
		this.vehicleId = vehicleId;
	}
	public String getVehicleType() {
		return VehicleType;
	}
	public void setVehicleType(String vehicleType) {
		VehicleType = vehicleType;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((VehicleType == null) ? 0 : VehicleType.hashCode());
		result = prime * result
				+ ((vehicleId == null) ? 0 : vehicleId.hashCode());
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
		VehicleInfo other = (VehicleInfo) obj;
		if (VehicleType == null) {
			if (other.VehicleType != null)
				return false;
		} else if (!VehicleType.equals(other.VehicleType))
			return false;
		if (vehicleId == null) {
			if (other.vehicleId != null)
				return false;
		} else if (!vehicleId.equals(other.vehicleId))
			return false;
		return true;
	}

}
