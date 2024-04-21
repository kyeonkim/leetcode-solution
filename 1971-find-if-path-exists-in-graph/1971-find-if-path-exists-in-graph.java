class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        if (n == 1)
            return true;
        int[] visited = new int[n];
        Queue<Integer> q = new LinkedList<Integer>();
        q.offer(source);
        while (true) {
            if (q.peek() == null)
                break;
            if (visited[q.peek()] == 1) {
                q.poll();
                continue;
            }
            int edge = q.poll();
            visited[edge] = 1;
            for (int i = 0; i < edges.length; i++) {
                int ui = edges[i][0], vi = edges[i][1];
                if (edge == ui) {
                    if (vi == destination)
                        return true;
                    q.offer(vi);
                }
                else if(edge == vi) {
                    if (ui == destination)
                        return true;
                    q.offer(ui);
                }
            }
        }
        return false;
    }
}