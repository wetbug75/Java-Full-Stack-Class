import java.util.Scanner;

/**
 * This is HW 1, problem 2.
 * This application promps the user for a monetary amount and returns the change as strings on the console
 * @author Andrew Krause
 */
public class ChangeCalculator {
	
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		boolean isValid = false;
		double amount = 0;
		do {
			System.out.print("Amount: $");
			String amountString = myScanner.nextLine();
			isValid = isValidInput(amountString);//Note to Mr. Underwood: I saw that we didn't need to handle invalid inputs but did it anyways
			if(isValidInput(amountString))
				amount = Double.parseDouble(amountString);
			else
				System.out.println("Entry invalid, please try again.");
		}
		while(!isValid);
		myScanner.close();
		
		//double converted to two ints to avoid rounding errors
		int billAmount = (int)amount;
		int changeAmount = (int)Math.round((amount - billAmount) * 100);
		
		System.out.println(billAmount / 20 + " twenty dollar bills");
		billAmount %= 20;
		System.out.println(billAmount / 10 + " ten dollar bills");
		billAmount %= 10;		
		System.out.println(billAmount / 5 + " five dollar bills");
		billAmount %= 5;
		System.out.println(billAmount / 1 + " one dollar bills");
		
		System.out.println(changeAmount / 25 + " quarters");
		changeAmount %= 25;
		System.out.println(changeAmount / 10 + " dimes");
		changeAmount %= 10;
		System.out.println(changeAmount / 5 + " nickels");
		changeAmount %= 5;
		System.out.println(changeAmount / 1 + " pennies");
	}
	
	/**
	 * Checks if the input is a valid currency structure, not including commas or the '$' char
	 * @param input a string you expect to be currency
	 * @return true if the string follows currency structure (i.e. _ _ . _ _ or similar)
	 */
	private static boolean isValidInput(String input) {
		if(input.equals("."))
			return false;
		boolean decimalPresent = false;
		for(int i = 0; i < input.length(); i++)
		{
			if(input.charAt(i) == '.')
			{
				if(decimalPresent)
					return false;
				if (i < input.length()-3) //checks to make sure decimal point is one of the last 3 chars
					return false;
				decimalPresent = true;
			}
			else if(!(input.charAt(i) >= 48 && input.charAt(i) <= 57)) //checks to make sure all chars are numbers
				return false;
		}
		return true;
	}
}