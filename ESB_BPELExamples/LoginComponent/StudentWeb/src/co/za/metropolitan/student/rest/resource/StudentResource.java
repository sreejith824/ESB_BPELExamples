package co.za.metropolitan.student.rest.resource;

import java.net.URI;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import co.za.metropolitan.student.dto.StudentDTO;
import co.za.metropolitan.student.ejb.StudentBeanRemote;

@Path(value="/students")
@Stateless
public class StudentResource {

	@EJB
	StudentBeanRemote studentBeanRemote;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response createStudent(@Context UriInfo uriInfo,
			StudentDTO studentDTO) {
		long studentID = studentBeanRemote.addStudent(studentDTO);
		URI uri = uriInfo.getBaseUriBuilder().path(StudentResource.class)
				.path(String.valueOf(studentID)).build();
		return Response.created(uri).build();

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getStudent() {
		StudentDTO studentDTO = studentBeanRemote.getStudent();
		return Response.ok(studentDTO).build();
	}
}