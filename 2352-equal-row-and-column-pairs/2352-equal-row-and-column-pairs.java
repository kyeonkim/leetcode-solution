class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> roww = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String row = createRow(grid[i]);
            roww.put(row, roww.getOrDefault(row, 0) + 1);
        }
        Map<String, Integer> coll = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String col = createCol(grid, i);
            coll.put(col, coll.getOrDefault(col, 0) + 1);
        }
        int answer = 0;
        for (String key : roww.keySet()) {
            if (coll.containsKey(key))
                answer += roww.get(key) * coll.get(key);
        }
        return answer;
    }

    private String createRow(int[] row) {
        StringBuilder rowStr = new StringBuilder();
        for (int i = 0; i < row.length; i++)
            rowStr.append(row[i] + '0');
        return rowStr.toString();
    }

    private String createCol(int[][] grid, int start) {
        StringBuilder colStr = new StringBuilder();
        for (int i = 0; i < grid.length; i++)
            colStr.append(grid[i][start] + '0');
        return colStr.toString();
    }
}