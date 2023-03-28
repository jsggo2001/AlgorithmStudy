package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1463_1로만들기 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] d = new int[n + 1];
        d[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            int now = d[i - 1] + 1;
            if (i % 2 == 0) {
                now = Math.min(now, d[i/2] + 1);
            }
            if (i % 3 == 0) {
                now = Math.min(now, d[i/3] + 1);
            }
            d[i] = now;
        }
        System.out.println(d[n]);
    }
}
