package com;

public class BankImpl implements Bank {
	int balance;

	BankImpl(int balance){
		this.balance = balance;
	}
	@Override 
	public void deposit(int amount) {
		System.out.println("depositing Rs."+ amount);
		balance= balance + amount;// balance += amount;
		System.out.println("Amount Sucessfully Depositted!!");
	}

	@Override 
	public void withdraw(int amount) {
		if(amount<=balance) {
			System.out.println("withdrawing Rs"+ amount);
			balance= balance - amount;// balance -= amount;
			System.out.println("Amount Sucessfully Withdrawn!!");
		}else {
			try {
				throw new InsufficientBalanceException("Insufficient Balance ");
			}
			catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override 
	public void checkBalance() {
		System.out.println("Available Balavance Rs."+balance);
	}

}
