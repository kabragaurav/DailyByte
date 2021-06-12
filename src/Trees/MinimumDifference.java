/**
 * Given a binary search tree, return the minimum difference between any two nodes in the tree.
 */
package Trees;

import java.util.ArrayList;
import java.util.List;

import Trees.TreeUtils.TreeNode;

public class MinimumDifference {
	
    List<Integer> ls = new ArrayList<>();
    
    private void traverse(TreeNode<Integer> root) {
        if(root == null)    
            return;
        traverse(root.left);
        ls.add(root.val);
        traverse(root.right);
        
    }
    
    
    public int getMinimumDifference(TreeNode<Integer> root) {
        traverse(root);
        
        int mini = Integer.MAX_VALUE, diff;
        
        for(int i=0; i<ls.size()-1; i++) {
            diff = ls.get(i+1) - ls.get(i);
            mini = Math.min(mini, diff);
        }
        return mini;
    }
    
    // helper method to main
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
		
		MinimumDifference md = new MinimumDifference();
		System.out.println(md.getMinimumDifference(root));

	}

}
