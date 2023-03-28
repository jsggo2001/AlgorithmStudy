package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1300_k번째수 {
    static int n,k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());

        int start = 1;
        int end = k;
        int mid = 0;
        while (start < end) {
            mid = (start + end) / 2;

            int temp = check(mid);
            if (temp < k) {
                start = mid + 1;
            } else {
                end = mid;
            }

        }
        System.out.println(start);
    }
    private static int check(int mid) {
        int result = 0;
        for (int i = n; i >= 1; i--) {
            result += Math.min(mid / i, n);
        }
        return result;
    }
}
