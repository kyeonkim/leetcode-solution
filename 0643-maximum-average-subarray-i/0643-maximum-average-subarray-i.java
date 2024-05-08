class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double max = -Double.MAX_VALUE, sum;
        int[] prefix = new int[nums.length];
        prefix[0] = nums[0];
        for (int i = 1; i < prefix.length; i++)
            prefix[i] = nums[i] + prefix[i - 1];
        for (int i = k - 1; i < nums.length; i++) {
            if (i - k < 0)
                sum = prefix[i];
            else
                sum = prefix[i] - prefix[i - k];
            if (max < sum / k)
                max = sum / k;
        }
        return max;
    }
}