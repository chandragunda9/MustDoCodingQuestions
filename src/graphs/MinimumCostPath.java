package graphs;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumCostPath {
    static class Node {
        long cost;
        int row, col;

        public Node(long cost, int row, int col) {
            this.cost = cost;
            this.row = row;
            this.col = col;
        }
    }

    public static void main(String[] args) {
        int[][] grid = {{9, 4, 9, 9}, {6, 7, 6, 4},
                {8, 3, 3, 7}, {7, 4, 9, 10}};
        System.out.println(minimumCostPath(grid));
    }

    public static int minimumCostPath(int[][] grid) {
        int n = grid.length;
        long[][] cost = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(cost[i], Integer.MAX_VALUE);
        }
        Queue<Node> q = new PriorityQueue<>(Comparator.comparingLong(a -> a.cost));
        q.add(new Node(0, 0, 0));
        cost[0][0] = grid[0][0];
        while (!q.isEmpty()) {
            Node rem = q.poll();
            if (rem.row == n - 1 && rem.col == n - 1)
                return (int) rem.cost;
            int[] dRow = {-1, 0, 1, 0};
            int[] dCol = {0, 1, 0, -1};
            for (int i = 0; i < dRow.length; i++) {
                int nRow = rem.row + dRow[i];
                int nCol = rem.col + dCol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < n &&
                        cost[rem.row][rem.col] + grid[nRow][nCol] < cost[nRow][nCol]) {
                    cost[nRow][nCol] = cost[rem.row][rem.col] + grid[nRow][nCol];
                    q.add(new Node(cost[nRow][nCol], nRow, nCol));
                }
            }
        }
        return -1;
    }
}
