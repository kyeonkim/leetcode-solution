class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int size = s.length();
        int[] prefix = new int[size + 1];
        int count = 0;
        int maxCount = 0;

        for (int i = 1; i <= size; i++) {
            prefix[i] = prefix[i - 1] + (vowels.contains(s.charAt(i - 1)) ? 1 : 0);
        }
        for (int i = k; i <= size; i++) {
            count = prefix[i] - prefix[i - k];
            maxCount = Math.max(maxCount, count);
        }
        return maxCount;
    }
}
