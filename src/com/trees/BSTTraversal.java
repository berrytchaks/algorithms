package com.trees;

/**
 * 
 * @author berrytchaks
 * 
 *	Traversal on a binary search tree and printing it in descending order
 */
public class BSTTraversal {
	private Node root;
	static class Node{
		private Node left, right;
		int data;
		public Node(int data){
			this.data = data;
			left=right=null;
		}
	}
	
	public BSTTraversal(){
		this.root = null;
	}

	private void inOrderTraversal(Node root){
		if (root ==null){
			return;
		}
		inOrderTraversal(root.left);
		System.out.print(root.data+" ");
		inOrderTraversal(root.right);
	}
	private void preOrderTraversal(Node root){
		if (root ==null){
			return;
		}
		System.out.print(root.data+" ");
		preOrderTraversal(root.left);
		preOrderTraversal(root.right);
		
	}
	private void postOrderTraversal(Node root){
		if (root ==null){
			return;
		}
		postOrderTraversal(root.left);
		postOrderTraversal(root.right);
		System.out.print(root.data+" ");
		
	}
	private void inOrderTraversalDescending(Node root){
		if (root ==null){
			return;
		}
		inOrderTraversalDescending(root.right);
		System.out.print(root.data+" ");
		inOrderTraversalDescending(root.left);
		
	}
	private Node insertRec(Node root, int data){
		if(root == null){
			root = new Node(data);
			return root;
		}
		if (root.data > data){
			root.left = insertRec(root.left, data);
		}else if (root.data < data){
			root.right = insertRec(root.right, data);
		}
		return root;
	}
	
	public static void main(String[] args) {
		BSTTraversal bst = new BSTTraversal();
//		Node root = new Node(1);
//		bst.insertRec(root, 2);
//		bst.insertRec(root, 4);
//		bst.insertRec(root, 7);
//		bst.insertRec(root, 3);
		 /* Let us create following BST
        50
     /     \
    30      70
   /  \    /  \
 20   40  60   80 */
		Node root = new Node(50);
		bst.insertRec(root, 50);
		bst.insertRec(root, 30);
		bst.insertRec(root, 20);
		bst.insertRec(root, 40);
		bst.insertRec(root, 70);
		bst.insertRec(root, 60);
		bst.insertRec(root, 80);
		System.out.println("In order Traversal");
		bst.inOrderTraversal(root);
//		System.out.println("In order Traversal descending");
//		bst.inOrderTraversalDescending(root);
		System.out.println();
		System.out.println("Pre order Traversal");
		bst.preOrderTraversal(root);
		System.out.println();
		System.out.println("Post order Traversal");
		bst.postOrderTraversal(root);
		System.out.println();
		System.out.println("In order Traversal descending");
		bst.inOrderTraversalDescending(root);

	}

}
