class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];

        for (int i = 0; i < n; i++) {
            if (color[i] == 0 && !isBipartite(i, graph, color))
                return false;
        }
        return true;
    }

    private boolean isBipartite(int curr, int[][] graph, int[] color) {
        // color[curr] = currcolor;
        // for(int child:graph[curr]){
        //     if(color[child] == color[curr])return false;
        //     else if(color[child] == -1 && !isBipartite(child,graph,color,1-currcolor))
        //     return false;
        // }
        // return true;

        Queue<Integer> q = new LinkedList<Integer>();
        q.add(curr);
        color[curr] = 1;

        while (!q.isEmpty()) {
            int d = q.poll();
            for (int child : graph[d]) {
                if (color[child] == color[d])
                    return false;
                if (color[child] == 0) {
                    color[child] = -color[d];
                    q.add(child);
                }
            }
        }
        return true;
    }
}