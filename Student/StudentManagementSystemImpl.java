package sdbms;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

import CustomException.InvalidChoiceException;
import CustomException.StudentNotFoundException;
import customsorting.SortStudentByAge;
import customsorting.SortStudentById;
import customsorting.SortStudentByMarks;
import customsorting.SortStudentByName;

//IMPLEMENTATION CLASS
public class StudentManagementSystemImpl implements  StudentManagementSystem {
	Scanner scan = new Scanner(System.in);
	//key-> Student id  & value-> Student Object;
	Map<String,Student> db=new LinkedHashMap<String,Student>();

	@Override
	public void addStudent()
	{
		//Accepting age
		System.out.println("Please enter the age of the student");
		int age= scan.nextInt();
		//Accepting name
		System.out.println("Please enter the name of the student");
		String name = scan.next();
		//Accepting marks
		System.out.println("Please enter the marks of the student");
		int marks= scan.nextInt();

		//Creating a student instance
		Student s1= new Student(age,name,marks);

		//db-> map-> put()-> id, reference variable 
		db.put(s1.getId(), s1);
		System.out.println("Student record inserted into the database successfully");
		System.out.println("Your Student Id:"+ s1.getId());

	}

	@Override
	public void displayStudent()
	{
		//Accepting student id ->jsp101,Jsp101,JSP101
		Scanner scan = new Scanner(System.in);
		System.out.println("Please enter the Student Id");

		String id = scan.next();//String id = scan.next().toUpperCase();
		id=id.toUpperCase();
		//checking if the id is present or not in the database (id==key)
		if(db.containsKey(id)){
			System.out.println("Student Record Found \nThe Record Are As Follows:");
			//get the relevant student object
			//******IPORTANT STEP ACCORDING TO ME****
			Student std= db.get(id);//***getting student object based on id***
			System.out.println("Id :"+ std.getId());
			System.out.println("Name :"+ std.getName());
			System.out.println("Age :"+ std.getAge());
			System.out.println("Marks :"+ std.getMarks());
			//printing reference variable as toString( is overridden 
			//System.out.println(std);
		}
		else {
			try {
				throw new StudentNotFoundException ("Student with Id"+ id+ "not found");
			}
			catch(StudentNotFoundException s)
			{
				System.out.println(s.getMessage());
			}
		}

	}
	@Override
	public void displayAllStudent()
	{//Checking if database is  not empty 
		if(!db.isEmpty()) {
			Set<String> keys= db.keySet();//JSP101 JSP102 JSP103
			for(String key:keys) {
				System.out.println(db.get(key));
				//Student stud= db.get(key)--- getting student object
				//System.out.println(stud);--- to string method is overridden
			}
		}
		else {
			try {
				throw  new StudentNotFoundException("No Student Records To Display!");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}

	}
	@Override
	public void removeStudent()
	{
		Scanner scan = new Scanner(System.in);
		String id= scan.next();// taking user input for the id
		id=id.toUpperCase();   // converting the inputing into upper case 
		if(db.containsKey(id)) {
			System.out.println("Student Record Found \nRemoving the Record from the Database:");
			System.out.println(db.get(id));//printing student object 
			db.remove(id);                 // deleting the student object
			System.out.println("Student record delected successfulyy");
		}
		else {
			try {
				throw new StudentNotFoundException("Studen with ID"+ id+" is not found in the database");
			}
			catch(StudentNotFoundException s) {
				System.out.println(s.getMessage());
			}
		}

	}
	@Override
	public void removeAllStudent() 
	{//checking if the database is empty or not 
		if(!db.isEmpty()) {
			System.out.println("No of Student records present in the Database: "+db.size());
			db.clear();
		}
		else {
			try {
				throw new StudentNotFoundException("No Student Records To Delete");
			} 
			catch(Exception e) {
				System.out.println(e.getMessage());
			}

		}
	}
	@Override
	public void updateStudent() 
	{ 
	Scanner s = new Scanner(System.in);
	System.out.println("please enter the id");
	String id= s.next();
	id=id.toUpperCase();
	if(db.containsKey(id)) {
		System.out.println("Student record is found");
		Student std = db.get(id);
		System.out.println("1:Update Age\n2:Update Name\n3:Update Marks\nEnter Choice");
		int choice = scan.nextInt();
		switch(choice) {
		case 1:
			System.out.println("please enter the age:");
			int age=s.nextInt();
			std.setAge(age);
			System.out.println("Age successfully updated");
			System.out.println("============================");	
			break;
		case 2:
			System.out.println("please enter the name:");
			String name=s.next();
			std.setName(name);
			System.out.println("Name successfully updated");
			System.out.println("============================");	
			break;
		case 3:
			System.out.println("please enter the marks:");
			int marks=s.nextInt();
			std.setMarks(marks);
			System.out.println("Marks successfully updated");
			System.out.println("============================");	
			break;
		default:
			try {
				throw new InvalidChoiceException("Invalid choice,please enter a valid choice");
			}catch(InvalidChoiceException e) {
				System.out.println(e.getMessage());
			}
		}
	}else {
		try {
			throw new StudentNotFoundException("Student not found");

		}catch(StudentNotFoundException e) {
			System.out.println(e.getMessage());
		}

	}
	}
	@Override
	public void countStudent()
	{
		System.out.println("the number of students present in the database are "+ db.size());
	}
	@Override
	public void sortStudent() {
		/**
		 * we cannot sort Map based on values ,therefore we are getting the values from map and storing
		 *  it inside a list so that we can sort list ->Collect.sort(list,sorting logic);
		 */
		//(/*  */) -> this is multi line comment - the color is green  
		//(/** ) this is know was documentation and the color of the comment turns blue

		// refernec of list and object of arraylist storing student objects
		List<Student> list = new ArrayList<Student>();

		//Converting Map into Set ,which stores keys(Id)
		Set<String> keys=db.keySet();

		//Traversing Keys(Id)
		for(String key:keys) {
			//getting vale (student object) and adding it into the list
			list.add(db.get(key));
		}
		System.out.println("1:Sort Student By Id\n2:Sort Student By Age\n3:Sort Student By Name\n4:Sort Student By Marks");
		System.out.println("Please enter your choice");
		int choice = scan.nextInt();

		switch(choice) {
		case 1:
			System.out.println("Student sorted By Id:");
			Collections.sort(list,new SortStudentById());
			for(Student s: list) {
				System.out.println(s);
				System.out.println("============================");	
			}
		case 2:
			System.out.println("Student sorted By Age:");
			Collections.sort(list,new SortStudentByAge());
			for(Student s: list) {
				System.out.println(s);
				System.out.println("============================");	
			}
		case 3:
			System.out.println("Student sorted By Name:");
			Collections.sort(list,new SortStudentByName());
			for(Student s: list) {
				System.out.println(s);
				System.out.println("============================");	
			}
		case 4:
			System.out.println("Student sorted By Marks:");
			Collections.sort(list,new SortStudentByMarks());
			for(Student s: list) {
				System.out.println(s);
				System.out.println("============================");	
			}
		default:
			try {
				throw new InvalidChoiceException("Invalid Choice..Please make a valid Choice");
			}catch(InvalidChoiceException e) {
				System.out.println(e.getMessage());
			}

		}
	}
	@Override
	public void findStudentWithHighestMarks()
	{List<Student> list = new ArrayList<Student>();
	Set<String> keys=db.keySet();
	for(String key:keys) {
		list.add(db.get(key));
	}
	Collections.sort(list,new SortStudentByMarks());
	System.out.println("Student with Highest marks is:");
	System.out.println(list.get(list.size()-1));
	System.out.println("============================");	
	}
	@Override
	public void findStudentWithLowestMarks()
	{
		List<Student> list = new ArrayList<Student>();
		Set<String> keys=db.keySet();
		for(String key:keys) {
			list.add(db.get(key));
		}
		Collections.sort(list,new SortStudentByMarks());
		System.out.println("Student with lowesh marks is:");
		System.out.println(list.get(0));
		System.out.println("============================");	
	}
}
