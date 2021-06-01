package maven_student_project_jdbc;

import java.sql.SQLException;
import java.util.Scanner;

public class UserFrontEnd {

	static int curStudents = 0;

	public static void main(String[] args) throws SQLException, ClassNotFoundException {

		StudentDAO thisClass = new StudentDAO();
		thisClass.createStudentData();

		Scanner sc = new Scanner(System.in);
		int choice;
		do {
			System.out.println("1.Add student.");
			System.out.println("2.Add new student.");
			System.out.println("3.Remove student.");
			System.out.println("4.Update student.");
			System.out.println("5.Display all student.");
			System.out.println("6.exit");
			System.out.println("Enter you choice");
			choice = sc.nextInt();
			sc.nextLine();

			switch (choice) {

			case 1:
				System.out.println("\nAdding students");
				System.out.println("Enter the size of the student. Dont exceed more than 10 students");
				int size = sc.nextInt();

				while (!(size > 0 && size + curStudents <= 10)) {

					System.out.println("Current Students are::" + curStudents);
					System.out.println("Out of range! Enter a number in the range of[1-" + (10 - curStudents) + "]");
					size = sc.nextInt();

				}
				curStudents = curStudents + size;

				for (int i = 0; i < size; i++) {
					Student student = new Student();
					System.out.print("Enter Student name:");
					sc.nextLine();
					String studentName = sc.nextLine();
					student.setName(studentName);

					System.out.print("Enter Student last name:");
					String studentLastName = sc.nextLine();
					student.setLastName(studentLastName);

					System.out.print("Enter Student email address:");
					String studentEmailAddress = sc.nextLine();
					student.setEmailAddress(studentEmailAddress);

					System.out.print("Enter Student Phone number:");
					long studentPhoneNum = sc.nextLong();
					student.setPhoneNumber(studentPhoneNum);

					System.out.print("Enter Student id:");
					int studentId = sc.nextInt();
					student.setStudentId(studentId);

					System.out.print("Enter Student ssn:");
					int studentSsn = sc.nextInt();
					student.setSsn(studentSsn);

					System.out.print("Enter Student gpa:");
					float studentGpa = sc.nextFloat();
					student.setGpa(studentGpa);

					thisClass.addStudent(student);

				} // END IF STSTEMENT
				System.out.println();
				break;

			case 2:
				System.out.println("\nAdding new students");

				System.out.println("How many new student you want to enter:");
				int updatSize = sc.nextInt();

				while (!(updatSize > 0 && updatSize + curStudents <= 10)) {
					System.out.println("Current Students are::" + curStudents);
					System.out.println("Out of range! Enter a number in the range of[1-" + (10 - curStudents) + "]");
					updatSize = sc.nextInt();
				}
				curStudents = curStudents + updatSize;

				for (int i = 0; i < updatSize; i++) {
					Student student = new Student();
					System.out.print("Enter Student name:");
					sc.nextLine();
					String newStudentName = sc.nextLine();
					student.setName(newStudentName);

					System.out.print("Enter Student last name:");
					String newStudentLastName = sc.nextLine();
					student.setLastName(newStudentLastName);

					System.out.print("Enter Student email address:");
					String newStudentEmailAddress = sc.nextLine();
					student.setEmailAddress(newStudentEmailAddress);

					System.out.print("Enter Student Phone number:");
					int newStudentPhoneNum = sc.nextInt();
					student.setPhoneNumber(newStudentPhoneNum);

					System.out.print("Enter Student id:");
					int newStudentId = sc.nextInt();
					student.setStudentId(newStudentId);

					System.out.print("Enter Student ssn:");
					int newStudentSsn = sc.nextInt();
					student.setSsn(newStudentSsn);

					System.out.print("Enter Student gpa:");
					float newStudentGpa = sc.nextFloat();
					student.setGpa(newStudentGpa);

					thisClass.addNewStudent(student);

				}

				break;

			case 3:
				System.out.println("\nRemoving students");
				System.out.println("Enter student id that you want to remove.");
				int removeId = sc.nextInt();
				thisClass.removeStudent(removeId);
				curStudents--;

				break;

			case 4:
				System.out.println("\nUpdating new students");
				System.out.println("Enter id to update sudent information");
				int updateId = sc.nextInt();
				thisClass.updateStudent(updateId);
				break;

			case 5:
				System.out.println("\nDisplaying all students");
				try {
					thisClass.displayStudents();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}
				break;

			default:
				if (choice != 6) {
					System.out.println("\nTry again!");
				}

			}

		} while (choice != 6);

		sc.close();
	}
}
