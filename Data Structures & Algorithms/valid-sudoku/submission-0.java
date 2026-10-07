class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> boxes = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            boxes.add(new HashSet<>());
        }

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                char current = board[row][column];
                if (current == '.') continue;

                if (current < '1' || current > '9') return false;

                int boxIndex = (row / 3) * 3 + (column / 3);

                if (rows.get(row).contains(current)
                        || cols.get(column).contains(current)
                        || boxes.get(boxIndex).contains(current)) {
                    return false;
                }

                rows.get(row).add(current);
                cols.get(column).add(current);
                boxes.get(boxIndex).add(current);
            }
        }

        return true;
    }
}