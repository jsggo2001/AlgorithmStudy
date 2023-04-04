package codefoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_Scuza {
    static int[]  step;
    static long[] stairs;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            stairs = new long[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                stairs[i] = Long.parseLong(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            step = new int[m];
            for (int i = 0; i < m; i++) {
                step[i] = Integer.parseInt(st.nextToken());
            }

            long[] sum = new long[n + 1];
            long temp = 0;
            long sumTemp = 0;
            for (int i = 0; i < n; i++) {
                sum[i + 1] = sumTemp + stairs[i];
                sumTemp = sum[i + 1];
                if (temp <= stairs[i]) {
                    temp = stairs[i];
                } else {
                    stairs[i] = temp;
                }
            }
            for (int i = 0; i < m; i++) {
                int targetIndex = findTarget(step[i], n);
                sb.append(sum[targetIndex] + " ");
                if (i == m - 1) {
                    sb.append("\n");
                }
            }
        }
        System.out.print(sb);
    }

    private static int findTarget(int target, int n) {
        int start = 0;
        int end = n;
        int mid;
        while (start < end) {
            mid = (start + end) / 2;
            if (stairs[mid] > target) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

}
