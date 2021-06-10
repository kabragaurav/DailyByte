package Trees.TreeUtils;

/**
 * Implementation of Binary Tree Node
 * @author gaurav kabra
 * @since June 10, 2021
 */

public class TreeNode<T> {
	public T val;
	public TreeNode left;
	public TreeNode right;
	
	public TreeNode(T val) {
		this.val = val;
		this.left = this.right = null;
	}
	
}
