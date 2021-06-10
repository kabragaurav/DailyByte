/**
 * Given a binary search tree that contains unique values and two nodes within the tree, a, and b, 
 * return their lowest common ancestor. The lowest common ancestor of 
 * two nodes is the deepest node within the tree such that both nodes are descendants of it.
 */
package Trees;
/**
 * @author gaurav kabra
 * @since June 10, 2021
 */
import Trees.TreeUtils.TreeNode;

public class LowestCommonAncestor {
	
	private TreeNode<Integer> lowestCommonAncestorIterative(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        
		/**
         * Time Complexity: O(N), where N is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.
         * Space Complexity: O(1)
         */
		
		while(root != null) {
			if((root.val > p.val) && (root.val > q.val)) {
	            root = root.left;
	        } 
	        else if((root.val < p.val) && (root.val < q.val)) {
	            root = root.right;
	        }
	        return root;
		}
		return root;
    }
	
	
	
	private TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
        
		/**
         * Time Complexity: O(N), where N is the number of nodes in the BST. In the worst case we might be visiting all the nodes of the BST.
         * Space Complexity: O(N). Because the maximum amount of space utilized by the recursion stack would be N since the height of a skewed BST could be N.
         */
		
		if (null == root) {
            return null;
        }
        if((root.val > p.val) && (root.val > q.val)) {
            return lowestCommonAncestor(root.left, p, q);
        } 
        else if((root.val < p.val) && (root.val < q.val)) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
	
	private static TreeNode<Integer> getTreeNode(Integer val) {
	    TreeNode<Integer> treeNode = new TreeNode<Integer>(val);
		return treeNode;
	}
	
	// driver - main method
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
		
		// TESTCASES
		LowestCommonAncestor lca = new LowestCommonAncestor();
		System.out.println(lca.lowestCommonAncestor(root, two, eight).val);
		System.out.println(lca.lowestCommonAncestorIterative(root, two, eight).val);
		
	}

}
