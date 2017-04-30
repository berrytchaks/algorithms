package dp;

/**
 * 
 * @author berrytchaks
 *	
 * Minimum Cost problem
 */
public class MinCost {
	
	private int min (int x, int y, int z){
		if (x < y){
			return (x < z) ? x:z;
		}else{
			return (y < z) ? y:z;
		}
	}
	private int minCost(int[][] cost, int m, int n){
		if (m <0 || n <0){
			return Integer.MAX_VALUE;
		}else if (m == 0 && n==0){
			return cost[m][n];
		}else{
			return cost[m][n] + min(minCost(cost,m-1,n-1),
									minCost(cost,m-1,n),
									minCost(cost,m,n-1));
		}
		
	}

	public static void main(String[] args) {
		int[][] cost = { {1, 2, 3},
                		 {4, 8, 2},
                		 {1, 5, 3} };
		MinCost minCost = new MinCost();
		int min =minCost.minCost(cost, 2, 1);	
		System.out.println(min);

	}

}
