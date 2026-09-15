class Solution {
    public boolean canMakeSquare(char[][] grid) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                int black = 0;

                for (int r = i; r < i + 2; r++) {
                    for (int c = j; c < j + 2; c++) {
                        if (grid[r][c] == 'B') {
                            black++;
                        }
                    }
                }

                if (black != 2) {
                    return true;
                }
            }
        }

        return false;
    }
}