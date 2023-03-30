package ssafyClass;

import java.util.Scanner;

public class KnapsackTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int W = sc.nextInt();

        int[] weights = new int[N + 1];
        int[] profits = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            weights[i] = sc.nextInt();
            profits[i] = sc.nextInt();
        }

        int[][] dp = new int[N+1][W+1];
        // 초깃값 세팅 : int[][]의 자동초기화

        for (int i = 1; i <= N; i++) { // i는 물건
            for (int w = 1; w <= W; w++) { // w : 가방의 무게
                //해당 물건의 무게가 w를 초과하는지
                if (weights[i] >= w) {
                    dp[i][w] = dp[i - 1][w];
                } else {
                    dp[i][w] = Math.max(dp[i - 1][w], profits[i] + dp[i-1][w-weights[i]]);
                }
            }
        }
        System.out.println(dp[N][W]);
    }
}
/*
4 10
5 10
4 40
6 30
3 50형

answer : 90
 */
