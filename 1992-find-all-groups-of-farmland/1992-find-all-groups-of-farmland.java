class Solution {
    public int[][] findFarmland(int[][] land) {
        ArrayList<int[]> answer = new ArrayList<>();
        boolean[][] visited = new boolean[land.length][land[0].length];

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    int[] topLeft = findTopLeft(land, i, j);
                    int[] bottomRight = findBottomRight(land, i, j);
                    answer.add(new int[]{topLeft[0], topLeft[1], bottomRight[0], bottomRight[1]});
                    markVisited(visited, topLeft, bottomRight);
                }
            }
        }
        return answer.toArray(new int[answer.size()][]);
    }

    private int[] findTopLeft(int[][] land, int row, int col) {
        int r = row, c = col;
        while (r >= 0 && land[r][col] == 1)
            r--;
        while (c >= 0 && land[row][c] == 1)
            c--;
        return new int[]{r + 1, c + 1};
    }

    private int[] findBottomRight(int[][] land, int row, int col) {
        int r = row, c = col;
        while (r < land.length && land[r][col] == 1)
            r++;
        while (c < land[row].length && land[row][c] == 1)
            c++;
        return new int[]{r - 1, c - 1};
    }

    private void markVisited(boolean[][] visited, int[] topLeft, int[] bottomRight) {
        for (int i = topLeft[0]; i <= bottomRight[0]; i++) {
            for (int j = topLeft[1]; j <= bottomRight[1]; j++) {
                visited[i][j] = true;
            }
        }
    }
}
