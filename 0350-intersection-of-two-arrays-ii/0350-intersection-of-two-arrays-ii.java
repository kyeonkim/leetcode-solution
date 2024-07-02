class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> numsArr = new HashMap<>();

        for (int num: nums1)
            numsArr.put(num, numsArr.getOrDefault(num, 0) + 1);

        List<Integer> resultList = new ArrayList<>();

        for (int num: nums2) {
            if (numsArr.containsKey(num) && numsArr.get(num) > 0) {
                resultList.add(num);
                numsArr.put(num, numsArr.get(num) - 1);
            }
        }

        int[] result = new int[resultList.size()];

        for (int i = 0; i < resultList.size(); i++)
            result[i] = resultList.get(i);
        return result;
    }
}