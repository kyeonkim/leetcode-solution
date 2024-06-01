class Solution {
    public int scoreOfString(String s) {
        int total = 0;

        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i), prev = s.charAt(i - 1);
            total += Math.abs(cur - prev);
            prev = cur;
        }
        return total;
    }
}