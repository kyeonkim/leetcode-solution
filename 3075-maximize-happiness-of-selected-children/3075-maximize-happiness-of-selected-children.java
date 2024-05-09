class Solution {
    public long maximumHappinessSum(int[] happiness, int k) {
        Arrays.sort(happiness);
        int decreasesValue = 0;
        long maxHappy = 0;
        for (int i = happiness.length - 1; i >= happiness.length - k; i--)
            maxHappy += Math.max(happiness[i] - decreasesValue++, 0);
        return maxHappy;
    }
}