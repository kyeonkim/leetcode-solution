class Solution {
    public int[][] largestLocal(int[][] grid) {
        int[] mask = new int[9];
        int[][] result = new int[grid.length - 2][grid.length - 2];
        for (int i = 2; i < grid.length; i++) {
            for (int j = 2; j < grid.length; j++) {
                mask[0] = grid[i - 2][j - 2];
                mask[1] = grid[i - 2][j - 1];
                mask[2] = grid[i - 2][j];

                mask[3] = grid[i - 1][j - 2];
                mask[4] = grid[i - 1][j - 1];
                mask[5] = grid[i - 1][j];

                mask[6] = grid[i][j - 2];
                mask[7] = grid[i][j - 1];
                mask[8] = grid[i][j];
                Arrays.sort(mask);
                result[i - 2][j - 2] = mask[mask.length - 1];
            }
        }
        return result;
    }
}