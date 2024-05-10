class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        // 배열을 리스트로 변환
        List<int[]> combinations = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                combinations.add(new int[]{arr[i], arr[j]});
            }
        }
        // 비율에 따라 리스트를 정렬
        Collections.sort(combinations, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                double ratioA = (double) a[0] / a[1];
                double ratioB = (double) b[0] / b[1];
                return Double.compare(ratioA, ratioB);
            }
        });
        // k번째로 작은 비율을 가진 조합 선택
        int[] kthFraction = combinations.get(k - 1);
        return kthFraction;
    }
}
