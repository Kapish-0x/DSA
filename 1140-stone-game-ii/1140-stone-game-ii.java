class Solution {
    int n;
    int[][][] t = new int[2][101][101];
    public int solveForAlice(int[] piles, int person, int i, int M) {
        if(i >= n) return 0; //OUT OF BOUND
        int stones = 0;
        int res = (person == 1) ? -1 : Integer.MAX_VALUE;
        if(t[person][i][M] != -1) {
            return t[person][i][M];
        }
        for(int x = 1; x <= Math.min(2*M, n-i); ++x) {
            stones += piles[i+x-1];
            if(person == 1) {   //Alice
                res = Math.max(res, stones+solveForAlice(piles, 0, i+x, Math.max(M,x)));
            } else {  //Bob
                res = Math.min(res, solveForAlice(piles, 1, i+x, Math.max(M,x)));
            }
        }
        return t[person][i][M] = res;
    }
    public int stoneGameII(int[] piles) {
        n = piles.length;
        for(int[][] layer : t) {
            for(int[] row : layer) {
                Arrays.fill(row, -1);
            }
        }
        return solveForAlice(piles, 1, 0, 1); //1--> alice 0--> index 1--> M
    }
}