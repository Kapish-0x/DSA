class Solution {
    private int count = 0;

    public int totalNQueens(int n) {
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diagonals = new HashSet<>();     // (row - col)
        Set<Integer> antiDiagonals = new HashSet<>(); // (row + col)

        solve(0, n, cols, diagonals, antiDiagonals);
        return count;
    }

    private void solve(int row, int n, Set<Integer> cols, Set<Integer> diagonals, Set<Integer> antiDiagonals) {
        // Base Case: Successfully placed queens in all n rows!
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            int diag = row - col;
            int antiDiag = row + col;

            // Check if column or diagonals are under attack
            if (cols.contains(col) || diagonals.contains(diag) || antiDiagonals.contains(antiDiag)) {
                continue;
            }

            // 1. Choice: Place queen
            cols.add(col);
            diagonals.add(diag);
            antiDiagonals.add(antiDiag);

            // 2. Explore: Move to the next row
            solve(row + 1, n, cols, diagonals, antiDiagonals);

            // 3. Backtrack: Remove queen for other combinations
            cols.remove(col);
            diagonals.remove(diag);
            antiDiagonals.remove(antiDiag);
        }
    }
}