class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;

        // diagonals numbered 0 to m+n-2
        List<List<Integer>> diagonals = new ArrayList<>();
        for (int d = 0; d < m + n - 1; d++) {
            diagonals.add(new ArrayList<>());
        }

        // fill: elements with the same i + j go in the same list (top to bottom)
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                diagonals.get(i + j).add(mat[i][j]);
            }
        }

        int[] res = new int[m * n];
        int idx = 0;
        boolean flip = true;

        for (List<Integer> diag : diagonals) {
            if (flip) {
                Collections.reverse(diag);   // even d: up-right
            }
            for (int x : diag) {
                res[idx++] = x;
            }
            flip = !flip;
        }
        return res;
    }
}