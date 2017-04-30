package test.questions;

public class MaxSumArrayOrderN {

	private int maxSum(int[] arr){
		int maxSofar=0, maxEndingHere = 0;
		for(int i = 0; i < arr.length; i++){
			maxEndingHere = maxEndingHere + arr[i];
			if(maxEndingHere < 0){
				maxEndingHere = 0;
			}
			if (maxSofar < maxEndingHere){
				maxSofar = maxEndingHere;
			}
		}
		return maxSofar;
	}
	
	public static void main(String[] args) {
		MaxSumArrayOrderN sum = new MaxSumArrayOrderN();
		int[] arr = new int[]{-2, -3, 4, -1, 2, -1, -4, -3};
		System.out.println("Max sum is "+sum.maxSum(arr));
	}

}
