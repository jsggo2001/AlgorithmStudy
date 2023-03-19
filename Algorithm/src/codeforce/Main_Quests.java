package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Quests {
    static int n,d;
    static long c;
    static Long[] list;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 0; test_case < T; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            c = Long.parseLong(st.nextToken());
            d = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());

            list = new Long[n];
            for (int i = 0; i < n; i++) {
                list[i] = Long.parseLong(st.nextToken());
            }

            Arrays.sort(list, (a,b) -> b.compareTo(a));

            int l = 0, r = d + 2;

            while (l < r) {
                int mid = l + (r - l + 1) / 2;
                long total = 0;
                for (int i = 0; i < d; i++) {
                    if (i % mid < n) total += list[i % mid];
                }
                if (total >= c) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            if (l == d + 2) {
                sb.append("Infinity\n");
            } else if (l == 0) {
                sb.append("Impossible\n");
            } else {
                sb.append(l - 1 + "\n");
            }
        }
        System.out.println(sb);
    }
}
