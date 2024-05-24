class Solution {
    private int[] freq;
    private int maxSum;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        maxSum = 0;
        freq = new int[26];
        for (char c: letters)
            freq[c - 'a']++;
        backtrack(words.length - 1, words, score, new int[26], 0);
        return maxSum;
    }

    private void backtrack(int cur, String[] words, int[] score, int[] subsetLetters, int total) {
        if (cur == -1) {
            maxSum = Math.max(maxSum, total);
            return;
        }
        backtrack(cur - 1, words, score, subsetLetters, total);
        int size = words[cur].length();
        for (int i = 0; i < size; i++) {
            int c = words[cur].charAt(i) - 'a';
            subsetLetters[c]++;
            total += score[c];
        }
        if (isValidWord(subsetLetters))
            backtrack(cur - 1, words, score, subsetLetters, total);
        for (int i = 0; i < size; i++) {
            int c = words[cur].charAt(i) - 'a';
            subsetLetters[c]--;
            total -= score[c];
        }
    }

    private boolean isValidWord(int[] subsetLetters) {
        for (int c = 0; c < 26; c++) {
            if (freq[c] < subsetLetters[c]) {
                return false;
            }
        }
        return true;
    }
}