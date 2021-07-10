/**
 * Amazon
 * You’re running a popsicle stand where each popsicle costs $5. 
 * Each customer you encountered pays with either a $5 bill, a $10 bill, or a $20 bill 
 * and only buys a single popsicle. The customers that come to your stand come in the ordered given by
 * the customers array where customers[i] represents the bill the ith customer pays with. 
 * Starting with $0, return whether or not you can serve all the given customers 
 * while also giving the correct amount of change.
 * The customer won't wait for change so his changes must be returned immediately.
 */
package Greedy;

import java.util.HashMap;
import java.util.Map;

public class PopsicleStandChange {

    private static Map<Integer, Integer> mp = new HashMap<>();
    
    private boolean handleCustomer(int bill) {
        if(bill == 10) {
            if(mp.get(5) != null && mp.get(5) > 0) {
                mp.put(5, mp.get(5)-1);
            }
            else {
                return false;
            }
        }
        else if(bill == 20) {
            if(mp.get(10) != null && mp.get(5) != null && mp.get(10) > 0 && mp.get(5)  > 0) {
                mp.put(10, mp.get(10)-1);
                mp.put(5, mp.get(5)-1);
            }
            else if(mp.get(5) != null && mp.get(5) >=3) {
                mp.put(5, mp.get(5)-3);
            }
            else {
                return false;
            }
        }
        return true;
    }
    
    public boolean popsicleChange(int[] bills) {
        for(int bill : bills) {
            mp.put(bill, mp.getOrDefault(bill,0)+1);
            if(!handleCustomer(bill)) {
                return false;
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		PopsicleStandChange psc = new PopsicleStandChange();
		System.out.println(psc.popsicleChange(new int[] {5,5,10,10,20}));
		mp.clear();
		System.out.println(psc.popsicleChange(new int[] {5,5,5,5,20,20,5,5,5,5}));
	}

}
