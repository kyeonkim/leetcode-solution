class Solution {
    public int[] kthSmallestPrimeFraction(int[] arr, int k) {
        int den = arr[0]; // 여러 수의 최소공배수
        for (int i = 1; i < arr.length; i++)
            den = lcm(den, arr[i]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int j = arr.length - 1; j > 0; j--) {
            int mulN = den / arr[j];
            for (int i = j - 1; i >= 0; i--) {
                pq.offer(arr[i] * mulN);
            }
        }
        int num = pq.poll();
        k--;
        while (k != 0 && !pq.isEmpty()) {
            num = pq.poll();
            k--;
        }
        for (int i = 0;i < arr.length;i++) {
            if (num % arr[i] != 0 || den % arr[i] != 0)
                break;
            num /= arr[i];
            den /= arr[i];
        }
        return new int[]{num, den};
    }

    private int lcm(int x, int y) {
        return x * y / gcd(x, y);
    }

    private int gcd(int x, int y) {
        int temp;
        while (y != 0) {
            temp = x % y;
            x = y;
            y = temp;
        }
        return x;
    }
}