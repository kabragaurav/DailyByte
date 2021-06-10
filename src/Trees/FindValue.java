/**
 * Google
 * Given the reference to the root of a binary search tree and a search value, 
 * return the reference to the node that contains the value if it exists and null otherwise.
 */
package Trees;

import Trees.TreeUtils.TreeNode;

/**
 * @author gaurav kabra
 * @since June 10, 2021
 */

public class FindValue {
	
	private TreeNode<Integer> getValueReference(TreeNode<Integer> root, int val) {
		if(root == null || root.val == val) {
			return root;
		}
		
		return (root.val > val) ? getValueReference(root.left, val)
					            : getValueReference(root.right, val);
	}
	
	private static TreeNode<Integer> getTreeNode(Integer val) {
	    TreeNode<Integer> treeNode = new TreeNode<Integer>(val);
		return treeNode;
	}
	
	// driver - main method
	public static void main(String[] args) {
		// make tree
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
		
		// TESTCASES
		FindValue fv = new FindValue();
		System.out.println(fv.getValueReference(root, 5).val);
		System.out.println(fv.getValueReference(root, 1));
	}

}
