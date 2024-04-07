class Solution {
    public boolean checkValidString(String s) {
        int starCnt = 0;
        int rightParIdx = 0, starIdx = -1;
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                stack.push(c);
                rightParIdx = i;
            } else if (c == ')') {
                if (!stack.empty())
                    stack.pop();
                else if (starCnt != 0)
                    starCnt--;
                else
                    return false;
            } else if (c == '*') {
                starCnt++;
                starIdx = i;
            }
        }
        if (starCnt - stack.size() >= 0 && (rightParIdx < starIdx || starIdx == -1))
            return true;
        return false;
    }
}