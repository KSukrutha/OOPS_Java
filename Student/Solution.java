package sdbms;
// MAIN CLASS
import java.util.Scanner;
import CustomException.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {

		System.out.println("Welcome to Student Database");
		System.out.println("============================");	

		Scanner s = new Scanner(System.in);

		//UpCasting to achieve Abstraction 
		StudentManagementSystem sms= new StudentManagementSystemImpl();

		//infinite loop
		while (true) {

			//Menu Driven Program 
			System.out.println(" 1:Add Student \n 2:Display Student\n 3:Display All Student \n 4:Remove Student \n 5:Remove All Student\n"
					+ " 6:Update Student \n 7:Count Student \n 8:Sort Student \n 9:Find Student With Highest Marks \n"
					+ " 10:Find Student With Lowest Marks \n 11:Exit");
			System.out.println("Please enter your choice ");
			int choice = s.nextInt();

			switch(choice) {
			case 1:
				sms.addStudent();
				break;
			case 2:
				sms.displayStudent();
				break;
			case 3:
				sms.displayAllStudent();
				break;
			case 4:
				sms.removeStudent();
				break;
			case 5:
				sms.removeAllStudent();
				break;
			case 6:
				sms.updateStudent();
				break;
			case 7:
				sms.countStudent();
				break;
			case 8:
				sms.sortStudent();
				break;
			case 9:
				sms.findStudentWithHighestMarks();
				break;
			case 10:
				sms.findStudentWithLowestMarks();
				break;
			case 11:
				System.out.println(" Thank you!!!");
				System.exit(0);
			default:
				try{
					//String message="Invalid Choice;
					//throw new InvalidChoiceException(message);
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}//end of switch
			System.out.println("***---===---***---===---***---===---***");
		}//end of while loop
	}// end of main()
}// end of class
