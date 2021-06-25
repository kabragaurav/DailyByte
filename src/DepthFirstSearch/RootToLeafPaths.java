/**
 * Given a binary tree, print all paths from root to leaf paths 
 * (including one node only once in a path).
 */
package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

import Trees.TreeUtils.TreeNode;
import Trees.TreeUtils.TreeUtil;


public class RootToLeafPaths {
	
	private void getRootToLeafPaths(TreeNode<Integer> root, String s) {
		
		if(root == null) {
			System.out.println(s);
			return;
		}
		else if(root.left == null && root.right == null) {
			System.out.println(s + root.val);
		}
		if(root.left != null) {
			String s1  = s + root.val + "->";
			getRootToLeafPaths(root.left, s1);
		}
		
		if(root.right != null) {
			String s2  = s + root.val + "->";
			getRootToLeafPaths(root.right, s2);
		}
	}
	
	
	public static void main(String[] args) {
		
		TreeNode<Integer> root = TreeUtil.getDummyBinarySearchTree();
		RootToLeafPaths rtlp = new RootToLeafPaths();
		rtlp.getRootToLeafPaths(root, new String());
	}
}
