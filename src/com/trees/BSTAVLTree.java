package com.trees;

public class BSTAVLTree {
	static class Node {
		Node left, right;
		int key, height;

		public Node(int key) {
			this.key = key;
			height = 1;
		}
	}

	private Node root;

	private int height(Node node) {
		if (node == null)
			return 0;
		return node.height;
	}

	private int max(int a, int b) {
		if (a > b) {
			return a;
		} else {
			return b;
		}
	}

	private int getBalance(Node node) {
		if (node == null) {
			return 0;
		}
		return height(node.left) - height(node.right);
	}

	private Node rightRotate(Node y) {
		Node x = y.left;
		Node t1 = x.right;
		// Perform rotation
		x.right = y;
		y.left = t1;
		// Update heights
		y.height = max(height(y.left), height(y.right)) + 1;
		x.height = max(height(x.left), height(x.right)) + 1;
		return x;
	}

	private Node leftRotate(Node x) {
		Node y = x.right;
		Node t1 = y.left;
		y.left = x;
		x.right = t1;
		x.height = max(height(x.left), height(x.right)) + 1;
		y.height = max(height(y.left), height(y.right)) + 1;
		return y;
	}

	private Node insert(Node node, int key) {
		// 1- Normal BST insertion
		if (node == null) {
			node = new Node(key);
			return node;
		}
		if (key > node.key) {
			node.right = insert(node.right, key);
		} else if (key < node.key) {
			node.left = insert(node.left, key);
		} else {
			return node;
		}
		
		/* 2- Update height of this ancestor node */
		node.height = 1 + max(height(node.left), height(node.right));
		
		// 3- Check if balance or not
		int balance = getBalance(node);
		// Unbalance implies 4 cases
		// 1 Left Left
		if (balance > 1 && key < node.left.key) {
			return rightRotate(node);
		}
		// 2 Right Right
		if (balance < -1 && key > node.right.key) {
			return leftRotate(node);
		}
		// 3 Left Right
		if (balance > 1 && key > node.left.key) {
			node.left = leftRotate(node.left);
			return rightRotate(node);
		}
		// 4 Right Left
		if (balance < -1 && key < node.right.key) {
			node.right = rightRotate(node.right);
			return leftRotate(node);
		}
		return node;
	}

	private void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.key + " ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}

	public static void main(String[] args) {
        BSTAVLTree tree = new BSTAVLTree();
 
        /* Constructing tree given in the above figure */
        tree.root = tree.insert(tree.root, 10);
        tree.root = tree.insert(tree.root, 20);
        tree.root = tree.insert(tree.root, 30);
        tree.root = tree.insert(tree.root, 40);
        tree.root = tree.insert(tree.root, 50);
        tree.root = tree.insert(tree.root, 25);
 
        /* The constructed AVL Tree would be
             30
            /  \
          20   40
         /  \     \
        10  25    50
        */
        System.out.println("Preorder traversal of constructed tree is : ");
        tree.preOrder(tree.root);
    }

}
