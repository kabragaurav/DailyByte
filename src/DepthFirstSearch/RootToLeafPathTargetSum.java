/**
 * Given a binary tree and a target, return whether or not 
 * there exists a root to leaf path 
 * such that all values along the path sum to the target.
 */
package DepthFirstSearch;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;


public class RootToLeafPathTargetSum {
	
	private boolean getRootToLeafPathTargetSum(TreeNode<Integer> root, int target, int currentSum) {
		
		// say tree = [] and target = 0
		if(root == null)
            return false; 
		
		if(root.left == null && root.right == null) {
			return (currentSum + root.val) == target;
		}
		boolean b1 = false, b2 = false;
		if(root.left != null) {
			int sum1  = currentSum + root.val;
			b1 = getRootToLeafPathTargetSum(root.left, target, sum1);
		}
		
		if(root.right != null) {
			int sum2  = currentSum + root.val;
			b2 = getRootToLeafPathTargetSum(root.right, target, sum2);
		}
		
		return b1 || b2;
	}
	
	
	public static void main(String[] args) {
		
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		RootToLeafPathTargetSum rtlp = new RootToLeafPathTargetSum();
		System.out.println(rtlp.getRootToLeafPathTargetSum(root, 17, 0));
	}
}
