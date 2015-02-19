
import com.ibm.websphere.sca.ServiceManager;

public class HelloWorldRefImpl {
	/**
	 * Default constructor.
	 */
	public HelloWorldRefImpl() {
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
	public String helloWorld() {
		return "HelloWorld!!!!";
	}

}