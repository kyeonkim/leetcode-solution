class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int prev = 0;
        for (int i = 0; i < flowerbed.length; i++) {
            if (i + 1 < flowerbed.length && prev == 0 && flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                n--;
                flowerbed[i] = 1;
            }
            else if (i + 1 == flowerbed.length && prev == 0 && flowerbed[i] == 0) {
                n--;
                flowerbed[i] = 1;
            }
            prev = flowerbed[i];
        }
        if (n <= 0) return true;
        return false;
    }
}