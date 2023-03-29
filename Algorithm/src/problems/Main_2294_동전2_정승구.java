package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2294_동전2_정승구 {
    static int n, k;
    static int[] dp;
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        dp = new int[k+1];
        list = new int[n];
        Arrays.fill(dp,10001);
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num < k + 1) {
            dp[num] = 1;
            list[i] = num;
            }
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                int preNum = i - list[j];
                if (preNum >= 0) {
                    dp[i] = Math.min(dp[i], dp[preNum] + 1);
                }
            }
        }
        if (dp[k] == 10001) {
            System.out.println(-1);
            return;
        }

        System.out.println(dp[k]);
    }
}
