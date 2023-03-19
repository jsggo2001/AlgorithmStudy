package ssafyClass.dfs;

import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class AdjMatrixTest {

    static int[][] adjMatrix;
    static int V;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        V = sc.nextInt();
        int E = sc.nextInt();

        adjMatrix = new int[V][V]; //모두 0으로 초기화된 상태

        StringTokenizer st = null;
        int from, to;
        for (int i = 0; i < E; ++i) {
            from = sc.nextInt(); //from 정점
            to = sc.nextInt(); //to 정점

            adjMatrix[to][from] = adjMatrix[from][to] = 1;
            //무향 그래프 : 대칭을 시켜서 동시에 값을 넣어준다.

        }
        dfs(0, new boolean[V]);
    }

    private static void dfs(int current, boolean[] visitied) { // current : 탐색 정점
        visitied[current] = true;
        System.out.println((char) (current + 65));

        for (int i = 0; i < V; i++) {
            if (adjMatrix[current][i] != 0 && !visitied[i]) {
                dfs(i, visitied);
            }
        }
    }

    static void print() {
        for (int[] am : adjMatrix) {
            System.out.println(Arrays.toString(am));
        }
    }
}

/*
7
8
0 1
0 2
1 3
1 4
2 4
3 5
4 5
5 6
 */
