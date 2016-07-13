package com.workscape.vehicleidentifier;

import static junit.framework.Assert.assertEquals;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.junit.Before;
import org.junit.Test;

import com.workscape.vehicleidentifier.exception.InvalidInputException;
import com.workspace.vehicleidentifier.model.Response;
import com.workspace.vehicleidentifier.model.VehicleInfo;

public class VehicleIdentifierTest {
	private VehicleIdentifier vehicleIdentifier;
	
	@Before
	public void setUp(){
		vehicleIdentifier = new VehicleIdentifier();
	}
	
	//Happy Path Scenarios
	
	/** 
	 * @method testVehicleIdentifier for Vehicle type Big Wheel
	 * @expected Response should be set with Vehicle Information of Big Wheel
	 * @throws InvalidInputException
	 */
	@Test
	public void testForVehicleTypeBigWheel() throws InvalidInputException{
		Response expectedResponse = populateResponseForBigWheel();
		File file = new File("src/main/resources/vehicleTypeBigWheel.xml");
		Response actualResponse = vehicleIdentifier.vehicleIdentifier(file);
		assertEquals(expectedResponse, actualResponse);
	}
	
	/** 
	 * @method testVehicleIdentifier for Vehicle type Bicycle
	 * @expected Response should be set with Vehicle Information of Bicycle
	 * @throws InvalidInputException
	 */
	@Test
	public void testForVehicleTypeBicyle() throws InvalidInputException{
		Response expectedResponse = populateResponseForBicycle();
		File file = new File("src/main/resources/vehicleTypeBicycle.xml");
		Response actualResponse = vehicleIdentifier.vehicleIdentifier(file);
		assertEquals(expectedResponse, actualResponse);
	}
	
	/** 
	 * @throws InvalidInputException 
	 * @method testVehicleIdentifier for Vehicle type MotorCycle
	 * @expected Response should be set with Vehicle Information of MotorCycle
	 * @throws JAXBException
	 */
	@Test
	public void testForVehicleTypeMotorCycle() throws InvalidInputException{
		Response expectedResponse = populateResponseForMotorCycle();
		File file = new File("src/main/resources/vehicleTypeMotorCycle.xml");
		Response actualResponse = vehicleIdentifier.vehicleIdentifier(file);
		assertEquals(expectedResponse, actualResponse);
	}
	
	/** 
	 * @method testVehicleIdentifier for Vehicle type HangGlider
	 * @expected Response should be set with Vehicle Information of HangGlider
	 * @throws InvalidInputException
	 */
	@Test
	public void testForVehicleTypeHangGlider() throws InvalidInputException{
		Response expectedResponse = populateResponseForHangGlider();
		File file = new File("src/main/resources/vehicleTypeHangGlider.xml");
		Response actualResponse = vehicleIdentifier.vehicleIdentifier(file);
		assertEquals(expectedResponse, actualResponse);
	}
	
	/** 
	 * @method testVehicleIdentifier for Vehicle type Car
	 * @expected Response should be set with Vehicle Information of Car
	 * @throws InvalidInputException
	 */
	@Test
	public void testForVehicleTypeCar() throws InvalidInputException{
		Response expectedResponse = populateResponseForCar();
		File file = new File("src/main/resources/vehicleTypeCar.xml");
		Response actualResponse = vehicleIdentifier.vehicleIdentifier(file);
		assertEquals(expectedResponse, actualResponse);
	}
	/** 
	 * @throws InvalidInputException 
	 * @method testVehicleIdentifier for multiple Vehicle types
	 * @expected Response should be set from Vehicle Information
	 * @throws JAXBException
	 */
	@Test
	public void testVehicleIdentifierForMultipleVehicles() throws InvalidInputException{
		Response expectedResponse = populateResponse();
		File file = new File("src/main/resources/vehicles.xml");
		Response actualResponse = vehicleIdentifier.vehicleIdentifier(file);
		assertEquals(expectedResponse, actualResponse);
	}
	
	//Negative Scenarios
	/** 
	 * @method testVehicleIdentifier for an invalid Frame type(glass)
	 * @expected Response should be set with vehicle count as zero
	 * @throws InvalidInputException
	 */
	@Test
	public void testVehicleIdentifierForInvalidFrameType() throws InvalidInputException{
		File file = new File("src/main/resources/invalidFrameType.xml");
		Response actualResponse = vehicleIdentifier.vehicleIdentifier(file);
		assertEquals(0, actualResponse.getBicyle());
		assertEquals(0, actualResponse.getBigwheel());
		assertEquals(0, actualResponse.getCar());
		assertEquals(0, actualResponse.getHangGlider());
		assertEquals(0, actualResponse.getMotorCyle());
	}
	
