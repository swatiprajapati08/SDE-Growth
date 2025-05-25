class Solution {
    static int parent[];

    public boolean equationsPossible(String[] equations) {
        parent = new int[26];
        int rank[] = new int[26];
        for (int i = 0; i < 26; i++)
            parent[i] = i;

        for (String s : equations) {
            int x = s.charAt(0) - 'a';
            int y = s.charAt(3) - 'a';

            char sign = s.charAt(1);

            if (sign == '=')
                union(x, y, rank);
        }
        for (String s : equations) {
            if (s.charAt(1) == '!') {
                int a = s.charAt(0) - 'a';
                int b = s.charAt(3) - 'a';
                if (checkConnection(a, b)) // belong to same parent then can't exist in != 
                    return false;
            }
        }
        return true;
    }

    static int find(int x) {
        if (parent[x] == x)
            return x;
        else
            return parent[x] = find(parent[x]);
    }

    static void union(int x, int y, int rank[]) {
        int parent_x = find(x);
        int parent_y = find(y);

        if (parent_x == parent_y)
            return;
        else {
            if (rank[parent_x] > rank[parent_y])
                parent[parent_y] = parent_x;
            else if (rank[parent_x] < rank[parent_y])
                parent[parent_x] = parent_y;
            else {
                parent[parent_x] = parent_y;
                rank[parent_y]++;
            }
        }
    }

    static boolean checkConnection(int x,int y) {
        int parent_x = find(x);
        int parent_y = find(y);

        if (parent_x == parent_y)
            return true;
        return false;
    }
}