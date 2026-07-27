class Solution {
    int n;
    int[][][] t = new int[2][101][101];
    public int solveForAlice(int[] piles, int person, int i, int M) {
        if(i >= n) return 0; //OUT OF BOUND
        int stones = 0;
        int res = (person == 1) ? -1 : Integer.MAX_VALUE; //if alice(1) we want max value so res = -1 and if bob(0) we want min value so Integer.MAX_VALUE
        if(t[person][i][M] != -1) {
            return t[person][i][M];
        }
        for(int x = 1; x <= Math.min(2*M, n-i); ++x) { //Limit choices to at most 2*M piles without exceeding the remaining piles in the array
            stones += piles[i+x-1]; //Add total stones collected from the current pile selection
            if(person == 1) {   //Alice so best case 
                res = Math.max(res, stones+solveForAlice(piles, 0, i+x, Math.max(M,x))); //0--> Bobs turn and we need the best case for alice
            } else {  //Bob
                res = Math.min(res, solveForAlice(piles, 1, i+x, Math.max(M,x))); //1--> Alices turn and we need the worst case for alice
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