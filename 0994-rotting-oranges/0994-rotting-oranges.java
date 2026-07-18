class Solution {
    public int orangesRotting(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int freshCount = 0;
        
        // find all initially rotten oranges and count fresh ones
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == 2) {
                    queue.offer(new int[]{r, c});
                } else if (grid[r][c] == 1) {
                    freshCount++;
                }
            }
        }
        
        if (freshCount == 0) return 0; // nothing to rot
        
        int minutes = 0;
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        
        while (!queue.isEmpty() && freshCount > 0) {
            int size = queue.size();
            boolean rottedThisRound = false;
            
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0], c = curr[1];
                
                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];
                    
                    if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                    if (grid[nr][nc] != 1) continue; // not fresh, skip
                    
                    grid[nr][nc] = 2; // rot it
                    freshCount--;
                    queue.offer(new int[]{nr, nc});
                    rottedThisRound = true;
                }
            }
            
            if (rottedThisRound) minutes++;
        }
        
        return freshCount == 0 ? minutes : -1;
    }
}