/**
 * Apple
 * You are serving people in a lunch line and need to ensure each person gets a “balanced” meal. 
 * A balanced meal is a meal where there exists the same number of food items as drink items. 
 * Someone is helping you prepare the meals and hands you food items (i.e. F) or a drink items (D) 
 * in the order specified by the items string. 
 * Return the maximum number of balanced meals you are able to create without being able to modify items.
 */
package Greedy;

public class BalancedMeal {
	
	private int balancedMealsCount(char[] meals) {
		if(meals.length == 0)
			return 0;
		int fCount = 0;
		int dCount = 0;
		int balanced = 0;
		for(char meal : meals) {
			if(meal == 'F') {
				fCount++;
			}
			else {
				dCount++;
			}
			if(fCount == dCount) {
				balanced++;
			}
		}
		return balanced;
	}

	public static void main(String[] args) {
		BalancedMeal bm = new BalancedMeal();
		System.out.println(bm.balancedMealsCount("FDFDFD".toCharArray()));
		System.out.println(bm.balancedMealsCount("FDFFDFDD".toCharArray()));
	}

}
