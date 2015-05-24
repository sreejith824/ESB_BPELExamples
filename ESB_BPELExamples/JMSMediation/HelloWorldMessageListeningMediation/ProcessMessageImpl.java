
import com.ibm.websphere.sca.ServiceManager;

public class ProcessMessageImpl {
	/**
	 * Default constructor.
	 */
	public ProcessMessageImpl() {
		super();
	}

	/**
	 * Return a reference to the component service instance for this implementation
	 * class.  This method should be used when passing this service to a partner reference
	 * or if you want to invoke this component service asynchronously.    
	 *
	 * @generated (com.ibm.wbit.java)
	 */
	@SuppressWarnings("unused")
	private Object getMyService() {
		return (Object) ServiceManager.INSTANCE.locateService("self");
	}

	/**
	 * Method generated to support implementation of operation "processMessage" defined for WSDL port type 
	 * named "ProcessMessageInterface".
	 * 
	 * Please refer to the WSDL Definition for more information 
	 * on the type of input, output and fault(s).
	 */
	public String processMessage(String input1) {
		System.out.println("Processing message inside ProcessMessageImpl");
		String output = " Hello!!!  " + input1;
		System.out.println(output);
		return output;
	}

}