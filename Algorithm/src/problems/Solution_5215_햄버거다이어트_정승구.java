package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5215_햄버거다이어트_정승구 {

    static int n,l;
    static int[][] list;
    static int[][] dp;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case < T + 1; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            l = Integer.parseInt(st.nextToken());
            list = new int[n][];
            dp = new int[n + 1][l + 1];

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int score = Integer.parseInt(st.nextToken());
                int cal = Integer.parseInt(st.nextToken());
                list[i] = new int[]{score,cal};
            }
            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < l + 1; j++) {
                    int value = list[i - 1][0];
                    int cal = list[i - 1][1];
                    if (j < cal) {
                        dp[i][j] = dp[i - 1][j];
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cal] + value);
                    }
                }
            }
            System.out.println("#" + test_case + " " + dp[n][l]);
        }

    }
}
