class Solution {
    List<List<Integer>> sets = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        sets.add(new ArrayList<>());
        for (int i = 0; i < nums.length; i++) {
            List<Integer> set = new ArrayList<>();
            set.add(nums[i]);
            createSubset(nums, set, i + 1);
        }
        return sets;
    }

    private void createSubset(int[] nums, List<Integer> set, int cur) {
        sets.add(new ArrayList<>(set));
        for (int i = cur; i < nums.length; i++) {
            set.add(nums[i]);
            createSubset(nums, set, i + 1);
            set.remove(set.size() - 1);
        }
    }
}