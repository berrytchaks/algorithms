package com.trees;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author berrytchaks
 *
 * Least Common Ancestor
 */
public class LCA {
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
	public LCA(int key){
		root = new Node(key);
	}
	public LCA(){
	}
	List<Integer> path1 = new ArrayList<>();
	List<Integer> path2 = new ArrayList<>();
	
	private boolean findPath(Node root, List<Integer> path, int k){
		if (root == null)
			return false;
		path.add(root.key);
		// See if the k is same as root's key
		if (root.key == k){
			return true;  
		}
		// Check if k is found in left or right sub-tree
		if( root.left!= null && findPath(root.left,path,k)
				|| root.right!= null && findPath(root.right,path,k)
				){
			return true;
		}
		// Not found
		path.clear();
		root = this.root;
		return false;
	}
	private int findLCA(Node root,int n1, int n2){
		if (!findPath(root, path1, n1) 
				||!findPath(root, path2, n2) 
				){
			return -1;
		}
		System.out.println("path1 "+path1 );
		System.out.println("path2 "+path2 );
		// Found
		int i = 1;
		if (path1.size() > path2.size()){
			for (int elm : path1){
				if ( i < path2.size() && elm != path2.get(i)){
//					break;
					return path1.get(i-1);
				}
				i++;
			}
		}else{
			for (int elm : path2){
				if (i < path1.size() && elm != path1.get(i)){
//					break;
					return path2.get(i-1);
				}
				i++;
			}
		}
		path1.clear();
		path2.clear();
		return -1;
	}
	
	public static void main(String[] args) {
		// Let us create the Binary Tree shown in above diagram.
		LCA lca = new LCA();
		lca.root = new Node(1);
		lca.root.left = new Node(2);
		lca.root.right = new Node(3);
		lca.root.left.left = new Node(4);
		lca.root.left.right = new Node(5);
		lca.root.right.left = new Node(6);
		lca.root.right.right = new Node(7);
	    System.out.println( "LCA(4, 5) = " + lca.findLCA(lca.root, 4, 5));
	    System.out.println( "LCA(4, 6) = " + lca.findLCA(lca.root, 4, 6));
	    System.out.println( "LCA(3, 4) = " + lca.findLCA(lca.root, 3, 4));
	    System.out.println( "LCA(2, 4) = " + lca.findLCA(lca.root, 2, 4));

	}

}
