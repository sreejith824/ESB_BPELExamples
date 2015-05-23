package co.za.metropolitan.student.ejb;

import javax.ejb.Stateless;

import co.za.metropolitan.student.dto.StudentDTO;

/**
 * Session Bean implementation class StudentBean
 */
@Stateless
public class StudentBean implements StudentBeanLocal {
	
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

	public StudentDTO getStudent(String id) {
		StudentDTO studentDTO = new StudentDTO();
		//long id = (long) Math.random();
		long idNumber = Long.valueOf(id);
		studentDTO.setId(idNumber);
		studentDTO.setAge(23);
		System.out.println(studentDTO);
		System.out.println("Inside GetStudent!!!");
		
		StudentBeanUtil studentBeanUtil = new StudentBeanUtil();
		String name = studentBeanUtil.getName("Name");
		
		studentDTO.setName(name);;
		
		return studentDTO;
	}
}
