class Solution {
    public int numIslands(char[][] grid) {
        int colLen = grid.length, rowLen = grid[0].length;
        boolean[][] visited = new boolean[colLen][rowLen];
        int answer = 0;
        for (int i = 0; i < colLen; i++) {
            for (int j = 0; j < rowLen; j++)
            if (visited[i][j] == false) {
                if (grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    answer++;
                }
                else
                    visited[i][j] = true;
            }
        }
        return answer;
    }

    public void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (visited[i][j] == true) return ;
        visited[i][j] = true;
        if (0 <= i - 1 && grid[i - 1][j] == '1')                     //up
            dfs(grid, visited, i - 1, j);
        if (i + 1 < grid.length && grid[i + 1][j] == '1')            //down
            dfs(grid, visited, i + 1, j);
        if (0 <= j - 1 && grid[i][j - 1] == '1')                     //left
            dfs(grid, visited, i, j - 1);
        if (j + 1 < grid[i].length && grid[i][j + 1] == '1')         //right
            dfs(grid, visited, i, j + 1);
    }
}