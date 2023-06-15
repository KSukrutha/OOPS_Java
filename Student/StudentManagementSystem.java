package sdbms;
//INTERFACE 
public interface StudentManagementSystem {

	void addStudent();
	void displayStudent();
	void displayAllStudent();
	void removeStudent();
	void removeAllStudent();
	void updateStudent();
	void countStudent();
	void sortStudent();
	void findStudentWithHighestMarks();
	void findStudentWithLowestMarks();

}

//all methods inside interface are automatically public and abstract 