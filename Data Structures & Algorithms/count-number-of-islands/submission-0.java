class Solution {
    public int numIslands(char[][] grid) {
        int islands = 0;
        for(int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[0].length; column++) {
                int currentPosition = grid[row][column];
                if (currentPosition == '0') continue;
                dfs(grid, row, column);
                islands++;
            }
        }
        return islands;
    }


    private void dfs(char[][] grid, int row, int column) {
        // Search and set as 2 until i find every conected node.
        if (row < 0 || row >= grid.length || column < 0 || column >= grid[0].length) {
            return;
        }
        char current = grid[row][column];

        if (current == '0') return;
        if (current == '1') {
            grid[row][column] = '0';
        }

        dfs(grid, row + 1, column);
        dfs(grid, row - 1, column);
        dfs(grid, row, column + 1);
        dfs(grid, row, column - 1);
    }
}
