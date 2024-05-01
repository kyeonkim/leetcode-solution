class Solution {
    public String reversePrefix(String word, char ch) {
        Stack<Character> stack = new Stack<>();
        char[] chWord = word.toCharArray();
        int findIdx = -1;
        for (int i = 0; i < chWord.length; i++) {
            if (chWord[i] == ch) {
                stack.push(chWord[i]);
                findIdx = i;
                break;
            }
            stack.push(chWord[i]);
        }
        if (findIdx == -1) 
            return word;
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) 
            result.append(stack.pop());
        for (int i = findIdx + 1; i < chWord.length; i++) 
            result.append(chWord[i]);
        return result.toString();
    }
}