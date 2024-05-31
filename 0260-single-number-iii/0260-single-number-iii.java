class Solution {
    public int[] singleNumber(int[] nums) {
        Map<Integer, Integer> numsCnt = new HashMap<>();

        for (int num : nums)
            numsCnt.put(num, numsCnt.getOrDefault(num, 0) + 1);
        int[] ans = new int[2];
        int ansIdx = 0;
        for (int key : numsCnt.keySet()) {
            if (numsCnt.get(key) == 1)
                ans[ansIdx++] = key;
        }
        return ans;
    }
}