package test.questions;

import java.util.LinkedList;
import java.util.List;

public class MaxSumArray {

	public static void main(String[] args) {
//		int[] array = { 2,-2,-5,6 };
		int[] array = { -2,-3, 4, -1, -2, 1, 5, -3 };
		List<Integer> subarray[][] = new List[array.length][] ;
		for (int i = 0; i < array.length; i++) {
			subarray[i] = new List[array.length];
			for (int j = 0; j < array.length; j++) {
				subarray[i][j] = new LinkedList<Integer>();
			}
		}
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				for (int k = i; k <= j; k++) {
					subarray[i][j].add(array[k]);
					System.out.print(array[k]);
				}
				System.out.println();
			}
		}
		System.out.println("Print sub array for array of list");
		int sum = 0;
		int max = 0;
		List<Integer> subArrayWithMaxSum = new LinkedList<>(); 
		for (int i = 0; i < array.length; i++) {
			for (int j = i; j < array.length; j++) {
				System.out.print(subarray[i][j]);
				System.out.println();
				sum = 0;
				
				for(int item :subarray[i][j]){
					sum = sum+item;
				}
				if (sum > max){
					subArrayWithMaxSum.clear();
					subArrayWithMaxSum.addAll(subarray[i][j]);
					max = sum;
				}
			}
		}
		System.out.println(max);
		System.out.println(subArrayWithMaxSum);
	}

}
