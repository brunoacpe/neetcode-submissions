class Solution {

    public int orangesRotting(int[][] grid) {

        Queue<int[]> queue = new ArrayDeque<>();
        int fresh = 0;

        // Find all rotten oranges and count fresh ones
        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {

                int current = grid[row][column];

                if (current == 2) {
                    queue.offer(new int[]{row, column});
                } else if (current == 1) {
                    fresh++;
                }
            }
        }

        int minutes = 0;

        // BFS
        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {

                int[] currentPosition = queue.poll();

                int row = currentPosition[0];
                int column = currentPosition[1];

                // Down
                if (row + 1 < grid.length && grid[row + 1][column] == 1) {
                    grid[row + 1][column] = 2;
                    fresh--;
                    queue.offer(new int[]{row + 1, column});
                }

                // Up
                if (row - 1 >= 0 && grid[row - 1][column] == 1) {
                    grid[row - 1][column] = 2;
                    fresh--;
                    queue.offer(new int[]{row - 1, column});
                }

                // Right
                if (column + 1 < grid[0].length && grid[row][column + 1] == 1) {
                    grid[row][column + 1] = 2;
                    fresh--;
                    queue.offer(new int[]{row, column + 1});
                }

                // Left
                if (column - 1 >= 0 && grid[row][column - 1] == 1) {
                    grid[row][column - 1] = 2;
                    fresh--;
                    queue.offer(new int[]{row, column - 1});
                }
            }

            minutes++;
        }

        return fresh == 0 ? minutes : -1;
    }
} 