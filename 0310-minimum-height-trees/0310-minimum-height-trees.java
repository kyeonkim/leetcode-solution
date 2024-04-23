class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> nodes = new ArrayList<>();
        if (n == 1) {
            nodes.add(0);
            return nodes;
        }
        List<Set<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new HashSet<>());
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() == 1)
                nodes.add(i);
        }
        while (n > 2) {
            n -= nodes.size();
            List<Integer> newNodes = new ArrayList<>();
            for (int node : nodes) {
                int nextNode = adj.get(node).iterator().next();
                adj.get(nextNode).remove(node);
                if (adj.get(nextNode).size() == 1) newNodes.add(nextNode);
            }
            nodes = newNodes;
        }
        return nodes;
    }
}