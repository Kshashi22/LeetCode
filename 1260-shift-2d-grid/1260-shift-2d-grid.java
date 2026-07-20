class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {

        int m = grid.length;
        int n = grid[0].length;

        while (k-- > 0) {

            int[][] temp = new int[m][n];

            // First element gets last element
            temp[0][0] = grid[m - 1][n - 1];

            for (int i = 0; i < m; i++) {

                for (int j = 0; j < n; j++) {

                    if (i == m - 1 && j == n - 1) {
                        continue;
                    }

                    int newCol = (j + 1) % n;
                    int newRow = i + (j + 1) / n;

                    temp[newRow][newCol] = grid[i][j];
                }
            }

            grid = temp;
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                row.add(grid[i][j]);
            }

            result.add(row);
        }

        return result;
    }
}