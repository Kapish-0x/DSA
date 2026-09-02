// (Memoization + Recursion)
// class Solution {
//     int[] t = new int[46];
//     public int solve(int n) {
//         if(n < 0) return 0;
//         if(n == 0) return 1;
//         if(t[n] != -1) return t[n];
//         return t[n] = solve(n-1) + solve(n-2);
//     }
//     public int climbStairs(int n) {
//         Arrays.fill(t, -1);
//         return solve(n);
//     }
// }

//Bottom-up
class Solution {
    public int climbStairs(int n) {
        if(n == 0 || n == 1 || n == 2) {
            return n;
        }
        int[] arr = new int[n+1];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 2;
        for(int i = 3; i <= n; ++i) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}

//Brute force -- TLE
// class Solution {
//     public int climbStairs(int n) {
//         if(n < 0) return 0; 
//         if(n == 0) return 1;
//         int one = climbStairs(n-1);
//         int two = climbStairs(n-2);
//         return one + two;
//     }
// }