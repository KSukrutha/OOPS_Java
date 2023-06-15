package com;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {

		System.out.println("Welcome to Kanaka Bank");
		System.out.println("=======================");

		Scanner s = new Scanner(System.in);
		System.out.println("please enter your Balance");
		int balance = s.nextInt();
		Bank b= new BankImpl(balance);
		while(true) {
			System.out.println("1:Deposite Amount\n 2:Withdraw Amount\n3:Check Balance\n 4:Exit");
			System.out.println("==============================");
			System.out.println("Please enter your choice ");
			int choice = s.nextInt();

			int amount = 0;
			if(choice >=1 && choice<=2 ) {
				System.out.println("Please entyer your amount");
				amount = s.nextInt();			
			}

			switch(choice) {
			case 1 :
				b.deposit(amount);
				break;
			
			case 2 :
				b.withdraw(amount);
				break;
				
			case 3:
				b.checkBalance();
				break;
			
			case 4:
			System.out.println("Thank you ....please visit again");
			System.exit(0);
			
			default:
				System.out.println("Invalid choice");
				
			}
		}
		
	}
}
