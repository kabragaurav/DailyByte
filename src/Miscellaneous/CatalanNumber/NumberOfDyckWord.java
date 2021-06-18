/**
 * Given an integer n, the task is to count Dyck words possible of length n. 
 * A Dyck word is a word containing only characters 'A' and 'B'
 * such that in every prefix of the word frequency('A') ≥ frequency('B')
 */
package Miscellaneous.CatalanNumber;

import Miscellaneous.CatalanNumber.CatalanUtil.NThCatalanNumber;

public class NumberOfDyckWord {

	// driver - main method
	public static void main(String[] args) {
		
		// TESTCASE
		System.out.println(NThCatalanNumber.catalanNumber(3));
	}

}
