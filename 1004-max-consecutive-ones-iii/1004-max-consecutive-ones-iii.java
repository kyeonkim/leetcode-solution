class Solution {
    public int longestOnes(int[] nums, int k) {
        int[] flagZero = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                flagZero[i] = 1;
        }
        int s = 0, e = 0;
        int max = 0, cur = 0;
        int cnt = 0;
        while (e < nums.length) {
            if (flagZero[e] == 1)
                cnt++;
            while (cnt > k && s <= e) {
                if (flagZero[s] == 1)
                    cnt--;
                s++;
                cur--;
            }
            cur++;
            e++;
            if (max < cur)
                max = cur;
        }
        return max;
    }
}