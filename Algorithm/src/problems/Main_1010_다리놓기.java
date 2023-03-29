import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main_1010_다리놓기 {
    static BigInteger[] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        makeFac();
        int c = Integer.parseInt(br.readLine());
        for (int i = 0; i < c; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            BigInteger answer = dp[n].divide(dp[n - m].multiply(dp[m]));
            System.out.println(answer);
        }
    }

    private static void makeFac() {
        dp = new BigInteger[31];
        dp[0] = BigInteger.ONE;
        dp[1] = BigInteger.ONE;
        for(int i = 2; i < 31; i++) {
            dp[i] = dp[i-1].multiply(new BigInteger(String.valueOf(i)));
        }
    }
}
