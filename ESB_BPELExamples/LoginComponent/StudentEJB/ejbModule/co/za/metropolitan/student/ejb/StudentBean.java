package co.za.metropolitan.student.ejb;

import javax.ejb.Stateless;

import co.za.metropolitan.student.dto.StudentDTO;

/**
 * Session Bean implementation class StudentBean
 */
@Stateless
public class StudentBean implements StudentBeanRemote {

	/**
	 * Default constructor.
	 */
	public StudentBean() {
	}

	public long addStudent(StudentDTO studentDTO) {
		long id = (long) Math.random();
		studentDTO.setId(id);
		return id;
	}

	public StudentDTO getStudent() {
		StudentDTO studentDTO = new StudentDTO();
		long id = (long) Math.random();
		studentDTO.setId(id);
		studentDTO.setAge(23);
		System.out.println(studentDTO);
		System.out.println("Inside GetStudent!!!");
		return studentDTO;
	}
}