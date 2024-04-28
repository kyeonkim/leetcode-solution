// class Solution {
//     public int[] sumOfDistancesInTree(int n, int[][] edges) {
//         if (n == 1) return new int[]{0};
//         int[][] depths = new int[n][n];
//         Queue<Integer> q = new LinkedList<>();
//         List<ArrayList<Integer>> nodes = new ArrayList<>();

//         for (int i = 0; i < n; i++) nodes.add(new ArrayList<Integer>());
//         for (int i = 0; i < edges.length; i++) {
//             nodes.get(edges[i][0]).add(edges[i][1]);
//             nodes.get(edges[i][1]).add(edges[i][0]);
//         }
//         for(int i = 0; i < n; i++) {
//             boolean[] visited = new boolean[n];
//             q.offer(i);
//             while(!q.isEmpty()) {
//                 int cur = q.poll();
//                 visited[cur] = true;
//                 for(int node : nodes.get(cur)) {
//                     if (visited[node])
//                         continue;
//                     depths[i][node] = depths[i][cur] + 1;
//                     q.offer(node);
//                 }
//             }
//             q.clear();
//         }
//         int[] answer = new int[n];
//         for (int i = 0; i < n; i++) {
//             int sum = 0;
//             for (int j = 0; j < n; j++)
//                 sum += depths[i][j];
//             answer[i] = sum;
//         }
//         return answer;
//     }
// }


// class Solution {
//     public int[] sumOfDistancesInTree(int n, int[][] edges) {
//         if (n == 1) return new int[]{0};
//         Queue<Integer> q = new LinkedList<>();
//         List<ArrayList<Integer>> nodes = new ArrayList<>();

//         for (int i = 0; i < n; i++) nodes.add(new ArrayList<Integer>());
//         for (int i = 0; i < edges.length; i++) {
//             nodes.get(edges[i][0]).add(edges[i][1]);
//             nodes.get(edges[i][1]).add(edges[i][0]);
//         }
//         int[] answer = new int[n];
//         for(int i = 0; i < n; i++) {
//             int[] depth = new int[n];
//             boolean[] visited = new boolean[n];
//             q.offer(i);
//             while(!q.isEmpty()) {
//                 int cur = q.poll();
//                 visited[cur] = true;
//                 for(int node : nodes.get(cur)) {
//                     if (visited[node])
//                         continue;
//                     depth[node] = depth[cur] + 1;
//                     answer[i] += depth[node];
//                     q.offer(node);
//                 }
//             }
//             q.clear();
//         }
//         return answer;
//     }
// }

class Solution {
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        if (n == 1) return new int[]{0};
        ArrayList<Integer>[] nodes = new ArrayList[n];

        for (int i = 0; i < n; i++) nodes[i] = new ArrayList<>();
        for (int[] edge : edges) {
            nodes[edge[0]].add(edge[1]);
            nodes[edge[1]].add(edge[0]);
        }
        int[] answer = new int[n];
        int[] childCnt = new int[n];
        Arrays.fill(childCnt, 1);
        postOrder(0, -1, nodes, childCnt, answer);
        // preOrder(0, -1, nodes, childCnt, answer, n);
        return answer;
    }

    private void postOrder(int node, int parent, ArrayList<Integer>[] nodes, int[] childCnt, int[] answer) {
        for (int child : nodes[node]) {
            if (child != parent) {
                postOrder(child, node, nodes, childCnt, answer);
                childCnt[node] += childCnt[child];
                answer[node] += answer[child] + childCnt[child];
            }
        }
    }

    private void preOrder(int node, int parent, ArrayList<Integer>[] nodes, int[] childCnt, int[] answer, int n) {
        for (int child : nodes[node]) {
            if (child != parent) {
                answer[child] = answer[node] + (n - childCnt[child]) - childCnt[child];
                preOrder(child, node, nodes, childCnt, answer, n);
            }
        }
    }
}