/**
 * Given a binary tree, return the largest value in each of its levels.
 */
package BreadthFirstSearch;
/**
 * @author gaurav kabra
 * @since June 16, 2021
 */
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import Trees.TreeUtils.TreeNode;

/**
 * The logic is same as LevelOrderTraversal.java
 * In fact, it is just a slight variation of LevelOrderTraversal.java program
 */
public class MaxAtEachLevel {
	
	// NULL is symbol that will denote end of a level in tree
	TreeNode<Integer> NULL;
	
	public MaxAtEachLevel() {
		NULL = new TreeNode<Integer>(Integer.MAX_VALUE);
	}
	
	/**
	 * Time Complexity : O(N) since we traverse tree once
	 * Space Complexity : O(N) since we need storage depending on number of nodes in tree(i.e. N).
	 */
	private List<List<TreeNode<Integer>>> levelOrderTraversal(TreeNode<Integer> root) {
		TreeNode<Integer> tempNode;															// holds a tree node temporarily
		Deque<TreeNode<Integer>> deque = new ArrayDeque<>();								// holds tree nodes and NULL
		List<TreeNode<Integer>> tempList = new ArrayList<>();								// holds tree nodes that are at same level. Finally we add it to our final answrer
		List<List<TreeNode<Integer>>> list = new ArrayList<List<TreeNode<Integer>>>();		// final answer
		
		if(root == null)
			return list;			// return empty list if root is null
		deque.add(root);
		deque.add(NULL);			// at root our first level completes
		boolean twoConsecutiveNull = false;				// at last of tree, we check if two NULL are there in deque, break out of while loop
		while(!deque.isEmpty()) {
			tempNode = deque.remove();					// remove first element
			/**
			 * if NULL that means one level is completed
			 * So check if two NULL are in list. If so break. Else add all elements at the level to our final answer
			 */
			if(tempNode == NULL) {
				if(twoConsecutiveNull)
					break;
				twoConsecutiveNull = true;
				List<TreeNode<Integer>> tList = new ArrayList<>();
				tList.addAll(tempList);
				list.add(tList);
				// BEFORE CLEARING tempList, assign it to local variable (if global then clearing will clear data in list as well) to create deep copy
				tempList.clear();
				deque.add(NULL);
			} else {
				twoConsecutiveNull = false;
				tempList.add(tempNode);
				if(tempNode.left != null)
					deque.add(tempNode.left);
				if(tempNode.right != null)
					deque.add(tempNode.right);
			}
		}
		return list;
	} 
	
	// helper method to main
	private static TreeNode<Integer> getTreeNode(Integer val) {
	    TreeNode<Integer> treeNode = new TreeNode<Integer>(val);
		return treeNode;
	}
	
	// finds and prints the max at each level of tree
	private void printMaxAtEachLevel(List<List<TreeNode<Integer>>> ls) {
		for(List<TreeNode<Integer>> l : ls) {
			int max = Integer.MIN_VALUE;
			for(TreeNode<Integer> node : l) {
				max = (node.val > max ? node.val 
									  : max
					   );
			}
			System.out.println(max);
		}
	}
	public static void main(String[] args) {
		// make Tree
	    TreeNode<Integer> root = getTreeNode(6);
		TreeNode<Integer> two = getTreeNode(2);
		TreeNode<Integer> eight = getTreeNode(8);
		TreeNode<Integer> zero = getTreeNode(0);
		TreeNode<Integer> four = getTreeNode(4);
		TreeNode<Integer> seven = getTreeNode(7);
		TreeNode<Integer> nine = getTreeNode(9);
		TreeNode<Integer> three = getTreeNode(3);
		TreeNode<Integer> five = getTreeNode(5);
				
		root.left = two;	
		root.right = eight;
		two.left = zero;
		two.right = four;
		eight.left = seven;
		eight.right = nine;
		four.left = three;
		four.right = five;	
		
		MaxAtEachLevel mael = new MaxAtEachLevel();
		
		// TESTCASES
		List<List<TreeNode<Integer>>> ls1 = mael.levelOrderTraversal(root);
		mael.printMaxAtEachLevel(ls1);
		List<List<TreeNode<Integer>>> ls2 = mael.levelOrderTraversal(null);
		mael.printMaxAtEachLevel(ls2);
	}

}
