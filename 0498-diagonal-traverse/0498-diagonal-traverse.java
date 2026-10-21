class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[] res = new int[m * n];
        int row = 0, col = 0;
        boolean up = true;

        for (int k = 0; k < m * n; k++) {
            res[k] = mat[row][col];

            if (up) {
                if (col == n - 1) {        // hit right wall: go down, flip
                    row++;
                    up = false;
                } else if (row == 0) {     // hit top wall: go right, flip
                    col++;
                    up = false;
                } else {                   // normal up-right move
                    row--;
                    col++;
                }
            } else {
                if (row == m - 1) {        // hit bottom wall: go right, flip
                    col++;
                    up = true;
                } else if (col == 0) {     // hit left wall: go down, flip
                    row++;
                    up = true;
                } else {                   // normal down-left move
                    row++;
                    col--;
                }
            }
        }
        return res;
    }
}