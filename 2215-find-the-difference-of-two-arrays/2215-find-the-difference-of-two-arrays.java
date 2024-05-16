class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> nums1Set = numsToSet(nums1);
        Set<Integer> nums2Set = numsToSet(nums2);
        List<List<Integer>> answer = new ArrayList<>();
        answer.add(createArr(nums1Set, nums2Set));
        answer.add(createArr(nums2Set, nums1Set));
        return answer;
    }

    private Set<Integer> numsToSet(int[] nums) {
        Set<Integer> numsSet = new HashSet<>();
        for (int num : nums)
            numsSet.add(num);
        return numsSet;
    }

    private List<Integer> createArr(Set<Integer> nums1, Set<Integer> nums2) {
        List<Integer> notPresentNums = new ArrayList<>();
        for (int num : nums1) {
            if (!nums2.contains(num))
                notPresentNums.add(num);
        }
        return notPresentNums;
    }
}