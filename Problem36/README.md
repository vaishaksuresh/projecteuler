Problem
========
The decimal number, 585 = 10010010012 (binary), is palindromic in both bases.

Find the sum of all numbers, less than one million, which are palindromic in base 10 and base 2.

(Please note that the palindromic number, in either base, may not include leading zeros.)

Solution Approach
=================

* Generate all primes under 1 million
* Check if decimal number is palindrome
* Check if binary is palindrome
* add to the sum if yes, continue otherwise.
* Order of checking for palindrome should be decimal and then binary because there are more palindromes in binary representation.

Execution Steps
===============
The code can be executed using teh follwoing commands.

`javac Problem36.java`
`java Problem36`

The sample output:

	Sum of primes less than 1000000 which are palindrome in both bases: 872187
	Time Taken for computation: 231ms
