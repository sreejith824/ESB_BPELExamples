package co.za.metropolitan.student.ejb;

import javax.naming.InitialContext;
import javax.naming.NamingException;

public class StudentBeanUtil {
	
	StudentSingletonLocal studentSingletonLocal;

	public StudentBeanUtil() {
		InitialContext initialContext = null;
		try {
			initialContext = new InitialContext();
			studentSingletonLocal = (StudentSingletonLocal) initialContext.lookup("java:module/StudentSingletonBean");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public String getName(String name) {
		String returnName = "Hello " + studentSingletonLocal.getProperty(name);
		return returnName;
	}
}
