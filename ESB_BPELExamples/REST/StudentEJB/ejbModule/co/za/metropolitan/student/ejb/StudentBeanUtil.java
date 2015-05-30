package co.za.metropolitan.student.ejb;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import co.za.metropolitan.student.threadlocal.ApplicationSecurityContext;

@Singleton
public class StudentBeanUtil {
	
	StudentSingletonLocal studentSingletonLocal;

	@PostConstruct
	public void initialize() {
		InitialContext initialContext = null;
		try {
			initialContext = new InitialContext();
			studentSingletonLocal = (StudentSingletonLocal) initialContext.lookup("java:module/StudentSingletonBean");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public StudentBeanUtil() {
		
	}

	public String getName(String name) {
		
		String securityToken = ApplicationSecurityContext.getSecurityToken();
		System.out.println("Security Token : " + securityToken);
		
		String returnName = "Hello " + studentSingletonLocal.getProperty(name);
		return returnName;
	}
}
