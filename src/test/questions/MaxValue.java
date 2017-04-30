package test.questions;

public class MaxValue {

	private void maxValue(int[] arr, int k){
		int max = 0, max2=0;
		for (int i =0; i < k; i++){
			if (max < arr[i]) {
				max = arr[i];
			}
			if (max2< arr[i] && max2 < max && max != arr[i]){
				max2 = arr[i];
			}
		}
		System.out.println(max);
		System.out.println(max2);
	}
	public static void main(String[] args) {
		int arr[] = {12, 1, 78, 90, 57, 89, 56};
		MaxValue mValue = new MaxValue();
		int k = 3;
		mValue.maxValue(arr, k);

	}

}
