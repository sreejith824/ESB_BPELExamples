package com.myrest.login.rest.resource;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import co.za.metropolitan.login.LoginManagerLocal;
import co.za.metropolitan.login.dto.LoginDTO;

@Path(value="/login")
public class AuthenticationResource {

	@Inject
	LoginManagerLocal loginManagerLocal; 

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response createStudent(@Context UriInfo uriInfo,
			LoginDTO loginDTO) {
		return Response.ok(loginManagerLocal.login(loginDTO)).build();
	}
	
	
}
