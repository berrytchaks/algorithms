package sort;

import java.util.Arrays;

public class QuickSort {

	public static void main(String[] args) {
		int[] x = { 9, 2, 4, 7, 3, 7, 10 };
		System.out.println(Arrays.toString(x));
 
		int low = 0;
		int high = x.length - 1;
		QuickSort sort = new QuickSort();
		sort.quickSort(x, low, high);
		System.out.println(Arrays.toString(x));

	}
	private void quickSort(int[] arr,int low, int high){
		if (arr == null || arr.length == 0)
			return;
		if (low>=high){
			return;
		}
		int middle = low +(high - low)/2;
		int pivot = arr[middle];
		int i = low, j = high;
		while (i <= j){
			while (arr[i]<pivot){
				i++;
			}
			while(arr[j]>pivot){
				j--;
			}
			if (i <= j){
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
		if (low<j){
			quickSort(arr, low, j);
		}
		if(i<high){
			quickSort(arr, i, high);
		}
	}
}
