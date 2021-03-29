package com.eviro.assessment.Grad001.MusalafuMashudu.account;

import java.math.BigDecimal;

public class CurrentAccount extends AbstractAccount
{
	private  BigDecimal overdraft;

	public CurrentAccount()
	{
		super();
	}

	//overloading constructor
	public CurrentAccount(int accNo,int userId,String userName,BigDecimal balance, BigDecimal overdraft)
	{
		super(accNo, userId, userName, balance);
		this.overdraft = overdraft;
	}

	// return Balance
	public BigDecimal getAdjustedBalance() {
		return getBalance().add(getOverdraft());
	}

	//Return overdraft
	public BigDecimal getOverdraft() {
		return overdraft;
	}

	public void printAccountWithdrawalSuccessful(BigDecimal amountToWithdraw)
	{
		System.out.println("Successfully withdraw : " + amountToWithdraw);
		System.out.println("Current Balance : " + getBalance() + "\n" + "Your Allowed Overdraft is :"
								   + getOverdraft() + "\n" + "Account Number : "
								   + getAccNo() + "\n" + "Acount ID :"
								   + getUserID());
	}
}
