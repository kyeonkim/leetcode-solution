class Solution {
    public String removeStars(String s) {
        Stack<Character> str = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*' && !str.isEmpty()) str.pop();
            else str.push(ch);
        }
        StringBuilder ans = new StringBuilder();
        while (!str.isEmpty())
            ans.append(str.pop());
        return ans.reverse().toString();
    }
}