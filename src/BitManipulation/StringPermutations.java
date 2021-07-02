/**
 * Amazon
 * Given a string s consisting of only letters and digits, 
 * where we are allowed to transform any letter to uppercase or lowercase, 
 * return a list containing all possible permutations of the string.
 */
package BitManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 * See this for BFS & DFS solutions: https://tinyurl.com/stringpermBFSDFS
 */
public class StringPermutations {
	
	public List<String> letterCasePermutation(String s) {
        Set<String> st = new HashSet<>();
        
        s = s.toLowerCase();
        int pow2ToN = 1 << s.length();
        char[] arr;
        
        for(int i=0; i<pow2ToN; i++) {
            arr = s.toCharArray();
            for(int j=0; j<s.length(); j++) {
                if(((i >> j) & 1) == 1 && !Character.isDigit(arr[j])) {
                    arr[j] = (char) (arr[j] - 32);
                }
            }
            st.add(new String(arr));
        }
        
        return new ArrayList<>(st);
    }

	public static void main(String[] args) {
		System.out.println(new StringPermutations().letterCasePermutation("c7d15"));
	}

}
