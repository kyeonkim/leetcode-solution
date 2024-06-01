class Solution {
    public int scoreOfString(String s) {
        int total = 0;

        char prev = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            char cur = s.charAt(i);
            total += Math.abs(cur - prev);
            prev = cur;
        }
        return total;
    }
}