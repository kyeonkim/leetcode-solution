class Solution {
    public int findMaxK(int[] nums) {
        if (nums.length == 1)
            return -1;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i] * -1;
            for (int j = nums.length - 1; j > 0; j--) {
                if (num == nums[j])
                    return num;
            }
        }
        return -1;
    }
}