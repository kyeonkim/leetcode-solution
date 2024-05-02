class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        String vowels = "aeiouAEIOU";
        int start = 0, end = chars.length - 1;
        while (start < end) {
            while (start < end && vowels.indexOf(chars[start]) == -1)
                start++;
            while (start < end && vowels.indexOf(chars[end]) == -1)
                end--;
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
        String result = new String(chars);
        return result;
    }
}