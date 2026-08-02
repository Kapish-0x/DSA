class Solution {
    int[] color;

    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        color = new int[n];
        Arrays.fill(color, -1);   // -1 = uncolored

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(graph, i, 0)) {   // start this component with color 0
                    return false;
                }
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int node, int c) {
        color[node] = c;

        for (int neighbor : graph[node]) {
            if (color[neighbor] == -1) {
                // uncolored -> color it the OPPOSITE color, recurse
                if (!dfs(graph, neighbor, 1 - c)) {
                    return false;
                }
            } else if (color[neighbor] == c) {
                // same color as current node -> contradiction, not bipartite
                return false;
            }
        }

        return true;
    }
}