class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> arr = generateGraph(numCourses, prerequisites);
        boolean visited[] = new boolean[numCourses];
        int ans[] = new int[numCourses];
        boolean recur[] = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && DFS(i, visited, recur, arr, st)) {
                return new int[] {};
            }

        }
        int p = 0;
        while (!st.isEmpty())
            ans[p++] = st.pop();
        return ans;
    }

    private boolean DFS(int src, boolean visited[], boolean[] recur, ArrayList<ArrayList<Integer>> arr,
            Stack<Integer> st) {

        visited[src] = true;
        recur[src] = true;

        for (int child : arr.get(src)) {
            if (!visited[child] && DFS(child, visited, recur, arr, st))
                return true;
            else if (recur[child] == true)
                return true;

        }
        recur[src] = false;
        st.add(src);
        return false;

    }

    private ArrayList<ArrayList<Integer>> generateGraph(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < numCourses; i++)
            res.add(new ArrayList<>());

        for (int[] p : prerequisites) {
            res.get(p[1]).add(p[0]);
        }
        return res;
    }
}