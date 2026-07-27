class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        int[] counts = new int[n];
        int[] indices = new int[n];
        for (int i = 0; i < n; i++) {
            indices[i] = i; // track original positions
        }

        mergeSort(nums, indices, counts, 0, n - 1);

        List<Integer> result = new ArrayList<>();
        for (int c : counts) result.add(c);
        return result;
    }

    private void mergeSort(int[] nums, int[] indices, int[] counts, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2;
        mergeSort(nums, indices, counts, left, mid);
        mergeSort(nums, indices, counts, mid + 1, right);
        merge(nums, indices, counts, left, mid, right);
    }

    private void merge(int[] nums, int[] indices, int[] counts, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];
        int i = left, j = mid + 1, k = 0;
        int rightCount = 0; // how many elements from right half have been placed so far

        while (i <= mid && j <= right) {
            if (nums[indices[j]] < nums[indices[i]]) {
                // right element is smaller -> it jumps ahead of left[i..mid]
                rightCount++;
                temp[k++] = indices[j++];
            } else {
                // left element placed -> it has `rightCount` smaller elements to its right so far
                counts[indices[i]] += rightCount;
                temp[k++] = indices[i++];
            }
        }

        while (i <= mid) {
            counts[indices[i]] += rightCount; // all right elements already placed were smaller
            temp[k++] = indices[i++];
        }

        while (j <= right) {
            temp[k++] = indices[j++];
        }

        // copy back the merged (sorted) indices for this range
        for (int p = 0; p < temp.length; p++) {
            indices[left + p] = temp[p];
        }
    }
}