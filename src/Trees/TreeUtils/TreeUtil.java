package Trees.TreeUtils;

/**
 * @author gaurav kabra
 * @since June 16, 2021
 * 
 * Util class having methods related to trees
 */

public class TreeUtil {
	
	// helper method for getDummyBinarySearchTree()
	private static TreeNode<Integer> getTreeNode(Integer val) {
	    TreeNode<Integer> treeNode = new TreeNode<Integer>(val);
		return treeNode;
	}
	
	/**
	 * @return TreeNode root of a sample binary search tree (BST)
	 */
	public static TreeNode getDummyBinarySearchTree() {
		
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
		
		return root;
	}

}
