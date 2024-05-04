class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int s = 0, e = people.length - 1;
        int total = 0;
        Arrays.sort(people);
        people = reverse(people, people.length);
        while (s <= e) {
            if (s == e && people[s] <= limit)
                total++;
            else {
                if (people[s] + people[e] <= limit)
                    e--;
                total++;
            }
            s++;
        }
        return total;
    }

    private int[] reverse(int[] arr, int size) {
        for (int i = 0; i < size / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = temp;
        }
        return arr;
    }
}