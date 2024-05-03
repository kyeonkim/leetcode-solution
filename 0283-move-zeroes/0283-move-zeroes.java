class Solution {
    public void moveZeroes(int[] nums) {
        int s = 0;
        for (int e = 0; e < nums.length; e++) {
            if(nums[e] != 0) nums[s++] = nums[e];
        }
        while (s < nums.length)
            nums[s++] = 0;
    }
}