package com.problem.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 *        4
 *      /  \
 *     2    5
 *   /  \    \
 *  1    3    6
 *  前序遍历（先根遍历）（421356）：访问节点的操作发生在遍历其左右子树之前：访问根结点->遍历左子树->遍历右子树
 *  中序遍历（中根遍历）（123456）：访问节点的操作发生在遍历其左右子树之中：遍历左子树->访问根结点->遍历右子树
 *  后序遍历（后根遍历）（132654）：访问节点的操作发生在遍历其左右子树之后：遍历左子树->遍历右子树->访问根结点
 */

public class BinaryTreeInorderTraversal {
	//中序遍历：先左结点，再根结点，再右结点
	public List<Integer> inorderTraversal(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		helper(root,res);
		return res;
	}
	public void helper(TreeNode root,List<Integer> res){
		if(root != null){
			if(root.left != null){
				helper(root.left,res);
			}
			res.add(root.val);
			if(root.right != null){
				helper(root.right,res);
			}
		}
	}
	/*
	 * leetcode demo:https://leetcode.com/problems/binary-tree-inorder-traversal/solution/
	 */
	
	public List<Integer> inorderTraversalByStack(TreeNode root){
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack  = new Stack<TreeNode>();
		TreeNode curr = root;
		while(curr != null || !stack.isEmpty()){
			while(curr!=null){
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			res.add(curr.val);
			curr = curr.right;
		}
		return res;
	}
}
