/**
 * Given a binary tree, containing unique values, determine if it is a strict valid binary search tree.
 */
package Trees;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;

public class ValidateBST {
    
	private boolean isStrictBST(TreeNode<Long> root, long minVal, long maxVal) {
		if (root == null) return true;
        if (root.val >= maxVal || root.val <= minVal) return false;
        return isStrictBST(root.left, minVal, root.val) && isStrictBST(root.right, root.val, maxVal);
	}
	
	public boolean isValidBST(TreeNode<Long> root) {
        return isStrictBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

	public static void main(String[] args) {
		
		ValidateBST vbst = new ValidateBST();
		System.out.println(vbst.isValidBST(TreeUtil.getDummyBinarySearchTreeLong()));
	}

}
