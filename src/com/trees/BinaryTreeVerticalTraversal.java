package com.trees;

public class BinaryTreeVerticalTraversal {
	private Node root;
	private Values val = new Values();
	static class Node{
		private int key;
		private Node left,right;
		public Node(int data) {
			this.key = data;
			left = right = null;
		}
	}
	static class Values{
		int min,max;
	}
	private void findMaxMin(Node root, Values min, Values max, int hd){
		if (root == null)
			return;
		if (hd < min.min){
			min.min = hd;
		}
		if (hd > max.max){
			max.max = hd;
		}
		findMaxMin(root.left, min, max, hd-1);
		findMaxMin(root.right, min, max, hd+1);
	}
	private void printVerticalLine(Node root,int line_no,int hd){
		if (root == null)
			return;
		if (hd == line_no){// if the node is on the line
			System.out.print(root.key+" ");
		}
		printVerticalLine(root.left, line_no, hd-1);
		printVerticalLine(root.right, line_no, hd+1);
	}
	private void verticalOrder(Node node){
		//find the max and min vertical line wrt to root
		findMaxMin(root, val, val, 0);
		for (int line_no = val.min; line_no <= val.max;line_no++){
			printVerticalLine(root, line_no, 0);
			System.out.println();
		}
	}
	 // Driver program to test the above functions
    public static void main(String args[])  {
        BinaryTreeVerticalTraversal tree = new BinaryTreeVerticalTraversal();
  
        /* Let us construct the tree shown in above diagram */
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);
        tree.root.right.left.right = new Node(8);
        tree.root.right.right.right = new Node(9);
  
        System.out.println("vertical order traversal is :");
        tree.verticalOrder(tree.root);
    }

}
