package com.workscape.vehicleidentifier;

import javax.xml.bind.JAXBException;

/**
 * Client Class for Vehicle Identifier
 * 
 */
public class VehicleIdentifierClient {

	public static void main(String[] args) throws JAXBException{
		VehicleIdentifier vehicleIdentifier = new VehicleIdentifier();
		vehicleIdentifier.vehicleIdentifier();
	}
}
