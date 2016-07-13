package com.workscape.vehicleidentifier;

import java.io.File;

import com.workscape.vehicleidentifier.exception.InvalidInputException;

/**
 * Client Class for Vehicle Identifier
 * 
 */
public class VehicleIdentifierClient {

	public static void main(String[] args) throws InvalidInputException {
		VehicleIdentifier vehicleIdentifier = new VehicleIdentifier();
		File file = new File("src/main/resources/vehicles.xml");
		vehicleIdentifier.vehicleIdentifier(file);
	}
}
