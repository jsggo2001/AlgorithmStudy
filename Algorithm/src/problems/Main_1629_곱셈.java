package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1629_곱셈 {
    static long a,b,c;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        System.out.println(solve(b));
        }

    private static long solve(long b) {
        if (b == 1L) {
            return a % c;
        }

        if (b % 2 == 0) {
            long temp = solve(b/2) % c;
            return (temp * temp) % c;
        } else {
            long temp = solve((b-1)/2) % c;
            return (((temp * temp)%c) * a) % c;
        }
    }
}
