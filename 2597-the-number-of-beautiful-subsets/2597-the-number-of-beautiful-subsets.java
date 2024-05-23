class Solution {
    private int count;

    public int beautifulSubsets(int[] nums, int k) {
        count = 0;
        int[] check = new int[1001];
        Arrays.sort(nums);
        for (int i = 1; i < nums.length + 1; i++)
            backtrack(0, nums, check, 0, k, i);
        return count;
    }

    private void backtrack(int start, int[] nums, int[] check, int subsetSize, int k, int size) {
        if (subsetSize == size) {
            count++;
            return;
        }
        for (int i = start; i < nums.length; i++) {
            subsetSize++;
            check[nums[i]]++;
            int absValue = Math.abs(nums[i] - k);
            if (nums[i] < k || check[absValue] == 0)
                backtrack(i + 1, nums, check, subsetSize, k, size);
            check[nums[i]]--;
            subsetSize--;
        }
    }
}