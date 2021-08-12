package edu.miracosta.cs113;

import java.io.Serializable;
import java.util.Scanner;

public class BinaryTree<E>  implements Serializable
{
	protected Node<E> root;
	
	/*constructs an empty binary tree*/
	public BinaryTree() //constructor with no param
	{
		root = null;  //sets the data field to null
	}
	
	/*The constructor that creates a tree with a given node at the root:*/
	protected BinaryTree(Node<E> root) 
	{
		this.root= root; 
	}
	
	/*The constructor that builds a tree from a data value and two trees:
	 * 
	 * Constucts a new binary tree w/ data in its root leftTree as its left subtree 
	 * and rightTree as its right subtree */
	public BinaryTree(E data, BinaryTree<E> leftTree,BinaryTree<E> rightTree) 
	{
		root = new Node<E>(data); 
		if (leftTree != null) 
		{
			root.left= leftTree.root;
		} 
		else 
		{
			root.left = null;
		}
		if (rightTree != null) 
		{
			root.right = rightTree.root;
		} 
		else 
		{
			root.right = null;
		}
	}
	
	/* method to get leftSubTree
	 * 
	 * Return leftSubTree 
	 * @return The left subTree or null if either the 
	 * root or the left subtree is null */
	
	public BinaryTree<E> getLeftSubtree() 
	{
		if (root != null && root.left != null) 
		{
			return new BinaryTree<E>(root.left); //return left subtree
		}   
		else 
		{
			return null;
		}
	}
	
	/* method to get rightSubTree
	 * 
	 * Return right sub tree 
	 * @return The right subTree or null if either the 
	 * root or the right subtree is null */
	public BinaryTree<E> getRightSubTree() 
	{
		if (root != null && root.right != null) 
		{
			return new BinaryTree<E>(root.right); //returns the right subtree
		}   
		else 
		{
			return null;
		}
	}
	
	/* retunrs true if the tree is a leaf, false if it is not
	 * 
	 *  Determine whether this is a leaf 
	 *  @return true if root has no children  */
	public boolean isLeaf() 
	{
		return (root.left == null && root.right == null);
	}
	
	/* The toString method generates a string representing a preorder traversal 
	 * in which each local root is indented a distance proportional to its depth */
	public String toString() 
	{
		StringBuilder sb = new StringBuilder();
		preOrderTraverse(root, 1, sb);
		return sb.toString();
	}
	/* Performs a preorder traversal of the subtree whose root is node. Appends 
	 * the rep to the StringBuilder. Increments the value of depth (the current tree level)
	 * 
	 * @param node The local root 
	 * @param depth the depth
	 * @param sb The string buffer to save the output 
	 * */
	private void preOrderTraverse(Node<E> node, int depth, StringBuilder sb)
	{
		for (int i = 1; i < depth; i++) 
		{
			sb.append("  ");
		}
		if (node == null) 
		{
			sb.append("null\n");
		} 
		else 
		{
			sb.append(node.toString()); 
			preOrderTraverse(node.left, depth + 1, sb); //Increments the value of depth (the current tree level)
			preOrderTraverse(node.right, depth + 1, sb);
		}
	}
	
	/* If we use a Scanner to read the individual lines created by the toStringand 
	 * preOrderTraversemethods, we can reconstruct the tree 
	 * 
	 * 1.Read a line that represents information at the root
	 * 2.Remove the leading and trailing spaces using String’s trim()
	 * 3.ifit is "null"
	 * 4.return nullelse
	 * 5.recursively read the left child
	 * 6.recursively read the right child
	 * 7.return a tree consisting of the root and the two children
	 * */
	public static BinaryTree<String> readBinaryTree(Scanner scan) 
	{
		String data = scan.next();
		if (data.equals("null")) 
		{
			return null;
		} 
		else 
		{
			BinaryTree<String> leftTree = readBinaryTree(scan);
			BinaryTree<String> rightTree = readBinaryTree(scan);
			return new BinaryTree<String>(data, leftTree,rightTree);
		}
	}
	
	/* return the data */
	public Object getData() 
	{
		return root.data;
	}
	
	/* Just as for a linked list, a node consists of a data part 
	 * and links to successor nodes 
	 * 
	 * A binary tree node must have links to both its left and right
	 * subtrees*/
	protected static class Node<E> implements Serializable
	{
		protected E data;
		
		protected Node<E> left;
		
		protected Node<E> right;
		
		public Node(E data) 
		{
			this.data= data;
			this.left= null;
			this.right= null;
		}
		
		public String toString() 
		{
			return data.toString();
		}
	}
}
