package com.trees;

/**
 * 
 * @author berrytchaks
 * 
 * Inorder, preorder and postorder traversal of a Binary Search Tree
 *
 */
public class BinaryTree {
	// Root of Binary Tree
	Node root;

	static class Node {
		private Node left, right;
		int key;

		public Node(int data) {
			this.key = data;
			left = right = null;
		}
	}

	BinaryTree() {
		root = null;
	}

	/*
	 * Given a binary tree, print its nodes according to the "bottom-up"
	 * postorder traversal.
	 */
	void printPostorder(Node node) {
		if (node == null)
			return;

		// first recur on left subtree
		printPostorder(node.left);

		// then recur on right subtree
		printPostorder(node.right);

		// now deal with the node
		System.out.print(node.key + " ");
	}

	/* Given a binary tree, print its nodes in inorder */
	void printInorder(Node node) {
		if (node == null)
			return;

		/* first recur on left child */
		printInorder(node.left);

		/* then print the data of node */
		System.out.print(node.key + " ");

		/* now recur on right child */
		printInorder(node.right);
	}

	/* Given a binary tree, print its nodes in preorder */
	void printPreorder(Node node) {
		if (node == null)
			return;

		/* first print data of node */
		System.out.print(node.key + " ");

		/* then recur on left sutree */
		printPreorder(node.left);

		/* now recur on right subtree */
		printPreorder(node.right);
	}

	// Wrappers over above recursive functions
	void printPostorder() {
		printPostorder(root);
	}

	void printInorder() {
		printInorder(root);
	}

	void printPreorder() {
		printPreorder(root);
	}

	private Node insertRec(Node root, int data) {
		if (root == null) {
			root = new Node(data);
			return root;
		}
		if (root.key > data) {
			root.left = insertRec(root.left, data);
		} else if (root.key < data) {
			root.right = insertRec(root.right, data);
		}
		return root;
	}

	// Driver method
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree();
		tree.root = new Node(50);
		tree.insertRec(tree.root, 30);
		tree.insertRec(tree.root, 20);
		tree.insertRec(tree.root, 40);
		tree.insertRec(tree.root, 70);
		tree.insertRec(tree.root, 60);
		tree.insertRec(tree.root, 80);

		System.out.println("Preorder traversal of binary tree is ");
		tree.printPreorder();

		System.out.println("\nInorder traversal of binary tree is ");
		tree.printInorder();

		System.out.println("\nPostorder traversal of binary tree is ");
		tree.printPostorder();
	}
}