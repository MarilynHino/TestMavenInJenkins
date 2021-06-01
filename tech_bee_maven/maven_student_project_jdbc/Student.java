package maven_student_project_jdbc;

public class Student {
	private String name;
	private String lastName;
	private long phoneNumber;
	private int ssn;
	private float gpa;
	private int studentId;
	private String emailAddress;

	public Student() {
	}

	public Student(String name, String lastName, int phoneNumber, int ssn, float gpa, int studentId,
			String emailAddress) {

		this.name = name;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.ssn = ssn;
		this.gpa = gpa;
		this.studentId = studentId;
		this.emailAddress = emailAddress;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public int getSsn() {
		return ssn;
	}

	public void setSsn(int ssn) {
		// boolean valid = true;
		// if (valid) {
		this.ssn = ssn;
		// } else {
		// System.out.println("Try a valid number");
		// }
	}

	public float getGpa() {
		return gpa;
	}

	public void setGpa(float gpa) {
		this.gpa = gpa;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

}
