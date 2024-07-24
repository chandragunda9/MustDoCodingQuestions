package graphs;

public class FindWhetherPathExist {
    public static void main(String[] args) {
//        int[][] grid = {{3, 0, 3, 0, 0}, {3, 0, 0, 0, 3}, {3, 3, 3, 3, 3}, {0, 2, 3, 0, 0}, {3, 0, 0, 1, 3}};
        int[][] grid = {{1, 3}, {3, 2}};
        System.out.println(is_Possible(grid));
    }

    public static boolean is_Possible(int[][] grid) {
        int n = grid.length;
        boolean[][] vis = new boolean[n][n];
        int si = -1, sj = -1, di = -1, dj = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    si = i;
                    sj = j;
                } else if (grid[i][j] == 2) {
                    di = i;
                    dj = j;
                }
            }
        }
        return dfs(si, sj, di, dj, vis, grid, n);
    }

    static boolean dfs(int u, int v, int dI, int dJ, boolean[][] vis, int[][] grid, int n) {
        if (u == dI && v == dJ)
            return true;
        vis[u][v] = true;
        int[] dRow = {-1, 0, 1, 0};
        int[] dCol = {0, 1, 0, -1};
        for (int i = 0; i < dRow.length; i++) {
            int nRow = u + dRow[i];
            int nCol = v + dCol[i];
            if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n &&
                    !vis[nRow][nCol] && (grid[nRow][nCol] == 3 || grid[nRow][nCol] == 2)) {
                if (dfs(nRow, nCol, dI, dJ, vis, grid, n))
                    return true;
            }
        }
        return false;
    }
}
