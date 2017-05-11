package dp;

/**
 * 
 * @author berrytchaks
 * 
 * Minimum Cost problem
 */
public class MinCost {

	private int min(int x, int y, int z) {
		if (x < y) {
			return (x < z) ? x : z;
		} else {
			return (y < z) ? y : z;
		}
	}
	
	private int min2(int x, int y) {
		return (x < y) ? x : y;
	}
	
	// from the first cell to a given cell
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

		// initialize the first cell of tc
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
	
	// From a given cell to the bottom cell, given that you can only move right and down
	private int minCostOptimal2(int[][] cost, int m, int n) {
		int row = cost.length, col = cost[0].length;
		int[][] tc = new int[row][col];
		
		// For conviennient let decrement both row and col
		row--;
		col--;
		// initialize the last cell of tc
		tc[row][col] = cost[row][col];

		// Compute the minimum cost the last line of tc
		for (int i = col-1; i >0; i--) {
			tc[row][i] = tc[row][i+1] + cost[row][i];
		}
		// Compute the minimum cost  the last column of tc
		for (int i = row-1; i >=1; i--) {
			tc[i][col] = tc[i+1][col] + cost[i][col];
		}
		// Compute the minimum cost of the rest of the matrix
		for (int i = col-1; i >=1; i--) {
			for (int j = row-1; j >=1; j--) {
				tc[i][j] = min2(tc[i+1][j],tc[i][j+1]) + cost[i][j];
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
		System.out.println("Minimal cost with optimal approach to reach the last cell "+minCost.minCostOptimal2(cost, 1, 1));
	}

}
