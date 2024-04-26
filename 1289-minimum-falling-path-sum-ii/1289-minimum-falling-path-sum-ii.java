class Solution {
    public int minFallingPathSum(int[][] grid) {
        int answer = 0;
        int n = grid.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++)
            dp[0][i] = grid[0][i];
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (j == k)
                        continue;
                    if (dp[i][j] == 0)
                        dp[i][j] = dp[i - 1][k] + grid[i][j];
                    else
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][k] + grid[i][j]);
                }
            }
        }
        int min = dp[n - 1][0];
        for (int i = 1; i < n; i++) {
            if (dp[n - 1][i] < min)
                min = dp[n - 1][i];
        }
        return min;
    }
}