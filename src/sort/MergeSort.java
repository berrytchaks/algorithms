package sort;

import java.util.Arrays;

public class MergeSort {
	private int[] numbers;
	private int[] helper;
	private int size;
	
	private void sort(int[] array){
		this.numbers = array;
		this.size = array.length;
		this.helper = new int[size];
		mergeSort(0, size-1);
	}
	private void mergeSort(int low, int high){
		if (low < high){
			int middle = low + (high - low)/2;
			// Sort the left side of the array
			mergeSort(low, middle);
			// Sort the right side of the array
			mergeSort(middle+1, high);
			// Combine them both
			merge(low,middle,high);
		}
	}
	private void merge(int low, int middle, int high){
		for (int i = low; i <= high; i++){
			helper[i] = numbers[i];
		}
		int i = low;
		int j = middle +1;
		int k = low;
		while(i <= middle && j <= high){
			if (helper[i] < helper [j]){
				numbers[k] = helper[i];
				i++;
			}else{
				numbers[k] = helper[j];
				j++;
			}
			k++;
		}
		while(i <= middle){
			numbers[k] = helper[i];
			i++;
			k++;
		}
	}
	
	public static void main(String[] args) {
		int[] x = { 9, 2, 4, 7, 3, 7, 10 };
		System.out.println(Arrays.toString(x));
		MergeSort mergeSort = new MergeSort();
		
		mergeSort.sort(x);
		System.out.println(Arrays.toString(x));

	}
	

}
