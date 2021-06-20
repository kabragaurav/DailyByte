/**
 * The diameter of a tree is the number of nodes on the longest path between any two nodes in the tree.
 * Given the root of a binary tree, return the length of the diameter of the tree.
 */
package DP.Trees;

/**
 * @author gaurav kabra
 * @since June 20, 2021
 */

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

public class DiameterOfTree {
	
	private int height(TreeNode root) {
		if(root == null)
			return 0;
		return 1 + Math.max(height(root.left), height(root.right));
	}
	
	private int diameterOfBinaryTree(TreeNode<Integer> root) {
		/**
    	 * Time Complexity: O(N) since we essentially traverse the tree
    	 * Space Complexity: O(N) since we use implicit stack in recursive calls
    	 */
        if(root == null)
        	return 0;
        
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        
        return Math.max(1+leftHeight+rightHeight,
        				Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right)));
    }
	
	// driver - main method
	public static void main(String[] args) {
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		System.out.println(new DiameterOfTree().diameterOfBinaryTree(root));
	}

}
