class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // toplogical sorting means will finish all course
        ArrayList<ArrayList<Integer>> arr = generateGraph(numCourses, prerequisites);
        boolean visited[] = new boolean[numCourses];
        boolean recur[] = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && DFS(i, visited, recur, arr))
                return !true;
        }
        return !false;
    }

    private boolean DFS(int src, boolean visited[], boolean[] recur, ArrayList<ArrayList<Integer>> arr) {

        visited[src] = true;
        recur[src] = true;

        for (int child : arr.get(src)) {
            if (!visited[child] && DFS(child, visited, recur, arr))
                return true;
            else if (recur[child] == true)
                return true;

        }
        recur[src] = false;
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