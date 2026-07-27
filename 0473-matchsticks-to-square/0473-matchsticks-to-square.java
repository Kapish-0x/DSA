import java.util.Arrays;

class Solution {
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks == null || matchsticks.length < 4) {
            return false;
        }

        int totalSum = 0;
        for (int stick : matchsticks) {
            totalSum += stick;
        }

        // Total length must be divisible by 4
        if (totalSum % 4 != 0) {
            return false;
        }

        int target = totalSum / 4;

        // Sort matchsticks in ascending order, then reverse to descending
        Arrays.sort(matchsticks);
        reverse(matchsticks);

        // If the largest stick is bigger than target side, impossible
        if (matchsticks[0] > target) {
            return false;
        }

        int[] sides = new int[4];
        return backtrack(0, matchsticks, sides, target);
    }

    private boolean backtrack(int index, int[] matchsticks, int[] sides, int target) {
        // Base case: All matchsticks placed successfully
        if (index == matchsticks.length) {
            return sides[0] == target && sides[1] == target && 
                   sides[2] == target && sides[3] == target;
        }

        // Try placing matchsticks[index] into each of the 4 sides
        for (int j = 0; j < 4; j++) {
            // Check if this stick fits in side j
            if (sides[j] + matchsticks[index] <= target) {
                
                // Optimization: Skip redundant buckets with identical sum
                if (j > 0 && sides[j] == sides[j - 1]) {
                    continue;
                }

                // DO
                sides[j] += matchsticks[index];

                // RECUR
                if (backtrack(index + 1, matchsticks, sides, target)) {
                    return true;
                }

                // UNDO (Backtrack)
                sides[j] -= matchsticks[index];
            }
        }

        return false;
    }

    private void reverse(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}