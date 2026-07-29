class Solution {
    int n;
    boolean[] visited;

    public int findCircleNum(int[][] isConnected) {
        n = isConnected.length;
        visited = new boolean[n];
        int provinces = 0;

        for (int city = 0; city < n; city++) {
            if (!visited[city]) {
                provinces++;          
                dfs(isConnected, city);
            }
        }

        return provinces;
    }

    private void dfs(int[][] isConnected, int city) {
        visited[city] = true; 
        
        for (int neighbor = 0; neighbor < n; neighbor++) {
            if (isConnected[city][neighbor] == 1 && !visited[neighbor]) {
                dfs(isConnected, neighbor);
            }
        }
    }
}