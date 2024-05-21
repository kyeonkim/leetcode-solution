class RecentCounter {
    private Queue<Integer> requests;

    public RecentCounter() {
        requests = new LinkedList<>();
    }
    
    public int ping(int t) {
        requests.offer(t);
        while (!requests.isEmpty() && 3000 < t - requests.peek())
            requests.poll();
        return requests.size();
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */