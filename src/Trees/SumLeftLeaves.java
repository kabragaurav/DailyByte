/**
 * Given a binary tree, return the sum of all left leaves of the tree. 
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

public class SumLeftLeaves {
	
	private int sum = 0;
    
    private void helperSumOfLeftLeaves(TreeNode<Integer> root, boolean isLeft) {
        if(root == null) {
            return;
        }
        if(isLeft == true && root.left == null && root.right == null) {
            sum += root.val;
            return;
        }
        helperSumOfLeftLeaves(root.left, true);
        helperSumOfLeftLeaves(root.right, false);
    }
    
    private int sumOfLeftLeaves(TreeNode<Integer> root) {
        helperSumOfLeftLeaves(root, false);
        return sum;
    }

	public static void main(String[] args) {
		
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		System.out.println(new SumLeftLeaves().sumOfLeftLeaves(root));

	}

}
