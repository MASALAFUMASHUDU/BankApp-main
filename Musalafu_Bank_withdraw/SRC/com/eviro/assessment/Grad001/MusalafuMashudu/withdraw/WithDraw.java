package com.eviro.assessment.Grad001.MusalafuMashudu.withdraw;

import com.eviro.assessment.Grad001.MusalafuMashudu.withdraw.exceptions.WithdrawalAmountTooLargeException;
import com.eviro.assessment.Grad001.MusalafuMashudu.withdraw.interfaces.AccountService;
import com.eviro.assessment.Grad001.MusalafuMashudu.account.CurrentAccount;
import com.eviro.assessment.Grad001.MusalafuMashudu.account.SavingAccount;
import com.eviro.assessment.Grad001.MusalafuMashudu.account.exception.AccountNotFoundException;
import com.eviro.assessment.Grad001.MusalafuMashudu.database.SystemDB;

import java.math.BigDecimal;

public class WithDraw implements AccountService
{

	SavingAccount savingAcc;
	CurrentAccount currentAcc;

	public void withdraw(String accNo, BigDecimal amountToWithdraw) throws AccountNotFoundException, WithdrawalAmountTooLargeException
	{
		int convertToInt = Integer.parseInt(accNo);

		savingAcc = null;
		currentAcc = null;

		if (amountToWithdraw.doubleValue() < 0)
			return;

		if (SystemDB.getSavingAccountHashMap().containsKey(convertToInt))//check if acc is in savings
		{
			savingAcc = SystemDB.getSavingAccountHashMap().get(convertToInt);

			BigDecimal balance = savingAcc.getBalance();
			BigDecimal remainingBalance = balance.subtract(amountToWithdraw);
			BigDecimal MIN_AMOUNT = new BigDecimal(1000);


			if (remainingBalance.compareTo(MIN_AMOUNT) >= 0)
			{
				SystemDB.getSavingAccountHashMap().get(convertToInt).setBalance(remainingBalance);//update balance
				savingAcc.printAccountWithdrawalSuccessful(amountToWithdraw);
			}
			else
				throw new WithdrawalAmountTooLargeException("The amount of " + amountToWithdraw + " is too large , try a less amount.");

		}
		else if (SystemDB.getCurrentAccountHashMap().containsKey(convertToInt))//check if acc is in current
		{
			currentAcc = SystemDB.getCurrentAccountHashMap().get(convertToInt);

			BigDecimal remainingBalance = currentAcc.getAdjustedBalance().subtract(amountToWithdraw);

			if (currentAcc.getAdjustedBalance().compareTo(amountToWithdraw) >= 0)
			{
				SystemDB.getCurrentAccountHashMap().get(convertToInt).setBalance(remainingBalance.subtract(currentAcc.getOverdraft()));
				currentAcc.printAccountWithdrawalSuccessful(amountToWithdraw); 	//update balance
			}
			else
				throw new WithdrawalAmountTooLargeException("The amount of " + amountToWithdraw + " is too large , try a less amount.");
		}

		if (savingAcc == null && currentAcc == null)
			throw  new AccountNotFoundException("Account not found");
	}

}
	

		

