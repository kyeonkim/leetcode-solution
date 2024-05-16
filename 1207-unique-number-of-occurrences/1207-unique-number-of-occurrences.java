class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> OccNums = new HashMap<>();
        for (int num : arr)
            OccNums.put(num, OccNums.getOrDefault(num, 0) + 1);
        Set<Integer> uniqueOcc = new HashSet<>();
        for (int key : OccNums.keySet()) {
            int value = OccNums.get(key);
            if (uniqueOcc.contains(value))
                return false;
            uniqueOcc.add(value);
        }
        return true;
    }
}