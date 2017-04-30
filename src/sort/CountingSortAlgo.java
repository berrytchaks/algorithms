package sort;

public class CountingSortAlgo {
	private int[] A;
	private int[] N;
	private int[] F;
	public CountingSortAlgo(int max,int[] arr){
		A =  arr;
		N = new int[max+1];
		F = new int[A.length];
	}
	public static int findMax(int[] arr){
		int max = arr[0];
		for (int i =0; i< arr.length; i++){
			if (max < arr[i])
				max=arr[i];
		}
		return max;
	}
	public void countingSort(){
		for (int i = 0; i < A.length; i++){
			N[A[i]] = N[A[i]] + 1;
		}
		for (int i = 1; i < N.length; i++){
			N[i] = N[i] + N[i-1];
		}
		for (int j = A.length-1; j >= 0; j--){
			F[N[A[j]]-1] = A[j];
			N[A[j]]--;
		}
	}

	public static void main(String[] args) {
		int arrInt[] = { 3, 6, 4, 18, 4, 9, 7, 8, 16, 12, 11, 15, 24,4,1 };
		int max =findMax(arrInt);
		System.out.println("max = "+max);
		CountingSortAlgo coSortAlgo = new CountingSortAlgo(max,arrInt);
		coSortAlgo.countingSort();
		for (int i = 0; i < coSortAlgo.F.length; i ++){
			System.out.print(coSortAlgo.F[i]+" ");
		}
	}

}
