class Solution {
    public String mergeAlternately(String word1, String word2) {
        int word1Size = word1.length(), word2Size = word2.length();
        int size = word1Size < word2Size ? word2Size : word1Size;
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (i < word1Size)
                result.append(word1.charAt(i));
            if (i < word2Size)
                result.append(word2.charAt(i));
        }
        return result.toString();
    }
}