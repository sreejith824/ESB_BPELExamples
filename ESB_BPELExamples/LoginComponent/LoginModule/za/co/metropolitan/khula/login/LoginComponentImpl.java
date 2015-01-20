package za.co.metropolitan.khula.login;

import com.ibm.websphere.sca.ServiceManager;

public class LoginComponentImpl {
	/**
	 * Default constructor.
	 */
	public LoginComponentImpl() {
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
	
	public String login(String userName, String password){
		System.out.println(userName + " : "+ password);
		return "Success";
	}

}