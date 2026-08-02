class Solution {
    int[] parent;

    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        parent = new int[n + 1];  // nodes are labeled 1 to n
        for (int i = 1; i <= n; i++) parent[i] = i;  // each node starts as its own parent

        for (int[] edge : edges) {
            int a = edge[0], b = edge[1];
            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return edge;   // already connected -> this edge creates a cycle
            }

            parent[rootA] = rootB;  // union: merge the two sets
        }

        return new int[0];  // shouldn't happen given problem guarantees
    }

    private int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);  // path compression
        }
        return parent[x];
    }
}