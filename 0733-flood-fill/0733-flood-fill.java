class Solution {
    int m, n;

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        m = image.length;
        n = image[0].length;

        int oldColor = image[sr][sc]; 

        if (oldColor == color) {
            return image;
        }
        dfs(image, sr, sc, oldColor, color);
        return image;
    }

    public void dfs(int[][] image, int i, int j, int oldColor, int newColor) {

        if (i < 0 || i >= m || j < 0 || j >= n || image[i][j] != oldColor)
            return;

        image[i][j] = newColor;

        dfs(image, i - 1, j, oldColor, newColor); // up
        dfs(image, i + 1, j, oldColor, newColor); // down
        dfs(image, i, j - 1, oldColor, newColor); // left
        dfs(image, i, j + 1, oldColor, newColor); // right
    }
}