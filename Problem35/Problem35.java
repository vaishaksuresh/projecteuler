/**
 * The Class Problem35.
 */
public class Problem35 {

	/**
	 * Checks if is prime.
	 * 
	 * @param candidate
	 *            the candidate number
	 * @return true, if is prime
	 */
	static boolean isPrime(int candidate) {
		// If the number is even, it cannot be prime.
		if (candidate % 2 == 0) {
			return false;
		}
		long limit = (long) Math.sqrt(candidate);
		// To check numbers prime property,
		// We only need to check divisors till squareroot of the number.
		for (int i = 3; i <= limit; i += 2)
			if (candidate % i == 0)
				return false;
		return true;
	}

	/**
	 * Rotate number.
	 * 
	 * @param candidate
	 *            the candidate number for rotation
	 * @return the rotated number
	 */
	static int rotateNumber(int candidate) {
		// get string representation of number, append first character to last
		String nStr = String.valueOf(candidate);
		char firstCh = nStr.charAt(0);
		nStr = nStr.substring(1);
		nStr += firstCh;
		if (nStr.charAt(0) == '0')
			return 0;
		return Integer.parseInt(nStr);
	}

	/**
	 * Count circular primes.
	 * 
	 * @param limit
	 *            the upper bound
	 * @return the number of circular primes
	 */
	private static int countCircularPrimes(int limit) {
		int totalPrimes = 13;
		// We know there are 13 circular primes between 0 and 100,
		// Start from 101
		for (int i = 101; i < limit; i += 2) {
			int candidate = i;
			// Treat each number as a candidate and find all combinations of its
			// digits.
			int numberLength = String.valueOf(candidate).length();
			boolean allPrimeFlag = true;
			for (int j = 0; j < numberLength && allPrimeFlag; j++) {
				candidate = rotateNumber(candidate);
				// If a combination is not prime, the number is not circular
				// prime. Stop Processing
				if (!isPrime(candidate)) {
					allPrimeFlag = false;
					break;
				}
			}
			// If all combinations are prime, the number is a circular prime.
			// Increment total count
			if (allPrimeFlag) {
				totalPrimes++;
			}
		}
		return totalPrimes;
	}

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		long startTime = System.nanoTime();
		int totalPrimes = countCircularPrimes(1000000);
		System.out.println("Total circular prime number less than 1 million: "
				+ totalPrimes);
		System.out.println("Time Taken for computation: "
				+ (System.nanoTime() - startTime) / 1000000000.0 + "sec");
	}
}
