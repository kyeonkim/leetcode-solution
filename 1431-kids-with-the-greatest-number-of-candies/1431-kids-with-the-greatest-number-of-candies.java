class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> isGreatestCandie = new ArrayList<>(candies.length);
        int max = 0;
        for (int candie : candies)
            max = Math.max(max, candie);
        for (int i = 0; i < candies.length; i++)
            isGreatestCandie.add(candies[i] + extraCandies >= max);
        return isGreatestCandie;
    }
}