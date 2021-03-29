import com.eviro.assessment.Grad001.MusalafuMashudu.account.exception.AccountNotFoundException;
import com.eviro.assessment.Grad001.MusalafuMashudu.database.SystemDB;
import com.eviro.assessment.Grad001.MusalafuMashudu.withdraw.WithDraw;
import com.eviro.assessment.Grad001.MusalafuMashudu.withdraw.exceptions.WithdrawalAmountTooLargeException;
import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		SystemDB SDB = SystemDB.getInstance();
		SDB.init();

		WithDraw withdraw = new WithDraw();

		Scanner ss = new Scanner(System.in);
		String input = "";
		do {
			System.out.println("-----------------------------------------------------------");
			System.out.println("Type 'X then enter key'  to exit or type 'C  then enter key' to continue:");

			input = ss.next();
			if (!input.equalsIgnoreCase("X"))
				doWithdrawal(withdraw, ss);
			else
				return;
		}
		while(!input.equalsIgnoreCase("X"));
		ss.close();
		System.out.println("Bye!");
	}

	private static void doWithdrawal(WithDraw withdraw, Scanner ss)
	{
		System.out.println("Hello, Please enter Your Account Number : ");

		String AccNo = ss.next();
		System.out.println("Enter the amount you will like to withdraw  ");

		BigDecimal amount = ss.nextBigDecimal();

		try
		{
			withdraw.withdraw(AccNo, amount);
		}
		catch (AccountNotFoundException e)
		{
			System.err.println(e.getMessage());
			System.out.println("");
		}
		catch (WithdrawalAmountTooLargeException e)
		{
			System.out.println(e.getMessage());
			System.out.println("");
		}
	}

}
