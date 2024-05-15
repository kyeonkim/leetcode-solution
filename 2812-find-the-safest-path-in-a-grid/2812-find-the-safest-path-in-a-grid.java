class Solution {
    private int[] roww = {0, 0, -1, 1};
    private int[] coll = {-1, 1, 0, 0};
    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();
        if (grid.get(0).get(0) == 1 || grid.get(n - 1).get(n - 1) == 1)
            return 0;
        int[][] score = new int[n][n];
        for (int[] row : score)
            Arrays.fill(row, Integer.MAX_VALUE);
        bfs(grid, score, n);
        
        boolean[][] visited = new boolean[n][n];
        PriorityQueue<int[]> highpq = new PriorityQueue<>((a, b) -> b[0] - a[0]);
        highpq.offer(new int[]{score[0][0], 0, 0});

        while (!highpq.isEmpty()) {
            int[] t = highpq.poll();
            int safe = t[0];
            int r = t[1], c = t[2];

            if (r == n - 1 && c == n - 1)
                return safe;
            visited[r][c] = true;

            for (int i = 0; i < 4; i++) {
                int newR = r + roww[i];
                int newC = c + coll[i];

                if (newR >= 0 && newR < n && newC >= 0 && newC < n && !visited[newR][newC]) {
                    int s = Math.min(safe, score[newR][newC]);
                    highpq.offer(new int[]{s, newR, newC});
                    visited[newR][newC] = true;
                }
            }
        }
        return -1;
    }

    private void bfs(List<List<Integer>> grid, int[][] score, int n) {
        Queue<int[]> q = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    score[i][j] = 0;
                    q.offer(new int[]{i, j});
                }
            }
        }

        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0], y = t[1];
            int s = score[x][y];

            for (int i = 0; i < 4; i++) {
                int newX = x + roww[i];
                int newY = y + coll[i];

                if (newX >= 0 && newX < n && newY >= 0 && newY < n && score[newX][newY] > 1 + s) {
                    score[newX][newY] = 1 + s;
                    q.offer(new int[]{newX, newY});
                }
            }
        }
    }
}