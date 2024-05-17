class Solution {
    public int[] asteroidCollision(int[] ast) {
        Stack<Integer> resAst = new Stack<>();
        for (int i = 0; i < ast.length; i++) {
            while (true) {
                if (resAst.isEmpty()) {
                    resAst.push(ast[i]);
                    break;
                } else {
                    int t = resAst.peek();
                    if (t > 0 && ast[i] < 0) {
                        int left = Math.abs(t), right = Math.abs(ast[i]);
                        if (left == right) {
                            resAst.pop();
                            break;
                        }
                        else if (left > right) 
                            break;
                        else 
                            resAst.pop();
                    } else {
                        resAst.push(ast[i]);
                        break;
                    }
                }
            }
        }
        int[] ans = new int[resAst.size()];
        for (int i = ans.length - 1; i >= 0; i--)
            ans[i] = resAst.pop();
        return ans;
    }
}