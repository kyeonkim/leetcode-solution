class Solution {
    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int s = 0, e = nums.length - 1;
        int cnt = 0;
        while (s < e) {
            if (nums[s] + nums[e] == k)
            {
                cnt++;
                s++;
                e--;
            }
            else if (nums[s] + nums[e] < k)
                s++;
            else
                e--;
        }
        return cnt++;
    }
}