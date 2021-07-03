/**
 * Google
 * Given a string containing digits from 2-9 inclusive, each number maps to set of characters just like on a dial pad.
 * Return all possible letter combinations that the number could represent if pressed in that order. 
 * Return the answer in any order.
 */
package Miscellaneous.UniqueConcepts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DialPadPermutation {
	
	private final HashMap<Character,String> dialPad = new HashMap<>(){{
        put('2',"abc");
        put('3',"def");
        put('4',"ghi");
        put('5',"jkl");
        put('6',"mno");
        
        put('7',"pqrs");
        put('8',"tuv");
        put('9',"wxyz");
    }} ;
    
    List<String> ls;
    
    private void bfs(int currentIndex, String digits, StringBuilder sb) {
        if(currentIndex == digits.length()) {
            ls.add(sb.toString());
        }
        else {
            String dialPadChars = dialPad.getOrDefault(digits.charAt(currentIndex), "");
            for(int i=0; i<dialPadChars.length(); i++) {
                bfs(currentIndex+1, digits, new StringBuilder(sb).append(dialPadChars.charAt(i)));
            }
        }
    }
    public List<String> letterCombinations(String digits) {
        ls = new ArrayList<>();
        if(digits.length() ==0)
            return ls;
        bfs(0, digits, new StringBuilder());
        return ls;
    }

	public static void main(String[] args) {

	}

}
