package com.eviro.assessment.Grad001.MusalafuMashudu.account;

import java.math.BigDecimal;

public class SavingAccount extends AbstractAccount
{
	public SavingAccount()
	{
		super();
	}

	//overloading constructor
	public SavingAccount(int accNo,int userId,String userName,BigDecimal balance)
	{
		super(accNo, userId, userName, balance);
	}
}
