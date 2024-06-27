class Solution {
    public int findCenter(int[][] edges) {
        Map<Integer, List<Integer>> edgesMap = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1];
            
            if (!edgesMap.containsKey(u)) {
                edgesMap.put(u, new ArrayList<>());
            }
            edgesMap.get(u).add(v);
            if (!edgesMap.containsKey(v)) {
                edgesMap.put(v, new ArrayList<>());
            }
            edgesMap.get(v).add(u);
        }

        for (int key: edgesMap.keySet()) {
            if (edgesMap.get(key).size() == edges.length)
                return key;
        }
        return -1;
    }
}