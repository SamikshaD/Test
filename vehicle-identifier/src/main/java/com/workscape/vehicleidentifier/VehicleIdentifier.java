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

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import com.workscape.vehicleidentifier.exception.InvalidInputException;
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
	 * @throws InvalidInputException 
	 */
	public Response vehicleIdentifier(File file ) throws InvalidInputException {
		Response responseObj = new Response();
		try {
			Vehicles veh = unMarshal(file);
			int bigwheel = 0, hangGlider = 0,car = 0,bicycle = 0, motorCyle = 0;
			List<VehicleInfo> vehicleInfo = new ArrayList<VehicleInfo>();
			List<Vehicle> vehList = veh.getVehicle();
			for (Vehicle vehicle : vehList) {
				VehicleInfo response = null;
				String material = vehicle.getFrame().getMaterial();
				int wheelSize = vehicle.getWheels().getWheel().size();
				String vehicleId = vehicle.getId();
				if (FRAME_TYPE_PLASTIC.equals(material) && wheelSize == 3 && EMPTY_STRING.equals(vehicle.getPowertrain().getHuman())) { // Checks for vehicle type big wheel
					response = setVehicleInfo(VEHICLE_TYPE_BIG_WHEEL,vehicleId);
					bigwheel++;
				} else if (FRAME_TYPE_PLASTIC.equals(material) && wheelSize == 1 && EMPTY_STRING.equals(vehicle.getPowertrain().getBernoulli())) { //Checks for vehicle type Hang Glider 
					response = setVehicleInfo(VEHICLE_TYPE_HANG_GLIDER,vehicleId);
					hangGlider++;
				}else if (FRAME_TYPE_METAL.equals(material) && wheelSize == 4 && EMPTY_STRING.equals(vehicle.getPowertrain().getInternalCombustion())) { //Checks for vehicle type Car
					response = setVehicleInfo(VEHICLE_TYPE_CAR,vehicleId);
					car++;
				} else if (FRAME_TYPE_METAL.equals(material) && wheelSize == 2 && EMPTY_STRING.equals(vehicle.getPowertrain().getHuman())) {  // Checks for vehicle type bicycle
					response = setVehicleInfo(VEHICLE_TYPE_BICYLE,vehicleId);
					bicycle++;
				} else if (FRAME_TYPE_METAL.equals(material) && wheelSize == 2 && EMPTY_STRING.equals(vehicle.getPowertrain().getInternalCombustion())) { // Checks for vehicle type Motor Cycle
					response = setVehicleInfo(VEHICLE_TYPE_MOTORCYCLE,vehicleId);
					motorCyle++;
				}

				vehicleInfo.add(response);
			}
			populateResponseObject(bigwheel, hangGlider, car, bicycle,
					motorCyle, responseObj, vehicleInfo);

			marshall(responseObj);
		} catch (JAXBException jaxbException) {
			throw new InvalidInputException();
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
