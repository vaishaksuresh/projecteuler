Problem
========
The prime 41, can be written as the sum of six consecutive primes:

41 = 2 + 3 + 5 + 7 + 11 + 13
This is the longest sum of consecutive primes that adds to a prime below one-hundred.

The longest sum of consecutive primes below one-thousand that adds to a prime, contains 21 terms, and is equal to 953.

Which prime, below one-million, can be written as the sum of the most consecutive primes?

Solution Approach
=================
* Get a list flags for prime numbers under 1 million using sieve of eratosthenese
* Get a list of prime numbers using the flags.
* Maintain a running sum of primes where the sum is also prime.
* In each iteration, if the resulting sum is higher than current sum and the sum is prime, update
* Otherwise continue.


Execution Steps
===============
The code can be executed using teh follwoing commands.

`javac Problem50.java`
`java Problem50`

The sample output:

	Prime, below one-million, that can be written as the sum of the most consecutive primes: 997651
	Time Taken for Computation: 36 msec

