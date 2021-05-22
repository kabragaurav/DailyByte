/**
 * Google
 * You are given two strings, s and t which only consist of lowercase letters. 
 * t is generated by shuffling the letters in s as well as potentially adding an additional random character.
 * Return the letter that was randomly added to t if it exists, otherwise, return ' '.
 * Note: You may assume that at most one additional character can be added to t.
 */
package HashMap_2;

import java.util.HashMap;
import java.util.Map;

public class SpotTheDifference {
	
	/**
	 * @param string s
	 * @param string t
	 * @return additional character, if any, in t. Else ' '
	 * Time: O(N) as we do XOR by tracing s and t once linearly
	 * Space: O(1) as no extra space is required/ use constant extra space
	 */
	private char getAdditionalCharUsingBitManipulation(String s, String t) {
		/**
		 * Logic:
		 * XOR (^) of two same characters is 0.
		 * We use this property and do XOR of all characters in s and t.
		 * If final result is 0 that means s and t are same. So we return ' '. Else we return the final result.
		 */
		char ans = 0;
		// We could also have only one string using s+t and do xor then in one loop
		for(char ch : s.toCharArray())
			ans ^= ch;
		for(char ch : t.toCharArray())
			ans ^= ch;
		return ans == 0 ? ' ' : ans;
	}
	
	/**
	 * @param string s
	 * @param string t
	 * @return additional character, if any, in t. Else ' '
	 * Time: O(N) as we trace s and t once linearly for populate/modify map
	 * Space: O(1) as no extra space is required/ use constant extra space
	 */
	private char getAdditionalCharUsingMap(String s, String t) {
		/**
		 * Logic:
		 * Using Map we keep frequency count of characters in s.
		 * Then in t, we keep decreasing character count by 1.
		 * If any moment, we see that a character is not present in map (i.e frequency = 0), that means t has a new character that is not present in s.
		 * So we return that character.
		 * Otherwise, if by decreasing frequency by 1, we get -1 in map, that means t has a character by one extra frequency than s. So we return that character.
		 */
		Map<Character, Integer> mp = new HashMap<>();
		
		for(char ch : s.toCharArray()) {
			mp.put(ch, mp.getOrDefault(ch, 0)+1);
		}
		
		for(char ch : t.toCharArray()) {
			if(mp.getOrDefault(ch, 0) == 0)
				return ch;
			else {
				mp.put(ch,mp.get(ch)-1);
				if(mp.get(ch) == -1)
					return ch;
			}
		}
		
		return ' ';
	}

	// driver - main method
	public static void main(String[] args) {
		SpotTheDifference std = new SpotTheDifference();
		
		// TESTCASES
		System.out.println(std.getAdditionalCharUsingMap("foobar", "barfoot"));
		System.out.println(std.getAdditionalCharUsingMap("ide", "idea"));
		System.out.println(std.getAdditionalCharUsingMap("coding", "ingcod"));
		System.out.println(std.getAdditionalCharUsingMap("a", "aa"));
		
		System.out.println(std.getAdditionalCharUsingBitManipulation("foobar", "barfoot"));
		System.out.println(std.getAdditionalCharUsingBitManipulation("ide", "idea"));
		System.out.println(std.getAdditionalCharUsingBitManipulation("coding", "ingcod"));
		System.out.println(std.getAdditionalCharUsingBitManipulation("a", "aa"));
	}

}