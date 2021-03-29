package com.eviro.assessment.Grad001.MusalafuMashudu.database;

import com.eviro.assessment.Grad001.MusalafuMashudu.account.CurrentAccount;
import com.eviro.assessment.Grad001.MusalafuMashudu.account.SavingAccount;

import java.math.BigDecimal;
import java.util.HashMap;

public class SystemDB {

	private static HashMap<Integer, SavingAccount> savingAccountHashMap = new HashMap<>();
	private static HashMap<Integer, CurrentAccount> currentAccountHashMap = new HashMap<>();

	private static SystemDB instance = null;

	private  SystemDB() {
	}

	public static SystemDB getInstance() {
		if(instance == null) {
			instance = new SystemDB();
		}
		return instance;
	}

	public void init()
	{
		//initialise savings account
		SavingAccount S1  = new SavingAccount(1,101,"User1",new BigDecimal(2000));
		SavingAccount S2  = new SavingAccount(2,102,"User2",new BigDecimal(5000));
		savingAccountHashMap.put(1, S1);
		savingAccountHashMap.put(2, S2);

		//initialise current account
		CurrentAccount Curr1  = new CurrentAccount(3,103,"User3",new BigDecimal(5000),new BigDecimal(10000));
		CurrentAccount Curr2 = new CurrentAccount(4,104,"User4",new BigDecimal(-5000),new BigDecimal(20000));
		currentAccountHashMap.put(3, Curr1);
		currentAccountHashMap.put(4, Curr2);
	}

	public static HashMap<Integer, SavingAccount> getSavingAccountHashMap()
	{
		return savingAccountHashMap;
	}

	public static HashMap<Integer, CurrentAccount> getCurrentAccountHashMap()
	{
		return currentAccountHashMap;
	}
}
	
	
	
	
	