	/** 
	 * @method testVehicleIdentifier for an invalid number of wheels i.e 1
	 * @expected Response should be set with vehicle count as zero
	 * @throws InvalidInputException
	 */
	@Test
	public void testVehicleIdentifierForInvalidWheels() throws InvalidInputException{
		File file = new File("src/main/resources/invalidWheels.xml");
		Response actualResponse = vehicleIdentifier.vehicleIdentifier(file);
		assertEquals(0, actualResponse.getBicyle());
		assertEquals(0, actualResponse.getBigwheel());
		assertEquals(0, actualResponse.getCar());
		assertEquals(0, actualResponse.getHangGlider());
		assertEquals(0, actualResponse.getMotorCyle());
	}
	
	
	/** 
	 * @method testVehicleIdentifier for an invalid power train (abc)
	 * @expected Response should be set with vehicle count as zero
	 * @throws InvalidInputException
	 */
	@Test
	public void testVehicleIdentifierForInvalidPowerTrain() throws InvalidInputException{
		File file = new File("src/main/resources/invalidPowerTrain.xml");
		Response actualResponse = vehicleIdentifier.vehicleIdentifier(file);
		assertEquals(0, actualResponse.getBicyle());
		assertEquals(0, actualResponse.getBigwheel());
		assertEquals(0, actualResponse.getCar());
		assertEquals(0, actualResponse.getHangGlider());
		assertEquals(0, actualResponse.getMotorCyle());
	}
	
	/** 
	 * @method testVehicleIdentifier for an invalid combination of Frame type(plastic) and wheels(2)
	 * @expected Response should be set with vehicle count as zero
	 * @throws InvalidInputException
	 */
	@Test
	public void testVehicleIdentifierForInvalidFrameTypeWheels() throws InvalidInputException{
		File file = new File("src/main/resources/invalidFrameWheels.xml");
		Response actualResponse = vehicleIdentifier.vehicleIdentifier(file);
		assertEquals(0, actualResponse.getBicyle());
		assertEquals(0, actualResponse.getBigwheel());
		assertEquals(0, actualResponse.getCar());
		assertEquals(0, actualResponse.getHangGlider());
		assertEquals(0, actualResponse.getMotorCyle());
	}
	
	/** 
	 * @method testVehicleIdentifier for an invalid combination of Frame type(Plastic) and powerTrain(bernoulli)
	 * @expected Response should be set with vehicle count as zero
	 * @throws InvalidInputException
	 */
	@Test
	public void testVehicleIdentifierForInvalidFrameTypePowerTrain() throws InvalidInputException{
		File file = new File("src/main/resources/invalidFrameTypePowerTrain.xml");
		Response actualResponse = vehicleIdentifier.vehicleIdentifier(file);
		assertEquals(0, actualResponse.getBicyle());
		assertEquals(0, actualResponse.getBigwheel());
		assertEquals(0, actualResponse.getCar());
		assertEquals(0, actualResponse.getHangGlider());
		assertEquals(0, actualResponse.getMotorCyle());
	}
	
	/** 
	 * @method testVehicleIdentifier for an invalid combination of Frame type(metal) and no of wheels(3) and power train bernoulli
	 * @expected Response should be set with vehicle count as zero
	 * @throws InvalidInputException
	 */
	@Test
	public void testVehicleIdentifierForInvalidFrameTypeWheelsPowerTrain() throws InvalidInputException{
		File file = new File("src/main/resources/invalidFrameTypeWheelsPowerTrain.xml");
		Response actualResponse = vehicleIdentifier.vehicleIdentifier(file);
		assertEquals(0, actualResponse.getBicyle());
		assertEquals(0, actualResponse.getBigwheel());
		assertEquals(0, actualResponse.getCar());
		assertEquals(0, actualResponse.getHangGlider());
		assertEquals(0, actualResponse.getMotorCyle());
	}
	
	/** 
	 * @method testVehicleIdentifier for an invalid combination of Frame type(metal) and no of wheels(2) and power train bernoulli
	 * @expected Response should be set with vehicle count as zero
	 * @throws InvalidInputException
	 */
	@Test
	public void testVehicleIdentifierForInvalidFrameTypeMetalWheelsPowerTrain() throws InvalidInputException{
		File file = new File("src/main/resources/invalidFrameTypeMetalTwoWheelsPowerTrain.xml");
		Response actualResponse = vehicleIdentifier.vehicleIdentifier(file);
		assertEquals(0, actualResponse.getBicyle());
		assertEquals(0, actualResponse.getBigwheel());
		assertEquals(0, actualResponse.getCar());
		assertEquals(0, actualResponse.getHangGlider());
		assertEquals(0, actualResponse.getMotorCyle());
	}
	
