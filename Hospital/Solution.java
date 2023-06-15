package hdbms;
import java.util.Scanner;
import CustomException.InvalidChoiceException;

public class Solution {
	public static void main(String[] args) {
		System.out.println("Welcome to KANAKA Group of Hospitals");
		System.out.println("====================================");
		Scanner s= new Scanner(System.in);
		HospitalManagmentSystem HMS =new HospitalManagmentSystemImpl();
		while(true) {
			System.out.println("1.Add Patient\n2.Display Patient\n3.Remove Patient\n4.Remove All Patient"
					+ "\n5.Display All Patient\n6.Update Patients\n7.No Of Patients\n8.Sort Patients"
					+ "\n9.Exit");
			System.out.println("Enter your choice");
			int choice =s.nextInt();
			switch(choice) {
			case 1:
				HMS.addPatient();
				break;
			case 2:
				HMS.displayPatient();
				break;
			case 3:
				HMS.removePatient();
				break;
			case 4:
				HMS.removeAllPatient();
				break;
			case 5:
				HMS.displayAllPatient();
				break;
			case 6:
				HMS.updatePatient();
				break;
			case 7:
				HMS.NoOfPatients();
				break;
			case 8:
				HMS.sortPatients();
				break;
			case 9:
				System.out.println("Thnak you....Please visit again");
			default:
				try {
					throw new InvalidChoiceException("Invalid Choice");
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
}
