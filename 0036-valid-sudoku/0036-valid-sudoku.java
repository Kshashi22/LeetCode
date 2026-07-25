class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {
                    continue;
                }

                char current = board[row][col];

                // Check Row
                for (int j = 0; j < 9; j++) {
                    if (j != col && board[row][j] == current) {
                        return false;
                    }
                }

                // Check Column
                for (int i = 0; i < 9; i++) {
                    if (i != row && board[i][col] == current) {
                        return false;
                    }
                }

                // Check 3x3 Box
                int startRow = (row / 3) * 3;
                int startCol = (col / 3) * 3;

                for (int i = startRow; i < startRow + 3; i++) {
                    for (int j = startCol; j < startCol + 3; j++) {
                        if ((i != row || j != col) && board[i][j] == current) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}