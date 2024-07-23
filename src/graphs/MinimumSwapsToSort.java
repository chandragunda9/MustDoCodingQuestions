package graphs;

import java.util.*;

public class MinimumSwapsToSort {
    static class Pair {
        int ele, ind;

        public Pair(int ele, int ind) {
            this.ele = ele;
            this.ind = ind;
        }
    }

    public static void main(String[] args) {
        int[] nums = {10, 19, 6, 3, 5};
//        System.out.println(selectionSort(nums));
//        System.out.println(method2(nums));
        System.out.println(minSwaps(nums));
    }

    public static int minSwaps(int[] nums) {
        int n = nums.length;
        boolean[] vis = new boolean[n];
        List<Pair> li = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            li.add(new Pair(nums[i], i));
        }
        li.sort(Comparator.comparingInt(a -> a.ele));
        int totalSwaps = 0;
        for (int i = 0; i < n; i++) {
            if (vis[i] || li.get(i).ind == i)
                continue;
            int cycleSize = 0, j = i;
            while (!vis[j]) {
                vis[j] = true;
                j = li.get(j).ind;
                cycleSize += 1;
            }
            totalSwaps += (cycleSize - 1);
        }
        return totalSwaps;
    }

    public static int method2(int nums[]) {
        int n = nums.length;
        int[] numsSorted = nums.clone();
        Arrays.sort(numsSorted);
        //actual indices for an element as in sorted array
        Map<Integer, Integer> m = new HashMap<>();
        for (int i = 0; i < n; i++) {
            m.put(numsSorted[i], i);
        }
        int swaps = 0, i = 0;
        while (i < n) {
            if (m.get(nums[i]).equals(i)) {
                i++;
            } else {
                swap(nums, i, m.get(nums[i]));
                swaps++;
            }
        }
        return swaps;
    }

    static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    static int selectionSort(int[] nums) {
        int n = nums.length, swaps = 0;
        for (int i = 0; i < n - 1; i++) {
            int minInd = i;
            for (int j = i + 1; j < n; j++) {
                if (nums[j] < nums[minInd]) {
                    minInd = j;
                }
            }
            if (minInd != i) {
                swap(nums, i, minInd);
                swaps++;
            }
        }
        System.out.println(Arrays.toString(nums));
        return swaps;
    }
}
