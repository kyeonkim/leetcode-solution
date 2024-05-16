class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] s1 = new int[26];
        int[] s2 = new int[26];
        for (int i = 0; i < word1.length(); i++)
            s1[word1.charAt(i) - 'a']++;
        for (int i = 0; i < word2.length(); i++)
            s2[word2.charAt(i) - 'a']++;
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] == 0 && s2[i] != 0) return false;
            if (s1[i] != 0 && s2[i] == 0) return false;
        }
        Arrays.sort(s1);
        Arrays.sort(s2);
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i])
                return false;
        }
        return true;
    }
}