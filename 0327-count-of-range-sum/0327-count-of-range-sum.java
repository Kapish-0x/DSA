class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        // prefix array needs to be long to avoid integer overflow
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        return mergeSortAndCount(prefix, 0, n + 1, lower, upper);
    }

    private int mergeSortAndCount(long[] prefix, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }

        int mid = start + (end - start) / 2;
        int count = mergeSortAndCount(prefix, start, mid, lower, upper)
                  + mergeSortAndCount(prefix, mid, end, lower, upper);

        // Step 1: Count valid pairs between left half and right half
        int k = mid, l = mid;
        for (int i = start; i < mid; i++) {
            while (k < end && prefix[k] - prefix[i] < lower) {
                k++;
            }
            while (l < end && prefix[l] - prefix[i] <= upper) {
                l++;
            }
            count += (l - k);
        }

        // Step 2: Standard Merge step of Merge Sort
        long[] temp = new long[end - start];
        int i = start, j = mid, idx = 0;

        while (i < mid && j < end) {
            if (prefix[i] <= prefix[j]) {
                temp[idx++] = prefix[i++];
            } else {
                temp[idx++] = prefix[j++];
            }
        }
        while (i < mid) temp[idx++] = prefix[i++];
        while (j < end) temp[idx++] = prefix[j++];

        System.arraycopy(temp, 0, prefix, start, temp.length);

        return count;
    }
}