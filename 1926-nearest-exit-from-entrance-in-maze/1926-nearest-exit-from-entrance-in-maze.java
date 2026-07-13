class Solution {
    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{entrance[0], entrance[1], 0});

        boolean[][] visited = new boolean[m][n];
        visited[entrance[0]][entrance[1]] = true;

        int[][] directions = {
            {-1, 0},
            {1, 0},
            {0, -1},
            {0, 1}
        };

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int row = curr[0];
            int col = curr[1];
            int steps = curr[2];

            if ((row == 0 || row == m - 1 || col == 0 || col == n - 1)
                    && (row != entrance[0] || col != entrance[1])) {
                return steps;
            }

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                if (newRow >= 0 && newRow < m &&
                    newCol >= 0 && newCol < n &&
                    maze[newRow][newCol] == '.' &&
                    !visited[newRow][newCol]) {

                    visited[newRow][newCol] = true;
                    queue.offer(new int[]{newRow, newCol, steps + 1});
                }
            }
        }

        return -1;
    }
}