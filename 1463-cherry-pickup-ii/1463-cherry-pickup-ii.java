class Solution {
    int m, n;
    int[][][] t = new int[71][71][71];
    public int solve(int[][] grid, int r, int c1, int c2) {
        if(r >= m) {
            return 0; //no cherry as we are out of bound
        }
        if(t[r][c1][c2] != -1) {
            return t[r][c1][c2];
        }
        int cherry = grid[r][c1]; //current pos cherry add r2 only if not the same cell
        if(c1 != c2) { //if same cell add once else add R2 cherry too
            cherry += grid[r][c2];
        }
        int ans = 0;
        // both robots move independently each step -> each has 3 col choices (-1, 0, +1)
        // so try all combinations: i for robot1's shift, j for robot2's shift -> 3*3 = 9 total moves per step
        for(int i = -1; i <=1; ++i) { //r1
            for(int j = -1; j <= 1; ++j) { //r2
                int newRow = r+1;
                int new_c1 = c1+i;
                int new_c2 = c2+j;
                if(new_c1 >= 0 && new_c1 < n && new_c2 >=0 && new_c2 < n) //safe column
                    ans = Math.max(ans, solve(grid, newRow, new_c1, new_c2));
            }
        }
        return t[r][c1][c2] = cherry + ans;
    }

    public int cherryPickup(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for (int[][] layer : t) {
            for (int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return solve(grid, 0, 0, n-1); //row --> 0 r1 col --> (top left) r2 col --> n-1(top right)
    }
}