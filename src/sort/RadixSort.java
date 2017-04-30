package sort;

public class RadixSort {
	public static int findMax(int[] arr){
		int max = arr[0];
		for (int i =0; i< arr.length; i++){
			if (max < arr[i])
				max=arr[i];
		}
		return max;
	}
	
	static void radixSort(int[] arr, int n){
		int m = findMax(arr);
		for (int exp = 1; m/exp >0; exp =exp*10){
			countSort(arr, exp, m);
		} 
	}
	
	static void countSort(int[] arr, int exp,int max){
		int[] temp = new int[arr.length];
		int[] count = new int[max+1];
		for(int i = 0; i < arr.length; i++){
			count[(arr[i]/exp)%10 ] = count[(arr[i]/exp)%10 ] +1;
		}
		for (int i = 1; i < count.length; i++){
			count[i] = count[i]+count[i-1];
		}
		for(int j = arr.length-1; j>=0;j--){
			temp[count[(arr[j]/exp)%10]-1] = arr[j];
			count[(arr[j]/exp)%10]--;
		}
		for(int i = 0; i < arr.length; i++){
			arr[i] = temp[i];
		}
	}

	static void print(int arr[], int n) {
		for (int i = 0; i < n; i++)
			System.out.print(arr[i] + " ");
	}

	public static void main(String[] args) {
		int arr[] = { 170, 45, 75, 90, 802, 24, 2, 66 };
		int n = arr.length;
		radixSort(arr, n);
		print(arr, n);
	}
}
