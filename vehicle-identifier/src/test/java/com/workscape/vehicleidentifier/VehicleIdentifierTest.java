package com.workscape.vehicleidentifier;

import static junit.framework.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import com.workspace.vehicleidentifier.model.Response;
import com.workspace.vehicleidentifier.model.VehicleInfo;

public class VehicleIdentifierTest {
	private VehicleIdentifier vehicleIdentifier;
	
	@Before
	public void setUp(){
		vehicleIdentifier = new VehicleIdentifier();
	}
	
	/** 
	 * @method testVehicleIdentifier
	 * @expected Response should be set from Vehicle Information
	 * @throws JAXBException
	 */
	@Test
	public void testVehicleIdentifier() throws JAXBException{
		Response expectedResponse = populateResponse();
		Response actualResponse = vehicleIdentifier.vehicleIdentifier();
		assertEquals(expectedResponse, actualResponse);
	}

	/**
	 * This method populates Response Object
	 * @return Response
	 */
	private Response populateResponse() {
		Response expectedResponse = new Response();
		expectedResponse.setBicyle(1);
		expectedResponse.setBigwheel(2);
		expectedResponse.setCar(1);
		expectedResponse.setHangGlider(1);
		expectedResponse.setMotorCyle(1);
		List<VehicleInfo> vehInfoList = new ArrayList<VehicleInfo>();
		VehicleInfo vehInfo1 = new VehicleInfo("vehicle 1","Big Wheel");
		vehInfoList.add(vehInfo1);
		VehicleInfo vehInfo2 = new VehicleInfo("vehicle 3","Motorcycle");
		vehInfoList.add(vehInfo2);
		VehicleInfo vehInfo3 = new VehicleInfo("vehicle 4","Hang Glider");
		vehInfoList.add(vehInfo3);
		vehInfoList.add(vehInfo1);
		VehicleInfo vehInfo4 = new VehicleInfo("vehicle 5","Car");
		vehInfoList.add(vehInfo4);
		VehicleInfo vehInfo5 = new VehicleInfo("vehicle 2","Bicyle");
		vehInfoList.add(vehInfo5);
		expectedResponse.setVehicleInfo(vehInfoList);
		return expectedResponse;
	}
}
