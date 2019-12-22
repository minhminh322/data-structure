package program;

import java.util.Stack;

/**
 * @author minhphan
 * @version Winter 2019
 *
 */
public final class Convert {

	/**
	 * A private constructor to inhibit instantiation.
	 */
	private Convert() {
		// do nothing
	}

	/**
	 * main
	 * 
	 * @param theArgs - command line arguments - ignored in this program
	 */
	public static void main(final String[] theArgs) {

		// Display introduction
		displayIntro();
		// binaryToDecimal("01000");
		char data[] = { '1', '0', '1', '0', '0' };
		int num = 12;
		System.out.println("Decimal value is: " + convert2sCompToDecimal(data));
		convertDecimalTo2sComp(num);

	}

	/**
	 * Program Header
	 */
	public static void displayIntro() {
		System.out.println("This program convert a 2’s complement binary number to decimal and vice versa");

	}

	public static int convert2sCompToDecimal(char[] bits) {
		// Convert char array to string.
		String binary = String.valueOf(bits);

		// Check if the number is negative.
		if (binary.charAt(0) == '1') {
			// invertDigits method.
			String invertedInt = invertBinary(binary);
			// binaryToDecimal method.
			int decimalValue = binaryToDecimal(invertedInt);
			// decimalValue algorithm.
			decimalValue = (decimalValue + 1) * -1;

			return decimalValue;

		} else {
			// positive number
			return binaryToDecimal(binary);
		}

	}

	public static char[] convertDecimalTo2sComp(int decimal) {
		String result = "";
		
		if (decimal > 0) {
			result = decimalToBinary(Math.abs(decimal));

		} else {
			result = Integer.toBinaryString(decimal);
		}

		System.out.println("Binary value is: " + result);
		
		return result.toCharArray();

	}

	public static String invertBinary(String theBinary) {
		String result = theBinary;
		result = result.replace("0", " "); // replace '0' by ''
		result = result.replace("1", "0"); // replace 1s by 0s
		result = result.replace(" ", "1"); // put '1' into ''.
		return result;
	}
	/**
	 * Convert binary to decimal (Positive number)
	 * 
	 * @param theBinary binary .
	 * @return result integer.
	 */
	public static int binaryToDecimal(String theBinary) {
		int result = 0;
		for (int i = 0; i < theBinary.length(); i++) {
			if (theBinary.charAt(i) == '1') {
				result = (int) (result + Math.pow(2, theBinary.length() - 1 - i));
			}

		}
		return result;
	}

	/**
	 * Convert one decimal to binary.
	 * 
	 * @param theNumber a Scanner used to gather user input
	 * @return the number of guesses taken in this round of the game
	 */
	public static String decimalToBinary(final int theNumber) {

		final Stack<Integer> stack = new Stack<Integer>();

		int remainder;
		int decimal = theNumber;

		while (decimal > 0) {
			remainder = decimal % 2;
			stack.push(remainder);
			decimal = decimal / 2;

		}

		String result = "";
		while (!stack.isEmpty()) {
			result += stack.pop();
		}

		return result;
	}

}
