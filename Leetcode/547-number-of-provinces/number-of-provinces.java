class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean visited[] = new boolean[n];
        int count = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                DFS(i,visited,isConnected); count++;
            }
        }
        return count;
    }
    void DFS(int src, boolean[] visited, int[][] arr){
        visited[src] = true;
        for(int i=0;i<arr.length;i++){
            if(!visited[i] && arr[src][i] == 1)DFS(i,visited,arr);
        }
    }
}