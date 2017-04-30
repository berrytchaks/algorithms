package test.questions;

import java.util.Stack;

public class ParenthesisChecker {
	
	public boolean checkParenthesis(String statement){
		Stack<Character> stack = new Stack<>();
		if (statement == null) 
			return false;
		for (int i = 0; i < statement.length(); i++){
			if (statement.charAt(i)=='('){
				stack.push('(');
			}
			if (statement.charAt(i) == ')'){
				if (stack.isEmpty()){
					return false;
				}else{
					stack.pop();
				}
			}
		}
		if (stack.isEmpty()){
			return true;
		}else {
			return false;
		}
	}
	
	
	public static void main(String[] args) {
		ParenthesisChecker parenthesisChecker = new ParenthesisChecker();
		String statement = "((()))";
		boolean status=parenthesisChecker.checkParenthesis(statement);
		if (status)
			System.out.println("The statement "+statement+" has correct parenthesis");
		else {
			System.out.println("The statement "+statement+" does not has correct parenthesis");
		}
	}

}
