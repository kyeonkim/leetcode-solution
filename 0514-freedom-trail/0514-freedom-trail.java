class Solution {
    public int findRotateSteps(String ring, String key) {
        int n = ring.length();
        int m = key.length();
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++)
            Arrays.fill(dp[i], 100_000_000);
        for(int i = 0; i < n; i++) {
            char ch = ring.charAt(i), keyCh = key.charAt(0);
            if (ch == keyCh)
                dp[0][i] = Math.min(i, n - i);
        }
        for(int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char ch = ring.charAt(j), keyCh = key.charAt(i);
                if (ch == keyCh) {
                    for (int k = 0; k < n; k++) {
                        if (dp[i - 1][k] != -1) {
                            int findIdx = Math.abs(k - j);
                            int value = Math.min(findIdx, n - findIdx) + dp[i - 1][k];
                            dp[i][j] = Math.min(dp[i][j], value);
                        }
                    }
                }
            }
        }
        int turn = 100_000_000;
        for(int i = 0; i < n; i++) {
            if (dp[m - 1][i] < turn)
                turn = dp[m - 1][i];
        }
        return turn + m;
    }
}