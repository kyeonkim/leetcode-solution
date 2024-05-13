class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // row
        for (int i = 0; i < m; i++) {
            if (grid[i][0] == 0) {
                for (int j = 0; j < n; j++)
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
            }
        }
        // col
        for (int j = 0, cnt; j < n; j++) {
            cnt = 0;
            for (int i = 0; i < m; i++)
                cnt += grid[i][j] == 1 ? 1 : 0;
            if (cnt < m - cnt) {
                for (int i = 0; i < m; i++)
                    grid[i][j] = grid[i][j] == 0 ? 1 : 0;
            } 
        }
        // convert decimalNumber
        int ans = 0;
        for (int i = 0, decimalNumber; i < m; i++) {
            decimalNumber = 1;
            for (int j = n - 1; j >= 0; j--) {
                ans += grid[i][j] * decimalNumber;
                decimalNumber *= 2;
            }
        }
        return ans;
    }
}