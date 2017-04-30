package com.stack;
/**
 * 
 * @author berrytchaks
 *
 *	Sort a stack without using an array.
 */
public class Stack {
	private Node head;

	static class Node {
		int data;
		Node next;

		Node(int d) {
			data = d;
			next = null;
		}
	}

	void push(Node node) {
		Node current = head;
		if (head != null) {
			head = node;
			head.next = current;
		} else {
			head = node;
			head.next = null;
		}
	}

	boolean isEmpty() {
		if (head != null) {
			return false;
		} else {
			return true;
		}
	}

	Integer top() {
		if (head != null) {
			return head.data;
		} else {
			return null;
		}
	}

	Integer pop() {
		Node current = head;
		if (head != null) {
			int data = current.data;
			head = head.next;
			current = null;
			return data;
		} else {
			return null;
		}

	}
	boolean entrance = false;
	void sortStack(Stack stack) {
		int temp = -1;
		if (!stack.isEmpty()) {
			temp = stack.pop();
			sortStack(stack);
			entrance = true;
		}
		if(entrance){
			sortedInsert(stack, temp);
		}
	}

	void sortedInsert(Stack stack, int element) {
		if (stack.isEmpty() || element > stack.top()) {
			stack.push(new Node(element));
		} else {
			int temp = stack.pop();
			sortedInsert(stack, element);
			stack.push(new Node(temp));
		}
	}

	public static void main(String[] args) {
		Stack stack = new Stack();
		/*
		 * stack.push(new Node (3)); stack.push(new Node (4)); stack.push(new
		 * Node (5)); System.out.println(stack.pop()); // 5
		 * System.out.println(stack.pop()); // 4 stack.push(new Node (6));
		 * System.out.println(stack.pop()); // 6
		 * System.out.println(stack.isEmpty()); // false
		 * System.out.println(stack.pop()); // 3
		 * System.out.println(stack.isEmpty()); // true
		 * System.out.println(stack.pop()); // -1
		 */
		stack.push(new Node(-3));
		stack.push(new Node(14));
		stack.push(new Node(18));
		stack.push(new Node(-5));
		stack.push(new Node(30));
		stack.sortStack(stack);
		while (!stack.isEmpty()) {
			System.out.println(stack.pop());
		}

	}

}
