package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ChocolateDistributionProblem {

    //convert array to list and vice versa
    /*
     int[][] mat = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
     List<List<Integer>> li = Arrays.stream(mat).map(ar ->
    Arrays.stream(ar).boxed().collect(Collectors.toList())).toList();
    int[][] newMat = li.stream().map(l -> l.stream().mapToInt(Integer::intValue)
     .toArray()).toArray(int[][]::new);
    * */

    public static void main(String[] args) {
        int[] arr = {3, 4, 1, 9, 56, 7, 9, 12};
        int m = 5;
        ArrayList<Integer> al = Arrays.stream(arr).boxed().collect(Collectors.toCollection(ArrayList::new));
        System.out.println(findMinDiff(al, arr.length, m));
    }

    public static long findMinDiff(ArrayList<Integer> a, int n, int m) {
        Collections.sort(a);
        int l = 0, r = l + m - 1;
        long minDiff = Integer.MAX_VALUE;
        while (r < n) {
            minDiff = Math.min(minDiff, a.get(r) - a.get(l));
            l++;
            r++;
        }
        return minDiff;
    }
}
