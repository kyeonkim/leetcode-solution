class Solution {
    public int islandPerimeter(int[][] grid) {
        int answer = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                int cnt = 4;
                if (grid[i][j] == 1) {
                    if (0 <= i - 1 && grid[i - 1][j] == 1)
                        cnt--;
                    if (i + 1 < grid.length && grid[i + 1][j] == 1)
                        cnt--;
                    if (0 <= j - 1 && grid[i][j - 1] == 1)
                        cnt--;
                    if (j + 1 < grid[i].length && grid[i][j + 1] == 1)
                        cnt--;
                    answer += cnt;
                }
            }
        }
        return answer;
    }
}