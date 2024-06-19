class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int left = 1, right = Arrays.stream(bloomDay).max().getAsInt();

        while (left < right) {
            int mid = (left + right) / 2;
            if (canMakeBouquets(mid, bloomDay, m, k))
                right = mid;
            else
                left = mid + 1;
        }
        if (!canMakeBouquets(left, bloomDay, m, k))
            return -1;
        return left;
    }

    private boolean canMakeBouquets(int curDay, int[] bloomDay, int m, int k) {
        int flowers = 0;
        int bouquet = 0;

        for (int day: bloomDay) {
            if (day <= curDay) {
                flowers++;
                if (flowers == k) {
                    bouquet++;
                    flowers = 0;
                }
            }
            else
                flowers = 0;
            if (bouquet >= m)
                return true;
        }
        return false;
    }
}