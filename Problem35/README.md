Problem
========
The number, 197, is called a circular prime because all rotations of the digits: 197, 971, and 719, are themselves prime.
There are thirteen such primes below 100: 2, 3, 5, 7, 11, 13, 17, 31, 37, 71, 73, 79, and 97.
How many circular primes are there below one million?

Solution Approach
=================
* If the number is 100, return 13
* If it is less than 100, return error message.
* If the number is >100, start with 13 and increment when you find circular primes in the below steps
* For each number between 101 and limit, compute all possible combinations.
* Do this by repeatedly extracting the first character and appending to the end
* For each such number, check if it is prime.
	+ If number is even, return false
	+ starting from 3 through square root of number, if any number divides the number completely, return false
	+ if not, return true.
* If all combinations are prime, it is circular prime.
* If atleast one combination is not prime, break and proceed to the next number.
* Print total count.

Execution Steps
===============
The code can be executed using the follwoing commands.

`javac Problem35.java`

`java Problem35`

The sample output:

	Total circular prime number less than 1 million: 55
	Time Taken for computation: 0.281149sec
