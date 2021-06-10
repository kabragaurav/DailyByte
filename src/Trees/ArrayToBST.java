/**
 * Given an array of numbers sorted in ascending order, 
 * return a height-balanced binary search tree using every number from the array.
 * Height-balanced meaning that the level of any node’s two subtrees should not differ by more than one.
 */
package Trees;

import java.util.List;

import Trees.TreeUtils.TreeNode;

/**
 * @author gaurav kabra
 * @since June 10, 2021
 */
public class ArrayToBST {
	
	private static TreeNode<Integer> getTreeNode(Integer val) {
	    TreeNode<Integer> treeNode = new TreeNode<Integer>(val);
		return treeNode;
	}
	
	private TreeNode getArrayToBST(int[] ls, int start, int end) {
		
		if(start == end) {
			return getTreeNode(ls[start]);
		}
		if(start > end) {
			return null;
		}
		

		int mid = start + (end-start)/2;
		TreeNode root;
		root = getTreeNode(ls[mid]);
		root.left = getArrayToBST(ls, start, mid-1);
		root.right = getArrayToBST(ls, mid+1, end);
		return root;
	}
	
	
	// driver - main method
	public static void main(String[] args) {
		
		// TESTCASES
		ArrayToBST atb = new ArrayToBST();
		System.out.println(atb.getArrayToBST(new int[] {1,2,3,4,5,6}, 0, 5).val);
	}

}
