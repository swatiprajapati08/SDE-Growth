class Solution {
    public boolean equationsPossible(String[] equations) {
        int parent[] = new int[26];
        int rank[] = new int[26];
        for(int i=0;i<26;i++)parent[i] = i;

        for(int i=0;i<equations.length;i++){
            int x = equations[i].charAt(0) - 'a';
            int y = equations[i].charAt(3) - 'a';

            if(equations[i].charAt(1) == '=')
            union(x,y,parent,rank);
        }

         for(int i=0;i<equations.length;i++){
            int x = equations[i].charAt(0) - 'a';
            int y = equations[i].charAt(3) - 'a';

            if(equations[i].charAt(1) == '!'){
                if(find(x,parent) == find(y,parent)) return false;
            }
        }
        return true;
    }

    int find(int x, int parent[]){
        if(x == parent[x]) return x;
        return parent[x] = find(parent[x],parent);
    }

    void union(int x, int y, int parent[],int rank[]){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);

        if(rank[x_parent] > rank[y_parent])
        parent[y_parent] = x_parent;
        else if(rank[x_parent] < rank[y_parent])
        parent[x_parent] = y_parent;
        else{
            parent[x_parent] = y_parent;
            rank[y_parent]++;
        }
    }
}