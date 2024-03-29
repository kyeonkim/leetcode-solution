class Solution {
    public long countSubarrays(int[] nums, int k) {
        int maxNum = Arrays.stream(nums).max().getAsInt();
        long answer = 0, cnt = 0;
        int left = 0, right = 0;
        while (right < nums.length) {
            if (nums[right] == maxNum)
                cnt++;
            while (cnt >= k && left < nums.length) {
                answer += 1;
                if (right + 1 != nums.length)
                    answer += nums.length - (right + 1);
                if (nums[left] == maxNum)
                    cnt--;
                left++;
            }
            right++;
        }
        return answer;
    }
}