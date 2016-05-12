package pt.upa.broker.ws.cli;

import static javax.xml.ws.BindingProvider.ENDPOINT_ADDRESS_PROPERTY;

import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;

//import pt.ulisboa.tecnico.sdis.ws.uddi.UDDINaming;

// classes generated from WSDL
import pt.upa.broker.ws.BrokerPortType;
import pt.upa.broker.ws.BrokerService;
import pt.upa.broker.ws.TransportView;

public class BrokerClient {
	
	private BrokerPortType port;
	
	private String name;
	
	private Map<String, Object> requestContext;
	
	public BrokerClient(String endpointAddress) {
	
		System.out.println(endpointAddress);
		if (endpointAddress == null) {
			System.out.println("Not found!");
			return;
		} else {
			System.out.printf("Found %s%n", endpointAddress);
		}
		
		name = "UpaBroker" + endpointAddress.charAt(20);
		
		
		System.out.println("Creating stub ...");
		BrokerService service = new BrokerService();
		port = service.getBrokerPort();
	
		//System.out.println("Setting endpoint address ...");
		BindingProvider bindingProvider = (BindingProvider) port;
		requestContext = bindingProvider.getRequestContext();
		requestContext.put(ENDPOINT_ADDRESS_PROPERTY, endpointAddress);
	}
	
	public String ping(String message){
		return port.ping(message);	
	}
	
	public void receiveUpdate(TransportView arg1,String arg2, int arg3) {
		port.receiveUpdate(arg1, arg2, arg3);
	}
	
	public static void main(String[] args) throws Exception {
		
	}
	

}

