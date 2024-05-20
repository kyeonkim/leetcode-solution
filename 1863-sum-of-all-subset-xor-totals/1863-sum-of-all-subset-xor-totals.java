class Solution {
    private int ans;

    public int subsetXORSum(int[] nums) {
        ans = 0;
        backtracking(nums, new boolean[nums.length], 0, 0);
        return ans;
    }

    private void backtracking(int[] nums, boolean[] check, int cur, int sum) {
        for (int i = cur; i < nums.length; i++) {
            if (check[i] == false) {
                check[i] = true;
                ans += sum ^ nums[i];
                backtracking(nums, check, i, sum ^ nums[i]);
                check[i] = false;
            }
        }
    }
}