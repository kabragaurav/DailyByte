/**
 * Given a binary search tree, rearrange the tree such that 
 * it forms a list where all its values are in ascending order.
 */
package Trees;

import java.util.ArrayList;
import java.util.List;

import Trees.TreeUtils.TreeNode;

/**
 * @author gaurav kabra
 * @since June 10, 2021
 */

public class BSTToArray {
	
	private void inOrderTraversal(List<Integer> ls, TreeNode<Integer> root) {
		/**
		 * Logic:
		 * Inorder traversal (left -> root -> right) of tree gives us sorted (ascending) list.
		 * 
		 * Time Complexity: O(N), where N is the number of nodes in the BST (We have to visit each node).
         * Space Complexity: O(N) since we maintain a list to store all nodes of tree. Also the maximum amount of space utilized by the recursion stack would be N since the height of a skewed BST could be N.
         */
     
		if(root == null)
			return;
		if((root.left == null ) && (root.right == null)) {
			ls.add(root.val);
		} 
		else {
			inOrderTraversal(ls, root.left);
			ls.add(root.val);
			inOrderTraversal(ls, root.right);
		}
	}
	
	// helper method to main
	private static TreeNode<Integer> getTreeNode(Integer val) {
	    TreeNode<Integer> treeNode = new TreeNode<Integer>(val);
		return treeNode;
	}
	
	// driver - main method
	public static void main(String[] args) {
		// create empty list to hold sorted numbers from tree traversal
		List<Integer> ls = new ArrayList<>();
		
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
		
		BSTToArray bta = new BSTToArray();
		bta.inOrderTraversal(ls, root);
		
		for(Integer i : ls) {
			System.out.println(i);
		}
	}

}
