/**
 * The prime 41, can be written as the sum of six consecutive primes:
 * 
 * 41 = 2 + 3 + 5 + 7 + 11 + 13 This is the longest sum of consecutive primes
 * that adds to a prime below one-hundred.
 * 
 * The longest sum of consecutive primes below one-thousand that adds to a
 * prime, contains 21 terms, and is equal to 953.
 * 
 * Which prime, below one-million, can be written as the sum of the most
 * consecutive primes?
 */
public class Problem50 {

	/**
	 * The main method.
	 * 
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		Long start = System.currentTimeMillis();
		final int LIMIT = 1000000;
		// Gets a boolean array with primes set to true
		boolean[] isPrime = sieve(LIMIT);
		// Get a list of prime numbers
		int[] primes = getListOfPrimes(isPrime);

		long maxSum = 0;
		int maxRun = -1;
		// Iterate over the primes
		for (int i = 0; i < primes.length; i++) {
			int sum = 0;
			for (int j = i; j < primes.length; j++) {
				sum += primes[j];
				if (sum > LIMIT)
					break;
				// compute the running sum
				else if (j - i > maxRun && sum > maxSum && isPrime[sum]) {
					maxSum = sum;
					maxRun = j - i;
				}
			}
		}
		System.out.println("Prime, below one-million, that can be written as the sum of the most consecutive primes: "+Long.toString(maxSum));
		System.out.println("Time Taken for Computation: "
				+ (System.currentTimeMillis() - start) + " msec");

	}

	/**
	 * Sieve.
	 * 
	 * @param limit
	 *            the limit
	 * @return the boolean[]
	 */
	public static boolean[] sieve(int limit) {
		if (limit < 0)
			throw new IllegalArgumentException("Negative size");
		boolean[] primeFlags = new boolean[limit + 1];
		if (limit >= 2)
			primeFlags[2] = true;
		for (int i = 3; i <= limit; i += 2)
			primeFlags[i] = true;
		// Sieve of Eratosthenes
		for (int i = 3; i * i <= limit; i += 2) {
			if (primeFlags[i]) {
				for (int j = i * i; j <= limit; j += i << 1)
					primeFlags[j] = false;
			}
		}
		return primeFlags;
	}

	/**
	 * Gets the list of primes.
	 * 
	 * @param isPrimeFlags
	 *            the is prime flags
	 * @return the list of primes
	 */
	public static int[] getListOfPrimes(boolean[] isPrimeFlags) {

		int count = 0;
		for (boolean b : isPrimeFlags) {
			if (b)
				count++;
		}
		int[] primes = new int[count];
		for (int allNumbersIndex = 0, primeOnlyIndex = 0; allNumbersIndex < isPrimeFlags.length; allNumbersIndex++) {
			if (isPrimeFlags[allNumbersIndex]) {
				primes[primeOnlyIndex] = allNumbersIndex;
				primeOnlyIndex++;
			}
		}
		return primes;
	}

}
