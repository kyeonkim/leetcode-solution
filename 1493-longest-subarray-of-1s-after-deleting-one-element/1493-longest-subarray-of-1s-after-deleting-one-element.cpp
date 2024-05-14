class Solution {
public:
    int longestSubarray(vector<int>& nums) {
        int delCnt = 0;
        int s = 0, e = 0;
        int cnt = 0, max = 0;
        while (e < nums.size()) {
            nums[e] == 0 ? delCnt++ : cnt++;
            if (max < cnt)
                max = cnt;
            while (delCnt > 1 && s <= e) {
                nums[s] == 0 ? delCnt-- : cnt--;
                s++;
            }
            e++;
        }
        if (delCnt == 0)
            return max - 1;
        return max;
    }
};