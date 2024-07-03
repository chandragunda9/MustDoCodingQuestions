package arrays;

import java.util.ArrayList;

public class SpiralTraversalOfMatrix {
    public static void main(String[] args) {
        int[][] mat = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        System.out.println(spirallyTraverse(mat, mat.length, mat[0].length));
    }

    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c) {
        ArrayList<Integer> ans = new ArrayList<>();
        int pos = 0, left = 0, right = c - 1, top = 0, down = r - 1;
        while (left <= right && top <= down) {
            if (pos == 0) {
                //left to right
                for (int i = left; i <= right; i++) {
                    ans.add(matrix[top][i]);
                }
                top++;
            } else if (pos == 1) {
                //top to down
                for (int i = top; i <= down; i++) {
                    ans.add(matrix[i][right]);
                }
                right--;
            } else if (pos == 2) {
                //right to left
                for (int i = right; i >= left; i--) {
                    ans.add(matrix[down][i]);
                }
                down--;
            } else {
                //down to top
                for (int i = down; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
            pos = (pos + 1) % 4;
        }
        return ans;
    }
}
