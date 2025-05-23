class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color, -1);
        for (int i = 0; i < n; i++) {
            if (color[i] == -1 && !isBipartite(i, graph, color, 0))
                return false;
        }
        return true;
    }

    private boolean isBipartite(int curr,int[][] graph,int[] color,int currcolor){
        color[curr] = currcolor;
        for(int child:graph[curr]){
            if(color[child] == color[curr])return false;
            else if(color[child] == -1 && !isBipartite(child,graph,color,1-currcolor))
            return false;
        }
        return true;
    }
}