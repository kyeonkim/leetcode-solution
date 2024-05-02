class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefix = new int[nums.length];
        int[] suffix = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            prefix[i] = 1;
            suffix[i] = 1;
        }
        prefix[0] = nums[0];
        suffix[nums.length - 1] = nums[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            prefix[i] = nums[i] * prefix[i - 1];
            suffix[nums.length - 1 - i] = nums[nums.length - i - 1] * suffix[nums.length - i];
        }
        int[] product = new int[nums.length];
        product[0] = suffix[1];
        product[nums.length - 1] = prefix[nums.length - 2];
        for (int i = 1; i < nums.length - 1; i++)
            product[i] = prefix[i - 1] * suffix[i + 1];
        return product;
    }
}