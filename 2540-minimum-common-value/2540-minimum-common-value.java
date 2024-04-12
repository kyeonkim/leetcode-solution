class Solution {
    public int getCommon(int[] nums1, int[] nums2) {
        for (int i = 0; i < nums2.length; i++) {
            int idx = Arrays.binarySearch(nums1, nums2[i]);
            if (idx > 0)
                return nums2[i];
        }
        return -1;
    }
}