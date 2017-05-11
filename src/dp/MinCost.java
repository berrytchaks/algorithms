package dp;

/**
 * 
 * @author berrytchaks
 * 
 *         Minimum Cost problem
 */
public class MinCost {

	private int min(int x, int y, int z) {
		if (x < y) {
			return (x < z) ? x : z;
		} else {
			return (y < z) ? y : z;
		}
	}

	// This a naive solution which compute subproblems many times
	private int minCost(int[][] cost, int m, int n) {
		if (m < 0 || n < 0) {
			return Integer.MAX_VALUE;
		} else if (m == 0 && n == 0) {
			return cost[m][n];
		} else {
			return cost[m][n] + min(minCost(cost, m - 1, n - 1), minCost(cost, m - 1, n), minCost(cost, m, n - 1));
		}

	}

	// Optimal solution with dynamic programming
	private int minCostOptimal(int[][] cost, int m, int n) {
		int[][] tc = new int[cost.length][cost[0].length];

		// initialize the if case of tc
		tc[0][0] = cost[0][0];

		// Compute the minimum cost the first line of tc
		for (int i = 1; i < cost.length; i++) {
			tc[0][i] = tc[0][i-1] + cost[0][i];
		}
		// Compute the minimum cost  the first column of tc
		for (int i = 1; i < cost[0].length; i++) {
			tc[i][0] = tc[i-1][0] + cost[i][0];
		}
		// Compute the minimum cost of the rest of the matrix
		for (int i = 1; i < cost.length; i++){
			for (int j = 1; j < cost[0].length; j++){
				tc[i][j] = min(tc[i-1][j-1],tc[i-1][j],tc[i][j-1]) + cost[i][j];
			}
		}
		return tc[m][n];
	}

	public static void main(String[] args) {
		int[][] cost = { { 1, 2, 3 }, 
						 { 4, 8, 2 }, 
						 { 1, 5, 3 } };
		MinCost minCost = new MinCost();
		int min = minCost.minCost(cost, 2, 1);
		System.out.println("Minimal cost with naive approach "+min);
		System.out.println("Minimal cost with optimal approach "+minCost.minCostOptimal(cost, 2, 1));
	}

}
