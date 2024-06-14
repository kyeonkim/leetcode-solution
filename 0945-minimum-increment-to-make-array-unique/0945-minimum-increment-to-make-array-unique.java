class Solution {
    public int minIncrementForUnique(int[] nums) {
        Arrays.sort(nums);
        
        int moves = 0;
        for (int i = 1, increment; i < nums.length; i++) {
            increment = 0;
            if (nums[i] <= nums[i - 1]) {
                increment = nums[i - 1] - nums[i] + 1;
                moves += increment;
                nums[i] += increment;
            }
        }
        return moves;
    }
}