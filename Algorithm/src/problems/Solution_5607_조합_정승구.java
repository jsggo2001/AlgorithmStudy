package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_5607_조합_정승구 {

    static long[] dp;
    static int p = 1234567891;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        makeDp(1000000);
        int T = Integer.parseInt(br.readLine());
        for (int t = 1; t < T + 1; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            System.out.println("#" + t + " " +solve(n,r));
        }
    }

    private static long solve(int n, int r) {
        System.out.println(square(dp[n - r], p - 2) % p);
        long answer = (((dp[n] % p) * (square(dp[n - r], p - 2))) % p) * square(dp[r], p - 2) % p;
        return answer % p;
    }

    private static long square(long i, long x) {
        if (x == 0) {
            return 1L;
        }
        if (x % 2 == 0) {
            long now = square(i, x / 2L) % p;
            return ((now % p) * (now % p)) % p;
        } else {
            long now = square(i, x / 2L) % p ;
            return (((now * now) % p) * i) % p;
        }
    }

    private static void makeDp(int n) {
        dp = new long[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            dp[i] = ((dp[i - 1]) * (i)) % p;
        }
    }
}
