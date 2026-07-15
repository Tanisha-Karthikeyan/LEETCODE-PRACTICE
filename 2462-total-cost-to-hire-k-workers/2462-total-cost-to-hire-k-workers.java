class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int n = costs.length;

        PriorityQueue<int[]> left = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );

        PriorityQueue<int[]> right = new PriorityQueue<>(
            (a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]
        );

        int i = 0;
        int j = n - 1;

        while (i <= j && left.size() < candidates) {
            left.offer(new int[]{costs[i], i});
            i++;
        }

        while (j >= i && right.size() < candidates) {
            right.offer(new int[]{costs[j], j});
            j--;
        }

        long total = 0;

        for (int hire = 0; hire < k; hire++) {
            if (right.isEmpty() || (!left.isEmpty() && left.peek()[0] <= right.peek()[0])) {
                int[] worker = left.poll();
                total += worker[0];

                if (i <= j) {
                    left.offer(new int[]{costs[i], i});
                    i++;
                }
            } else {
                int[] worker = right.poll();
                total += worker[0];

                if (i <= j) {
                    right.offer(new int[]{costs[j], j});
                    j--;
                }
            }
        }

        return total;
    }
}