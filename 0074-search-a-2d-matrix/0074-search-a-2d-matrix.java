class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int low = 0;
        int high = (m * n) - 1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            int midEle = matrix[mid / n][mid % n]; //converts 1D index to 2D index
            if(midEle == target) {
                return true;
            } else if(midEle < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return false;
    }
}