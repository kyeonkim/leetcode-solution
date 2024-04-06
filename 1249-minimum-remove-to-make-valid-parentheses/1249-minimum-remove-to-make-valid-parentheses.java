class Solution {
    public String minRemoveToMakeValid(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Integer> stack = new Stack<Integer>();
        ArrayList<Integer> addPar = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(i);
            else if (s.charAt(i) == ')') {
                if (!stack.empty()) {
                    addPar.add(stack.peek());
                    addPar.add(i);
                    stack.pop();
                }
            }
        }
        Collections.sort(addPar);
        int addParSize = addPar.size();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == ')') {
                if (addParSize != j && i == addPar.get(j)) {
                    ans.append(s.charAt(i));
                    j++;
                }
            } else {
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
}