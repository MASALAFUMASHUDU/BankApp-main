package com.eviro.assessment.Grad001.MusalafuMashudu.account;

import java.math.BigDecimal;

public class AbstractAccount
{
	private int userID;
	private int accNo;
	private  String userName;
	private BigDecimal balance;

	// constructor
	public AbstractAccount() {

	}

	//Overloading Constructor
	public AbstractAccount(int accNo,int userID,String userName,BigDecimal balance) {
		this.accNo = accNo;
		this.userID = userID;
		this.userName = userName;
		this.balance = balance;
	}

	// return UserID
	public int getUserID() {
		return userID;
	}

	// return Account No
	public int getAccNo() {
		return accNo;
	}

	// return User name
	public String getUserName() {
		return userName;
	}


	// return Balance
	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance)
	{
		this.balance = balance;
	}

	public void printAccountWithdrawalSuccessful(BigDecimal amountToWithdraw)
	{
		System.out.println("Successfully withdraw : " + amountToWithdraw);
		System.out.println( "Current Balance: " + getBalance() + "\n" + "Account Number: " + getAccNo() + "\n" + "Account ID:" + getUserID());
	}
}
