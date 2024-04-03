class Solution {
    public boolean dfs(char[][] board, boolean[][] check, int i, int j, String word, int k) {
        if (k == word.length())
            return true;
        boolean result = false;
        check[i][j] = true;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int[] dir : directions) {
            int newRow = i + dir[0];
            int newCol = j + dir[1];
            if (newRow >= 0 && newRow < board.length 
            && newCol >= 0 && newCol < board[0].length 
            && !check[newRow][newCol] && board[newRow][newCol] == word.charAt(k)) {
                result = result || dfs(board, check, newRow, newCol, word, k + 1);
            }
        }
        check[i][j] = false;
        return result;
    }

    public boolean exist(char[][] board, String word) {
        boolean[][] check = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0) && dfs(board, check, i, j, word, 1)) {
                    return true;
                }
            }
        }
        return false;
    }
}
