/**
 * The Class Problem36.
 */
public class Problem36 {

	/**
	 * The decimal number, 585 = 10010010012 (binary), is palindromic in both
	 * bases.
	 * 
	 * Find the sum of all numbers, less than one million, which are palindromic
	 * in base 10 and base 2.
	 * 
	 * (Please note that the palindromic number, in either base, may not include
	 * leading zeros.)
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		long begin = System.currentTimeMillis();
		long sumOfDBPalindrome = 0;
		for (int candidate = 0; candidate < 1000000; candidate++) {
			if (isPalindrome(Integer.toString(candidate))
					&& isPalindrome(Integer.toBinaryString(candidate)))
				sumOfDBPalindrome += candidate;
		}
		System.out.println(sumOfDBPalindrome);
		System.out.println(System.currentTimeMillis() - begin + "ms");
	}

	/**
	 * Checks if is palindrome.
	 *
	 * @param inputString the input string
	 * @return true, if is palindrome
	 */
	private static boolean isPalindrome(String inputString) {
		String reversedString = new StringBuffer(inputString).reverse()
				.toString();
		if (inputString.equals(reversedString))
			return true;
		else
			return false;
	}
}