class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                DFS(i, visited, isConnected);
                count++;
            }
        }
        return count;
    }

    void DFS(int src, boolean[] visited, int[][] arr) {
        visited[src] = true;
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i] && arr[src][i] == 1)
                BFS(i, visited, arr);
        }
    }

    void BFS(int src, boolean[] visited, int[][] arr) {
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(src);
        visited[src] = true;
        while (!queue.isEmpty()) {
            int p = queue.poll();
            for (int i = 0; i < arr.length; i++) {
                if (!visited[i] && arr[p][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }
    }
}