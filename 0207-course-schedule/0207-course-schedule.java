class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) adj.add(new ArrayList<>());
        int[] inDegree = new int[numCourses];

        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
            inDegree[p[0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) queue.offer(i);
        }

        int processed = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            processed++;

            for (int next : adj.get(node)) {
                inDegree[next]--;
                if (inDegree[next] == 0) queue.offer(next);
            }
        }

        return processed == numCourses;  // if we processed everyone, no cycle
    }
}