class Solution {
    public String[] findRelativeRanks(int[] score) {
        int[] sortedScore = score.clone();
        Arrays.sort(sortedScore);
        sortedScore = reverse(sortedScore);
        Map<Integer, String> board = new HashMap<>();
        for (int i = 0; i < sortedScore.length; i++) {
            if (i == 0)
                board.put(sortedScore[i], "Gold Medal");
            else if (i == 1)
                board.put(sortedScore[i], "Silver Medal");
            else if (i == 2)
                board.put(sortedScore[i], "Bronze Medal");
            else
                board.put(sortedScore[i], Integer.toString(i + 1));
        }
        String[] ranks = new String[score.length];
        for (int i = 0; i < score.length; i++)
            ranks[i] = board.get(score[i]);
        return ranks;
    }

    private int[] reverse(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - 1 - i];
            arr[arr.length - 1 - i] = temp;
        }
        return arr;
    }
}