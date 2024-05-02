class Solution {
    public String reverseVowels(String s) {
        char[] chars = s.toCharArray();
        Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u'));
        int start = 0, end = chars.length - 1;
        while (start < end) {
            while (start < end && !vowels.contains(Character.toLowerCase(chars[start])))
                start++;
            while (start < end && !vowels.contains(Character.toLowerCase(chars[end])))
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