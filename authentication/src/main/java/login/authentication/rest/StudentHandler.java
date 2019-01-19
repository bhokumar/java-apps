package login.authentication.rest;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import login.authentication.bean.Student;
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class StudentHandler {
	@GET
	@Path("student/{id}")
	public Student getStudent(@PathParam("id")final int id){
		return new Student("Bijendra", "CSE");
		
	}
	
	@GET
	@Path("student")
	@Secured
	public List<Student> getStudents(){
		List<Student> students = new ArrayList<>();
		students.add(new Student("Bijendra", "CSE"));
		students.add(new Student("Bhoopendra", "CSE"));
		return students;
		
	}
	
}
