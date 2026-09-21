class Solution {

    public boolean exist(char[][] board, String word) {

        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {

                if (board[row][column] == word.charAt(0)) {

                    if (dfs(board, word, row, column, 0)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(
            char[][] board,
            String word,
            int row,
            int column,
            int level) {

        // Out of bounds
        if (row < 0 || row >= board.length ||
            column < 0 || column >= board[0].length) {
            return false;
        }

        // Current cell doesn't match the character we're looking for
        if (board[row][column] != word.charAt(level)) {
            return false;
        }

        // We found the entire word
        if (level == word.length() - 1) {
            return true;
        }

        // Mark current cell as visited
        char original = board[row][column];
        board[row][column] = '#';

        // Explore neighbors
        boolean found =
                dfs(board, word, row + 1, column, level + 1) ||
                dfs(board, word, row - 1, column, level + 1) ||
                dfs(board, word, row, column + 1, level + 1) ||
                dfs(board, word, row, column - 1, level + 1);

        // Backtrack
        board[row][column] = original;

        return found;
    }
}