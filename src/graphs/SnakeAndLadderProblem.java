package graphs;

import java.util.*;

public class SnakeAndLadderProblem {
    static class Pair {
        int node;
        int numOfDiceThrows;

        public Pair(int node, int numOfDiceThrows) {
            this.node = node;
            this.numOfDiceThrows = numOfDiceThrows;
        }
    }

    static int minThrow(int N, int arr[]) {
        Map<Integer, Integer> snakesAndLadders = new HashMap<>();
        int nthCell = 30;
        int[] minDice = new int[nthCell + 1];
        Arrays.fill(minDice, Integer.MAX_VALUE);
        for (int i = 0; i < 2 * N; i += 2) {
            snakesAndLadders.put(arr[i], arr[i + 1]);
        }
//        Queue<Pair> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.numOfDiceThrows));
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(1, 0));
        minDice[1] = 0;
        while (!q.isEmpty()) {
            Pair rem = q.poll();
            if (rem.node == nthCell)
                return rem.numOfDiceThrows;
            for (int diceVal = 1; diceVal <= 6; diceVal++) {
                int nodeVal = rem.node + diceVal;
                if (nodeVal <= nthCell) {
                    if (snakesAndLadders.containsKey(nodeVal)) {
                        if (snakesAndLadders.get(nodeVal) <= nodeVal)
                            continue;
                        else
                            nodeVal = snakesAndLadders.get(nodeVal);
                    }
                    if (minDice[rem.node] + 1 < minDice[nodeVal]) {
                        minDice[nodeVal] = minDice[rem.node] + 1;
                        q.add(new Pair(nodeVal, minDice[rem.node] + 1));
                    }
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 8;
        int[] arr = {3, 22, 5, 8, 11, 26, 20, 29,
                17, 4, 19, 7, 27, 1, 21, 9};
        System.out.println(minThrow(n, arr));
    }
}
