class Solution {
    public int minReorder(int n, int[][] connections) {
        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : connections) {
            int u = edge[0];
            int v = edge[1];

            graph[u].add(new int[]{v, 1});
            graph[v].add(new int[]{u, 0});
        }

        boolean[] visited = new boolean[n];

        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<int[]>[] graph, boolean[] visited) {
        visited[node] = true;
        int changes = 0;

        for (int[] neighbor : graph[node]) {
            int next = neighbor[0];
            int cost = neighbor[1];

            if (!visited[next]) {
                changes += cost;
                changes += dfs(next, graph, visited);
            }
        }

        return changes;
    }
}