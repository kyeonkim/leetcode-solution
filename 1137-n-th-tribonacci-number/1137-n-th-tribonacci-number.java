class Solution {
    public int tribonacci(int n) {
        if (n <= 2) {
            if (n == 0)
                return 0;
            else
                return 1;
        }
        int[] T = new int[3];
        T[0] = 0;
        T[1] = 1;
        T[2] = 1;
        int changeIdx = 0;
        for (int i = 4; i <= n; i++) {
            if (changeIdx == 3) changeIdx = 0;
            T[changeIdx] = T[0] + T[1] + T[2];
            changeIdx++;
        }
        return T[0] + T[1] + T[2];
    }
}