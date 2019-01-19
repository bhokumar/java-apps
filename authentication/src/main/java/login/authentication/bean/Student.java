package login.authentication.bean;

public class Student implements School {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String studentName;
	private String department;
	public Student() {
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public Student(String studentName, String department) {
		super();
		this.studentName = studentName;
		this.department = department;
	}
	

}
