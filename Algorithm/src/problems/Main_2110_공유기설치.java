package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_2110_공유기설치 {
    static int n, c;
    static long[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        list = new long[n];
        for (int i = 0; i < n; i++) {
            list[i] = Long.parseLong(br.readLine());
        }
        Arrays.sort(list);
        long start = 0;
        long end = list[n - 1];
        long mid;
        while(start <= end) {
            mid = (start + end)/2;
            if (check(mid) < c) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        System.out.println(start - 1);
    }
    private static int check(long mid) {
        int result = 1;
        long nowCheck = list[0] + mid;
        for (int i = 1; i < n; i++) {
            if (list[i] >= nowCheck) {
                result++;
                nowCheck = list[i] + mid;
            }
        }
        return result;
    }
}
