/**
 * Microsoft
 * Given an array of strings, return the longest common prefix that is shared amongst all strings.
 * Note: you may assume all strings only contain lowercase alphabetical characters.
 */
package Strings;

import java.util.Arrays;

/**
 * @author gaurav kabra
 * @since May 21, 2021
 */

public class LongestCommonPrefix {
	
	
	private String longestCommonPrefix(String[] arr) {
		Arrays.sort(arr);
		
		String first = arr[0];
		String last = arr[arr.length-1];
		int minLen = Math.min(first.length(), last.length());
		int i=0;
		for(; i<minLen; i++) {
			if(first.charAt(i) != last.charAt(i))
				break;
		}
		return first.substring(0, i);
	}

	public static void main(String[] args) {
		
		LongestCommonPrefix lcp = new LongestCommonPrefix();
		
		System.out.println(lcp.longestCommonPrefix(new String[]{"colorado", "color", "cold"}));

		System.out.println(lcp.longestCommonPrefix(new String[]{"a", "b", "c"}));

		System.out.println(lcp.longestCommonPrefix(new String[]{"spot", "spotty", "spotted"}));
		
	}

}