	/** 
	 * @method testVehicleIdentifier for an invalid combination of Frame type(metal) and no of wheels(4) and power train bernoulli
	 * @expected Response should be set with vehicle count as zero
	 * @throws InvalidInputException
	 */
	@Test
	public void testVehicleIdentifierForInvalidScenario() throws InvalidInputException{
		File file = new File("src/main/resources/invalidScenario.xml");
		Response actualResponse = vehicleIdentifier.vehicleIdentifier(file);
		assertEquals(0, actualResponse.getBicyle());
		assertEquals(0, actualResponse.getBigwheel());
		assertEquals(0, actualResponse.getCar());
		assertEquals(0, actualResponse.getHangGlider());
		assertEquals(0, actualResponse.getMotorCyle());
	}
	
	/** 
	 * @method testVehicleIdentifier for an invalid xml file
	 * @expected Response should be set with vehicle count as zero
	 * @throws InvalidInputException
	 */
	@Test(expected = InvalidInputException.class)
	public void testVehicleIdentifierForExceptionScenario() throws InvalidInputException{
		File file = new File("src/main/resources/exceptionScenario.xml");
		vehicleIdentifier.vehicleIdentifier(file);
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
		VehicleInfo vehInfo5 = new VehicleInfo("vehicle 2","Bicycle");
		vehInfoList.add(vehInfo5);
		expectedResponse.setVehicleInfo(vehInfoList);
		return expectedResponse;
	}
	
	/**
	 * This method populates Response Object for Vehicle type Big Wheel
	 * @return Response
	 */
	private Response populateResponseForBigWheel() {
		Response expectedResponse = new Response();
		expectedResponse.setBicyle(0);
		expectedResponse.setBigwheel(1);
		expectedResponse.setCar(0);
		expectedResponse.setHangGlider(0);
		expectedResponse.setMotorCyle(0);
		List<VehicleInfo> vehInfoList = new ArrayList<VehicleInfo>();
		VehicleInfo vehInfo1 = new VehicleInfo("vehicle 1","Big Wheel");
		vehInfoList.add(vehInfo1);
		expectedResponse.setVehicleInfo(vehInfoList);
		return expectedResponse;
	}
	
	/**
	 * This method populates Response Object for Vehicle type Bicycle
	 * @return Response
	 */
	private Response populateResponseForBicycle() {
		Response expectedResponse = new Response();
		expectedResponse.setBicyle(1);
		expectedResponse.setBigwheel(0);
		expectedResponse.setCar(0);
		expectedResponse.setHangGlider(0);
		expectedResponse.setMotorCyle(0);
		List<VehicleInfo> vehInfoList = new ArrayList<VehicleInfo>();
		VehicleInfo vehInfo1 = new VehicleInfo("vehicle 2","Bicycle");
		vehInfoList.add(vehInfo1);
		expectedResponse.setVehicleInfo(vehInfoList);
		return expectedResponse;
	}
	
	/**
	 * This method populates Response Object for Vehicle type MotorCycle
	 * @return Response
	 */
	private Response populateResponseForMotorCycle() {
		Response expectedResponse = new Response();
		expectedResponse.setBicyle(0);
		expectedResponse.setBigwheel(0);
		expectedResponse.setCar(0);
		expectedResponse.setHangGlider(0);
		expectedResponse.setMotorCyle(1);
		List<VehicleInfo> vehInfoList = new ArrayList<VehicleInfo>();
		VehicleInfo vehInfo1 = new VehicleInfo("vehicle 3","Motorcycle");
		vehInfoList.add(vehInfo1);
		expectedResponse.setVehicleInfo(vehInfoList);
		return expectedResponse;
	}
	
	/**
	 * This method populates Response Object for Vehicle type Hang Glider 
	 * @return Response
	 */
	private Response populateResponseForHangGlider() {
		Response expectedResponse = new Response();
		expectedResponse.setBicyle(0);
		expectedResponse.setBigwheel(0);
		expectedResponse.setCar(0);
		expectedResponse.setHangGlider(1);
		expectedResponse.setMotorCyle(0);
		List<VehicleInfo> vehInfoList = new ArrayList<VehicleInfo>();
		VehicleInfo vehInfo1 = new VehicleInfo("vehicle 4","Hang Glider");
		vehInfoList.add(vehInfo1);
		expectedResponse.setVehicleInfo(vehInfoList);
		return expectedResponse;
	}
	
	/**
	 * This method populates Response Object for Vehicle type Car 
	 * @return Response
	 */
	private Response populateResponseForCar() {
		Response expectedResponse = new Response();
		expectedResponse.setBicyle(0);
		expectedResponse.setBigwheel(0);
		expectedResponse.setCar(1);
		expectedResponse.setHangGlider(0);
		expectedResponse.setMotorCyle(0);
		List<VehicleInfo> vehInfoList = new ArrayList<VehicleInfo>();
		VehicleInfo vehInfo1 = new VehicleInfo("vehicle 5","Car");
		vehInfoList.add(vehInfo1);
		expectedResponse.setVehicleInfo(vehInfoList);
		return expectedResponse;
	}
}
