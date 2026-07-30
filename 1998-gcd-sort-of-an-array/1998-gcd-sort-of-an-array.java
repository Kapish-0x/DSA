class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n + 1];
            for (int i = 0; i <= n; i++) {
                parent[i] = i;
            }
        }

        int find(int x) {
            if (parent[x] != x)
                parent[x] = find(parent[x]);   // Path Compression
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa != pb)
                parent[pa] = pb;
        }
    }

    public boolean gcdSort(int[] nums) {

        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        DSU dsu = new DSU(max);

        // Build Smallest Prime Factor array
        int[] spf = new int[max + 1];

        for (int i = 0; i <= max; i++)
            spf[i] = i;

        for (int i = 2; i * i <= max; i++) {
            if (spf[i] == i) {
                for (int j = i * i; j <= max; j += i) {
                    if (spf[j] == j)
                        spf[j] = i;
                }
            }
        }

        // Connect every number with its prime factors
        for (int x : nums) {

            int temp = x;

            while (temp > 1) {
                int prime = spf[temp];

                dsu.union(x, prime);

                while (temp % prime == 0)
                    temp /= prime;
            }
        }

        int[] sorted = nums.clone();
        Arrays.sort(sorted);

        for (int i = 0; i < nums.length; i++) {

            if (dsu.find(nums[i]) != dsu.find(sorted[i]))
                return false;
        }

        return true;
    }
}