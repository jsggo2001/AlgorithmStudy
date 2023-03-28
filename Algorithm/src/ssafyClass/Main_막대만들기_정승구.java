package ssafyClass;

import java.util.Scanner;

public class Main_막대만들기_정승구 {
    static int[] dp;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();
        dp = new int[n + 1];
        dp[1] = 2;
        dp[2] = 5;
        for (int i = 3; i < n + 1; i++) {
            dp[i] = dp[i - 1] * 2 + dp[i - 2];
        }
        System.out.println(dp[n]);
    }
}
