class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        for (int[] p : prerequisites) adj.get(p[1]).add(p[0]);

        boolean[] visited = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (hasCycle(i, adj, visited, inPath)) return false;
            }
        }
        return true;
    }

    private boolean hasCycle(int node, List<List<Integer>> adj, boolean[] visited, boolean[] inPath) {
        visited[node] = true;
        inPath[node] = true;   // mark as part of CURRENT chain

        for (int next : adj.get(node)) {
            if (inPath[next]) return true;               // found a cycle!
            if (!visited[next] && hasCycle(next, adj, visited, inPath)) return true;
        }

        inPath[node] = false;  // done with this chain, un-mark before backtracking
        return false;
    }
}