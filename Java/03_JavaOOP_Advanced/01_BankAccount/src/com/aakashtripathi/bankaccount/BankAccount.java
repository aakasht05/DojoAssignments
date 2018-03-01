package com.aakashtripathi.bankaccount;

import java.util.Random;

public class BankAccount {
	private String accountNumber;
	private double checkingBalance;
	private double savingsBalance;

	static int numberOfAccounts;
	static int totalMoney;

	public BankAccount() {
		accountNumber = generateAccountNumber();
		checkingBalance = 0.0;
		savingsBalance = 0.0;
		numberOfAccounts++;
	}

	private String generateAccountNumber() {
		Random rand = new Random();
		String randomAccountNumber = "";

		for (int i = 0; i < 10; i++) {
			randomAccountNumber += (rand.nextInt(((10 - 1) + 1)));
		}
		return randomAccountNumber;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public double getCheckingBalance() {
		return checkingBalance;
	}

	public void setCheckingBalance(double checkingBalance) {
		this.checkingBalance = checkingBalance;
	}

	public double getSavingsBalance() {
		return savingsBalance;
	}

	public void setSavingsBalance(double savingsBalance) {
		this.savingsBalance = savingsBalance;
	}

	public double deposit(double money, String accountType) {
		if (accountType == "checking") {
			checkingBalance += money;
			System.out.println("Your current checking balance is: " + checkingBalance);
			return checkingBalance;
		} else {
			savingsBalance += money;
			System.out.println("Your current savings balance is: " + savingsBalance);
			return savingsBalance;
		}
	}

	public double withdraw(double money, String accountType) {
		if (accountType == "checking") {
			if (money < checkingBalance) {
				checkingBalance -= money;
			} else {
				System.out.println("You have insufficient funds in the checking account");
			}
			System.out.println("Your current checking balance is: " + checkingBalance);
			return checkingBalance;
		} else {
			if (money < savingsBalance) {
				savingsBalance -= money;
			} else {
				System.out.println("You have insufficient funds in the savings account");
			}
			System.out.println("Your current savings balance is: " + savingsBalance);
			return savingsBalance;
		}
	}
}
