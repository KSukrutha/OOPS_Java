package hdbms;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import CustomException.PatientNotFoundException;
import CustomException.StudentNotFoundException;
import CustomException.InvalidChoiceException;
import customsorting.SortPatientByAge;
import customsorting.SortPatientById;
import customsorting.SortPatientByTotalBill;
import customsorting.SortPatientByName;


public class HospitalManagmentSystemImpl implements HospitalManagmentSystem{

	Scanner s = new Scanner(System.in);
	Map<String,Patient> m=new LinkedHashMap<String,Patient>();
	public  void addPatient() {

		System.out.println("Please enter the name of the Patient");
		String name=s.next();

		System.out.println("Please enter the age of the Patient");
		int age=s.nextInt();

		System.out.println("Please enter the Total Bill Amount of the Patient");
		int totBil= s.nextInt();

		Patient p = new Patient(name,age,totBil);

		m.put(p.getId(),p);
		System.out.println("A new Patient Record has been inserted into the Database");
		System.out.println("Your Patient Id is: "+ p.getId());

	}
	public void displayPatient() {
		System.out.println("Please enter the patients id");
		String id=s.next();
		id=id.toUpperCase();
		if(m.containsKey(id)) {
			System.out.println(m.get(id));
		}
		else {
			try {
				throw new StudentNotFoundException("Patient with id:"+id+" Not Found");
			}
			catch(Exception s) {
				System.out.println(s.getMessage());
			}
		}
	}
	public void removePatient() {
		System.out.println("Please enter the patients id");
		String id=s.next();
		id=id.toUpperCase();
		if(m.containsKey(id)) {
			System.out.println(m.get(id));
			m.remove(id);
			System.out.println("The Patient Record has been Sucessfully Deleted ");
		}
		else {
			try {
				throw new PatientNotFoundException("Patient with id:"+id+" Not Found");
			}
			catch(Exception s) {
				System.out.println(s.getMessage());
			}
		}
	}
	public void removeAllPatient() {
		if(!m.isEmpty()) {
			m.clear();
			System.out.println("All the record have been Deleted");
		}else {
			try {
				throw new PatientNotFoundException("The Database is Empty");
			}
			catch(Exception s) {
				System.out.println(s.getMessage());
			}
		}
	}
	public  void displayAllPatient() {
		if(!m.isEmpty()) {
			Set<String>keys=m.keySet();
			for(String key:keys) {
				System.out.println("The Patients id is:"+ key+ m.get(key));
			}
		}

	}
	public  void updatePatient() {
		Scanner s = new Scanner(System.in);
		System.out.println("please enter the id");
		String id= s.next();
		id=id.toUpperCase();
		if(m.containsKey(id)) {
			System.out.println("Patient record is found");
			Patient p = m.get(id);
			System.out.println("1.Update Name\2.Update Age\3.Update Total Bill  Amount");
			int choice =s.nextInt();
			switch(choice) {
			case 1:
				System.out.println("Please enter the Name");
				String name=s.next();
				p.setName(name);
				System.out.println("Name has been Succesfully updated");
				System.out.println("==================================");

			case 2:
				System.out.println("Please enter the age");
				int age =s.nextInt();
				p.setAge(age);
				System.out.println("Age has successfully been Updated");
				System.out.println("==================================");

			case 3:
				System.out.println("Please enter the Additional Charges");
				int totBil=s.nextInt();
				p.setAge(totBil);
				System.out.println("Total Bill  has successfully been Updated");
				System.out.println("==================================");

			default:
				try {
					throw new InvalidChoiceException("Invalid choice...Make another choice");
				}catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
		}
	}
	public void NoOfPatients() {
		System.out.println("the number of patients in the database are "+m.size());
	}
	public void sortPatients() {
		List <Patient>list=new ArrayList<Patient>();
		Set <String> keys=m.keySet();
		for(String key:keys) {
			list.add(m.get(key));
		}
		System.out.println("1.Sort By Id\n2.Sort By Name\n3.Sort By Age\n4.Sort By Total Bill Amount");
		int choice = s.nextInt();
		switch(choice) {
		case 1:
			System.out.println("Sorting Patients By Id :");
			Collections.sort(list, new SortPatientById());
			for(Patient p:list) {
				System.out.println(p);
			}
		case 2:
			System.out.println("Sorting Patients By Name :");
			Collections.sort(list, new SortPatientByName());
			for(Patient p:list) {
				System.out.println(p);
			}
		case 3:
			System.out.println("Sorting Patients By Id :");
			Collections.sort(list,new SortPatientById());
			for(Patient p:list) {
				System.out.println(p);
			}

		case 4:
			System.out.println("Sorting Patients By Total Bill Amount :");
			Collections.sort(list,new SortPatientByTotalBill());
			for(Patient p:list) {
				System.out.println(p);
			}
		default:
			try {
				throw new InvalidChoiceException("Invalid choice...Make another choice");
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
			
		}
	}

}
