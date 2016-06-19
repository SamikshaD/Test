package com.workscape.vehicleidentifier;

import static com.workscape.vehicleidentifier.JAXBUtility.marshall;
import static com.workscape.vehicleidentifier.JAXBUtility.unMarshal;
import static com.workscape.vehicleidentifier.VehicleIdentifierConstants.EMPTY_STRING;
import static com.workscape.vehicleidentifier.VehicleIdentifierConstants.FRAME_TYPE_METAL;
import static com.workscape.vehicleidentifier.VehicleIdentifierConstants.FRAME_TYPE_PLASTIC;
import static com.workscape.vehicleidentifier.VehicleIdentifierConstants.VEHICLE_TYPE_BICYLE;
import static com.workscape.vehicleidentifier.VehicleIdentifierConstants.VEHICLE_TYPE_BIG_WHEEL;
import static com.workscape.vehicleidentifier.VehicleIdentifierConstants.VEHICLE_TYPE_CAR;
import static com.workscape.vehicleidentifier.VehicleIdentifierConstants.VEHICLE_TYPE_HANG_GLIDER;
import static com.workscape.vehicleidentifier.VehicleIdentifierConstants.VEHICLE_TYPE_MOTORCYCLE;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.workspace.vehicleidentifier.model.Response;
import com.workspace.vehicleidentifier.model.Vehicle;
import com.workspace.vehicleidentifier.model.VehicleInfo;
import com.workspace.vehicleidentifier.model.Vehicles;

/**
 * @author Samiksha Dhomne
 *
 */
public class VehicleIdentifier {

	/**
	 * This method is used to Identify the vehicle type based on vehicle
	 * parameters
	 * 
	 * @throws JAXBException
	 */
	public Response vehicleIdentifier() {
		Response responseObj = new Response();
		try {
			Vehicles veh = unMarshal();
			int bigwheel = 0, hangGlider = 0,car = 0,bicyle = 0, motorCyle = 0;
			List<VehicleInfo> vehicleInfo = new ArrayList<VehicleInfo>();
			List<Vehicle> vehList = veh.getVehicle();
			for (Vehicle vehicle : vehList) {
				VehicleInfo response = null;
				String material = vehicle.getFrame().getMaterial();
				int wheelSize = vehicle.getWheels().getWheel().size();
				String vehicleId = vehicle.getId();
				if (FRAME_TYPE_PLASTIC.equals(material) && wheelSize == 3) { // Checks frame type plastic with no of wheels
					response = setVehicleInfo(VEHICLE_TYPE_BIG_WHEEL,vehicleId);
					bigwheel++;
				} else if (FRAME_TYPE_PLASTIC.equals(material) && EMPTY_STRING.equals(vehicle.getPowertrain().getBernoulli())) { //Checks frame type plastic with Empty value of Bernoulli as per Vehicles.xml 
					response = setVehicleInfo(VEHICLE_TYPE_HANG_GLIDER,vehicleId);
					hangGlider++;
				}else if (FRAME_TYPE_METAL.equals(material) && wheelSize == 4) { //Checks frame type plastic with no of wheels 
					response = setVehicleInfo(VEHICLE_TYPE_CAR,vehicleId);
					car++;
				} else if (FRAME_TYPE_METAL.equals(material)&& EMPTY_STRING.equals(vehicle.getPowertrain().getHuman())) {  // Checks frame type metal with Empty value of human as per Vehicles.xml
					response = setVehicleInfo(VEHICLE_TYPE_BICYLE,vehicleId);
					bicyle++;
				} else if (FRAME_TYPE_METAL.equals(material) && EMPTY_STRING.equals(vehicle.getPowertrain().getInternalCombustion())) { // Checks frame type metal with Empty value of Internal Combustion as per Vehicles.xml
					response = setVehicleInfo(VEHICLE_TYPE_MOTORCYCLE,vehicleId);
					motorCyle++;
				}

				vehicleInfo.add(response);
			}
			populateResponseObject(bigwheel, hangGlider, car, bicyle,
					motorCyle, responseObj, vehicleInfo);

			marshall(responseObj);
		} catch (JAXBException jaxbException) {
			jaxbException.printStackTrace();
		}
		return responseObj;
	}
	
	/**
	 * This method sets the vehicle Info
	 * @param vehicleType
	 * @param vehicleId
	 * @return
	 */
	private VehicleInfo setVehicleInfo(String vehicleType, String vehicleId){
		VehicleInfo response = new VehicleInfo();
		response.setVehicleType(vehicleType);
		response.setVehicleId(vehicleId);
		return response;
	}

	/**
	 * This method build the response Object from list of Vehicle Info
	 * 
	 * @param bigwheel
	 * @param hangGlider
	 * @param car
	 * @param bicyle
	 * @param motorCyle
	 * @param responseObj
	 * @param vehicleInfo
	 */
	private void populateResponseObject(int bigwheel, int hangGlider, int car,
			int bicyle, int motorCyle, Response responseObj,
			List<VehicleInfo> vehicleInfo) {
		responseObj.setVehicleInfo(vehicleInfo);
		responseObj.setBicyle(bicyle);
		responseObj.setBigwheel(bigwheel);
		responseObj.setCar(car);
		responseObj.setHangGlider(hangGlider);
		responseObj.setMotorCyle(motorCyle);
	}
}
