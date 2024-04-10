class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        Deque<Integer> deque = new ArrayDeque<>();
        Arrays.sort(deck);
        deque.offer(deck[deck.length - 1]);
        for (int i = deck.length - 2; i >= 0; i--) {
            deque.addFirst(deque.removeLast());
            deque.addFirst(deck[i]);
        }
        int[] answer = new int[deque.size()];
        int idx = 0;
        for (int num : deque)
            answer[idx++] = num;
        return answer;
    }
}