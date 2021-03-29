
package com.eviro.assessment.Grad001.MusalafuMashudu.withdraw.interfaces;

import com.eviro.assessment.Grad001.MusalafuMashudu.withdraw.exceptions.WithdrawalAmountTooLargeException;
import com.eviro.assessment.Grad001.MusalafuMashudu.account.exception.AccountNotFoundException;

import java.math.BigDecimal;

/**
 * @Musalafu Mashudu
 *
 */

public interface AccountService {
 
	public void withdraw(String AccNum,BigDecimal WithdrawAmount) throws AccountNotFoundException, WithdrawalAmountTooLargeException;

}
