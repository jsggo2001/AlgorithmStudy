package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_7579_앱_정승구 {
    static int n, m;
    static int[] activate, memory;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        activate = new int[n];
        memory = new int[n];
        dp = new int[n + 1][10001];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int sum = 0;
        for (int i = 0; i < n; i++) {
            memory[i] = Integer.parseInt(st1.nextToken());
            activate[i] = Integer.parseInt(st2.nextToken());
            sum += activate[i];
        }


        for (int i = 1; i < n + 1; i++) {
            int val = memory[i - 1];
            int cost = activate[i - 1];
            for (int j = 1; j < sum + 1; j++) {
                if (j < cost) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - cost] + val);
                }
            }
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (dp[i][j] >= m) {
                    answer = Math.min(answer, j);
                }
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        System.out.println(answer);
    }
}
