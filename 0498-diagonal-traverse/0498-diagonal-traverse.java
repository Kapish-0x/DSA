class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        List<List<Integer>> diagonals = new ArrayList<>();
        for(int i = 0; i < m + n - 1; ++i) {
            diagonals.add(new ArrayList<>());
        }
        for(int i = 0; i < m; ++i) {
            for(int j = 0; j < n; ++j) {
                diagonals.get(i+j).add(mat[i][j]);
            }
        }
        int[] res = new int[m*n];
        int idx = 0;
        for(int d = 0; d < diagonals.size(); ++d) {
            List<Integer> list = diagonals.get(d);
            if(d % 2 == 0) {
                for(int k = list.size() - 1; k >= 0; --k) {
                    res[idx++] = list.get(k);
                }
            } else {
                for(int val : list) {
                    res[idx++] = val;
                }
            }
        }
        return res;
    }
}