class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        int curIdx = 0;

        Arrays.sort(arr1);
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[j] == arr2[i]) {
                    result[curIdx] = arr1[j];
                    curIdx++;
                    arr1[j] = -1;
                }
            }
        }
        for (int num: arr1) {
            if (num != -1) {
                result[curIdx] = num;
                curIdx++;
            }
        }
        return result;
    }
}