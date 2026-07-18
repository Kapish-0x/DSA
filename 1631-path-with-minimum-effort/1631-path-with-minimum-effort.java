class Solution {
    public int minimumEffortPath(int[][] heights) {
        int rows = heights.length;
        int cols = heights[0].length;
        int[][] effortTo = new int[rows][cols];
        for (int[] row : effortTo) Arrays.fill(row, Integer.MAX_VALUE);
        
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        
        // min-heap: {effort, row, col}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0, 0});
        effortTo[0][0] = 0;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int currEffort = curr[0], r = curr[1], c = curr[2];
            
            if (r == rows - 1 && c == cols - 1) {
                return currEffort;
            }
            
            if (currEffort > effortTo[r][c]) continue; // stale entry
            
            for (int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                
                int diff = Math.abs(heights[nr][nc] - heights[r][c]);
                int newEffort = Math.max(currEffort, diff);
                
                if (newEffort < effortTo[nr][nc]) {
                    effortTo[nr][nc] = newEffort;
                    pq.offer(new int[]{newEffort, nr, nc});
                }
            }
        }
        
        return 0; // unreachable in practice since (0,0) to (rows-1,cols-1) always has a path
    }
}