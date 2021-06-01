package maven_student_project_jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class StudentDAO {
	Scanner sc = new Scanner(System.in);
	GetConnection obj = new GetConnection();
	Student student = new Student();

	public StudentDAO() {
		System.out.println("Welcome to JAVA SDET Class");
	}

	// Create a table::student data table
	public void createStudentData() {
		String queries = "CREATE TABLE IF NOT EXISTS student_data(student_id int NOT NULL , student_name varchar(100), student_lastname VARCHAR(100), student_emailaddress VARCHAR(100), student_phonenum VARCHAR(10), student_ssn VARCHAR(9), student_gpa float, PRIMARY KEY (student_id))";
		try {
			Connection conn = obj.get_Connection();
			PreparedStatement pts = conn.prepareStatement(queries);
			pts.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Add Student --> ADD
	public void addStudent(Student newStudent) {
		Statement st = null;
		try {
			Connection conn = obj.get_Connection();
			String queries = "INSERT INTO `student_data` (`student_id`,`student_name`, `student_lastname`, `student_emailaddress`, `student_phonenum`, `student_ssn`, `student_gpa`) VALUES "
					+ "('" + newStudent.getStudentId() + "', '" + newStudent.getName() + "', '"
					+ newStudent.getLastName() + "', '" + newStudent.getEmailAddress() + "', '"
					+ newStudent.getPhoneNumber() + "', '" + newStudent.getSsn() + "', '" + newStudent.getGpa() + "')";

			st = conn.createStatement();
			st.executeUpdate(queries);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// CREATE New Student --> ADD
	public void addNewStudent(Student newStudent) {
		Statement st = null;
		try {
			Connection conn = obj.get_Connection();
			String queries = "INSERT INTO `student_data` (`student_id`,`student_name`, `student_lastname`, `student_emailaddress`, `student_phonenum`, `student_ssn`, `student_gpa`) VALUES "
					+ "('" + newStudent.getStudentId() + "', '" + newStudent.getName() + "', '"
					+ newStudent.getLastName() + "', '" + newStudent.getEmailAddress() + "', '"
					+ newStudent.getPhoneNumber() + "', '" + newStudent.getSsn() + "', '" + newStudent.getGpa() + "')";

			st = conn.createStatement();
			st.executeUpdate(queries);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println();
	}

	// Remove Student --> ADD
	public void removeStudent(int removeId) {

		try {
			Connection conn = obj.get_Connection();
			String query = ("DELETE from student_data where student_id = " + removeId);
			PreparedStatement pst = conn.prepareStatement(query);
			int result = pst.executeUpdate();
			if (result > 0) {
				System.out.println("Record is deleted");
			} else {
				System.out.println("The id::" + removeId + "is not in the database");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// Update Student --> ADD
	public void updateStudent(int updateId) {

		try {
			Connection conne = obj.get_Connection();
			System.out.println("Enter update student name");
			// sc.nextLine();
			String updateName = sc.nextLine();

			System.out.println("Enter update student last name");
			String updateLastName = sc.nextLine();

			System.out.println("Enter update student email address");
			String updateEmailAddress = sc.nextLine();

			System.out.println("Enter update student phone number");
			int updatePhoneNum = sc.nextInt();

			System.out.println("Enter update student ssn");
			int updateSsn = sc.nextInt();

			System.out.println("Enter update student gpa");
			float updategpa = sc.nextFloat();

			String queries = ("UPDATE student_data set student_name=? , student_lastname =? , student_emailaddress=? , student_phonenum =? , student_gpa=? , student_ssn=? where student_id =?");
			PreparedStatement pst = conne.prepareStatement(queries);
			pst.setString(1, updateName);
			pst.setString(2, updateLastName);
			pst.setString(3, updateEmailAddress);
			pst.setInt(4, updatePhoneNum);
			pst.setInt(5, updateSsn);
			pst.setFloat(6, updategpa);
			pst.setInt(7, updateId);

			int result = pst.executeUpdate();
			if (result > 0) {
				System.out.println("The record has been updated");
			} else {
				System.out.println("The record with id::" + updateId + "doesn't exist");
			}
			pst.close();
			conne.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	// READ Students
	public void displayStudents() throws ClassNotFoundException {

		try {
			Connection con = obj.get_Connection();
			PreparedStatement pst = con.prepareStatement("SELECT * FROM student_data");

			ResultSet rset = pst.executeQuery();
			ResultSetMetaData md = rset.getMetaData();

			for (int i = 1; i <= md.getColumnCount(); i++) {
				System.out.println(md.getColumnName(i) + "\t");
			}

			System.out.println("\n==============================================================");

			while (rset.next()) {
				for (int i = 1; i <= md.getColumnCount(); ++i) {
					System.out.println(rset.getString(i));
				}

				System.out.println();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
