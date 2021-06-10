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
	
	private List<Integer> ls;
	
	public BSTToArray() {
		ls = new ArrayList<>();
	}
	
	private void inOrderTraversal(TreeNode<Integer> root) {
		if(root == null)
			return;
		if((root.left == null ) && (root.right == null)) {
			ls.add(root.val);
		} 
		else {
			inOrderTraversal(root.left);
			ls.add(root.val);
			inOrderTraversal(root.right);
		}
	}
	
	private static TreeNode<Integer> getTreeNode(Integer val) {
	    TreeNode<Integer> treeNode = new TreeNode<Integer>(val);
		return treeNode;
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
		
		BSTToArray bta = new BSTToArray();
		bta.inOrderTraversal(root);
		
		for(Integer i : bta.ls) {
			System.out.println(i);
		}
	}

}
