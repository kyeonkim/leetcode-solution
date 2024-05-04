class Solution {
    public int numRescueBoats(int[] people, int limit) {
        int s = 0, e = people.length - 1;
        int total = 0;
        Arrays.sort(people);
        while (s <= e) {
            if (people[s] + people[e] <= limit)
                s++;
            total++;
            e--;
        }
        return total;
    }
}