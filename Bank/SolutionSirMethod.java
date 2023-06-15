package com;

import java.util.Scanner;

public class SolutionSirMethod {
	public static void main(String[] args) {

		System.out.println("Welcome to Kanaka Bank");
		System.out.println("=======================");

		Scanner s = new Scanner(System.in);
		Bank b= new BankImpl(75000);
		while(true) {
			System.out.println(" 1:Deposite Amount\n 2:Withdraw Amount\n 3:Check Balance\n 4:Exit");
			System.out.println("==============================");
			System.out.println("Please enter your choice ");
			int choice = s.nextInt();
			
			switch(choice) {
			case 1 :
				System.out.println("Enter the amount to be depositted ");
				int amountToDeposit =s.nextInt();
				b.deposit(amountToDeposit);
				break;
			
			case 2 :
				System.out.println("Enter the amount to be withdrawn ");
				int amountToWithdrawn =s.nextInt();
				b.withdraw(amountToWithdrawn);
				break;
				
				
			case 3:
				b.checkBalance();
				break;
			
			case 4:
			System.out.println("Thank you ....please visit again");
			System.exit(0);
			
			default:
				try {
					throw new InvalidChoiceException ("Invalid Choice....Dabba Fellow Choice another Option");
				}
				catch(Exception e){
					System.out.println(e.getMessage());
				}
				
			}
		}
		
	}
}
