class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] isVisited = new boolean[n];
        int provincesCnt = 0;

        for (int i = 0; i < n; i++) {
            if (!isVisited[i]) {
                provincesCnt++;
                dfs(isConnected, isVisited, i);
            }
        }
        return provincesCnt;
    }

    private void dfs(int[][] isConnected, boolean[] isVisited, int start) {
        isVisited[start] = true;
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[start][i] == 1 && !isVisited[i])
                dfs(isConnected, isVisited, i);
        }
    }
}