package com.workscape.vehicleidentifier;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.workspace.vehicleidentifier.model.Response;
import com.workspace.vehicleidentifier.model.Vehicles;

/**
 * @author Samiksha Dhomne
 *
 */
public final class JAXBUtility {
	private JAXBUtility(){};

	/**
	 * This method converts an XML into Vehicles Object
	 * @return Vehicles
	 * @throws JAXBException
	 */
	public static Vehicles unMarshal(File file) throws JAXBException {
			
			JAXBContext jaxbContext = JAXBContext.newInstance(Vehicles.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			return (Vehicles) jaxbUnmarshaller.unmarshal(file);
	}
	
	/**
	 * This method converts Response Object into an XML
	 * @return Vehicles
	 * @throws JAXBException
	 */
	public static void marshall(Response responseObj) throws JAXBException{
		JAXBContext contextObj = JAXBContext.newInstance(Response.class);  
        
        Marshaller marshallerObj = contextObj.createMarshaller();  
        marshallerObj.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);  
        marshallerObj.marshal(responseObj, System.out);
        marshallerObj.marshal(responseObj, new File("response.xml"));
          
		
	}

}
