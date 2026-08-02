class Solution {
    int[] state; // 0 = unvisited, 1 = visiting, 2 = safe

    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        state = new int[n];
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            if (isSafe(graph, i)) {
                result.add(i);
            }
        }

        return result;
    }

    private boolean isSafe(int[][] graph, int node) {
        if (state[node] == 2) return true;    // already confirmed safe
        if (state[node] == 1) return false;   // currently in progress -> cycle detected

        state[node] = 1;   // mark as "visiting" (in current path)

        for (int neighbor : graph[node]) {
            if (!isSafe(graph, neighbor)) {
                return false;   // this path leads into a cycle -> unsafe
            }
        }

        state[node] = 2;   // fully explored, no cycle found -> safe
        return true;
    }
}