class Solution {
    public int longestPalindrome(String s) {
        int[] letters = new int[53];
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (Character.isUpperCase(ch))
                letters[ch - 'A']++;
            else
                letters[ch - 'A' - 5]++;
        }

        int isExistOdd = 0;

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] % 2 == 1) {
                isExistOdd = 1;
                break;
            }
        }

        int longestLen = 0;

        for (int i = 0; i < letters.length; i++) {
            if (letters[i] % 2 == 1)
                longestLen += letters[i] - 1;
            else 
                longestLen += letters[i];
        }
        return longestLen + isExistOdd;
    }
}