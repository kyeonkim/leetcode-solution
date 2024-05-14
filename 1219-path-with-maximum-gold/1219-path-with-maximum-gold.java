class Solution {
    public int getMaximumGold(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int maxGold = 0;
        for (int i = 0, gold = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    gold = dfs(grid, i, j, new boolean[m][n], 0, 0);
                    if (maxGold < gold)
                        maxGold = gold;
                }
            }
        }
        return maxGold;
    }

    private int dfs(int[][] grid, int i, int j, boolean[][] visited, int gold, int maxGold) {
        int m = grid.length, n = grid[0].length;
        if (grid[i][j] == 0 || visited[i][j] == true) return maxGold;
        visited[i][j] = true;
        gold += grid[i][j];
        if (maxGold < gold)
            maxGold = gold;
        if (0 <= i - 1)
            maxGold = dfs(grid, i - 1, j, visited, gold, maxGold); // up
        if (i + 1 < m)
            maxGold = dfs(grid, i + 1, j, visited, gold, maxGold); // down
        if (0 <= j - 1)
            maxGold = dfs(grid, i, j - 1, visited, gold, maxGold); // left
        if (j + 1 < n)
            maxGold = dfs(grid, i, j + 1, visited, gold, maxGold); // right
        visited[i][j] = false;
        return maxGold;
    }
}
// 79
// [18, 0,28,21, 0, 0,21],
// [19, 0, 0,11, 0, 13,0],
// [ 0, 0,17, 2, 9, 0,25],
// [22, 0, 0, 0, 0, 0, 0],
// [18,29, 0, 0, 7, 6, 0],
// [ 8, 0, 0, 0, 5, 0, 0]