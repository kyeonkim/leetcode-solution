class Solution {
    public int minOperations(int[] nums, int k) {
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++)
            sum ^= nums[i];
        return Integer.bitCount(sum ^ k);
    }
}