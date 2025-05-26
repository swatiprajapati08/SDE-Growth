class Solution {
    public int makeConnected(int n, int[][] connections) {
        if (connections.length < n - 1)
            return -1; // n vertices needs n-1 edges

        int parent[] = new int[n];
        int rank[] = new int[n];
        for (int i = 0; i < n; i++)
            parent[i] = i;

        int unconnected_computer = n; // currently sare alg alg hai 

        for (int[] connection : connections) {
            int x = connection[0];
            int y = connection[1];

            if (needConnection(x, y, parent)) {
                union(x, y, parent, rank);
                unconnected_computer--; // vo union hogye, ab 
            }

        }
        return unconnected_computer - 1;
    }

    int find(int x, int parent[]) {
        if (x == parent[x])
            return x;
        return parent[x] = find(parent[x], parent);
    }

    void union(int x, int y, int parent[], int rank[]) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);

        if (rank[x_parent] > rank[y_parent])
            parent[y_parent] = x_parent;
        else if (rank[x_parent] < rank[y_parent])
            parent[x_parent] = y_parent;
        else {
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }

    boolean needConnection(int x, int y, int parent[]) {
        int x_parent = find(x, parent);
        int y_parent = find(y, parent);
        if (x_parent == y_parent)
            return false;
        return true;
    }
}