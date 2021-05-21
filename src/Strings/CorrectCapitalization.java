/**
 * Google
 * Given a string, return whether or not it uses capitalization correctly. 
 * A string correctly uses capitalization if all letters are capitalized, 
 * no letters are capitalized, or only the first letter is capitalized.
 */
package Strings;
/**
 * @author gaurav kabra
 * @since May 21, 2021
 */
public class CorrectCapitalization {
	
	/**
	 * Check for correct capitalization
	 * @param string s
	 * @return boolean, if correctly capitalized
	 */
	private boolean isCorrectlyCapitalized(String s) {
		/**
		 * Logic:
		 * First check first character's case.
		 * If it is capitalized, we have two cases:
		 * 			We need to check for correct capitalization either remaining chars should be all caps or all small
		 * Else:
		 * 			remaining chars should be all small
		 * 
		 * Time: O(N) as string comparison using equals method
		 * Space: O(1) as we don't use any extra space
		 */
		if(s == null || s.isEmpty())
			return true;
		
		char firstChar = s.charAt(0);
		// check if first char is capital or small case
		boolean isCapital = (firstChar >= 'A' && firstChar <= 'Z');
		
		if(isCapital) {
			String secondOnwards = s.substring(1);
			String secondOnwardsUpperCase = secondOnwards.toUpperCase();
			String secondOnwardsLowerCase = secondOnwards.toLowerCase();
			
			return secondOnwards.equals(secondOnwardsUpperCase) || secondOnwards.equals(secondOnwardsLowerCase);		
		}
		// else all chars should be small case
		else {
			for(int i=1; i<s.length(); i++) {
				if(s.charAt(i) > 'z' || s.charAt(i) < 'a')
					return false;
			}
		}
		// if we reach here that means string is correctly capitalized
		return true;
		
	}
	
	// driver - main method
	public static void main(String[] args) {
		CorrectCapitalization cc = new CorrectCapitalization();
		
		// TESTCASES
		System.out.println(cc.isCorrectlyCapitalized("USA"));
		System.out.println(cc.isCorrectlyCapitalized("Calvin"));
		System.out.println(cc.isCorrectlyCapitalized("compUter"));
		System.out.println(cc.isCorrectlyCapitalized("coding"));
	}

}
