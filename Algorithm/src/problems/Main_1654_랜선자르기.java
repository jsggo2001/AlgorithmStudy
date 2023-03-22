package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1654_랜선자르기 {
    static int k, n;
    static long[] list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        k = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        list = new long[k];
        for (int i = 0; i < k; i++) {
            list[i] = Long.parseLong(br.readLine());
        }

        long start = 0;
        long end = Arrays.stream(list).max().getAsLong();
        long mid;
        while (start <= end) {
            mid = (start + end) / 2;
            if (check(mid) >= n) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        System.out.println(start - 1);
    }

    private static long check(long mid) {
        long result = 0;
        if (mid == 0) {
            for (int i = 0; i < k; i++) {
                result += list[i];
            }
            return result;
        }

        for (int i = 0; i < k; i++) {
            result += list[i] / mid;
        }

        return result;
    }
}
