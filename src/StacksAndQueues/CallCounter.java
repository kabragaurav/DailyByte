/**
 * Google
 * Create a class CallCounter that tracks the number of calls a client has made within the last 3 seconds.
 * Your class should contain one method, ping(int t) that receives the current timestamp (in milliseconds) of
 * a new call being made and returns the number of calls made within the last 3 seconds.
 * You may assume that the time associated with each subsequent call to ping is strictly increasing & positive.
 */
package StacksAndQueues;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author gaurav kabra
 * @since June 5, 2021
 */
public class CallCounter {
	
	Deque<Integer> record;
	
	public CallCounter() {
		this.record = new ArrayDeque<Integer>();
	}
	
	private int ping(int t) {
		if(record.isEmpty()) {
			record.addLast(t);
			return 1;
		}
		else {
			while(!record.isEmpty() && (t - record.getFirst()) > 3000) {
				record.removeFirst();
			}
			record.addLast(t);
			return record.size();
		}
	}

	public static void main(String[] args) {
		CallCounter cc = new CallCounter();
		
		System.out.println(cc.ping(1));
		System.out.println(cc.ping(300));
		System.out.println(cc.ping(3000));
		System.out.println(cc.ping(3002));
		System.out.println(cc.ping(7000));
	}

}
