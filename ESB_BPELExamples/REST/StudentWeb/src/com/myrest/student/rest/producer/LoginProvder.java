package com.myrest.student.rest.producer;

import java.util.Collection;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
public class LoginProvder {

	@Context
	private SecurityContext securityContext;
	
	@Context
	HttpServletResponse	 response;
	
	@Produces
	@LoginQualifier
	public String validateUser(InjectionPoint injectionPoint) {
		String userValidity = "Failure";
		if (securityContext.getUserPrincipal() != null) {
			userValidity = "Success";
		} 
		
		Collection<String> responseHeaders =  response.getHeaderNames();
		System.out.println("--------------------------");
		for (String responseHeader : responseHeaders) {
			
			System.out.println(responseHeader + " : " + ((HttpServletResponse) response).getHeader(responseHeader));
		}
		System.out.println("--------------------------");
		return userValidity;
	}
}
