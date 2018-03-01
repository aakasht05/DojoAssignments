package com.aakashtripathi.bankaccount;

public class BankAccountTest {

	public static void main(String[] args) {
		BankAccount account1 = new BankAccount();
		BankAccount account2 = new BankAccount();
		BankAccount account3 = new BankAccount();

		System.out.println("Account1 Number:" + account1.getAccountNumber());
		account1.deposit(100, "checking");
		account1.deposit(200, "savings");
		System.out.println();
		account1.withdraw(50, "checking");
		System.out.println();
		account1.withdraw(300, "savings");
		System.out.println();
		System.out.println("The number of accounts: " + BankAccount.numberOfAccounts);

	}
}
