package codefoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MainE {
    static int[] stairs, step;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            stairs = new int[n];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                stairs[i] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(br.readLine());
            step = new int[m];
            for (int i = 0; i < m; i++) {
                step[i] = Integer.parseInt(st.nextToken());
            }
            HashMap<Integer, long[]> map = new HashMap<>();
            for (int i = 0; i < m; i++) {
                int val = step[i];
                long[] now = map.get(val);
                long start = 0;
                long sum = 0;
                if (now != null) {
                    start = now[0];
                    sum = now[1];
                }
                int flag = 0;
                for (int j = (int)start; j < n; j++) {
                    if (stairs[j] <= val) {
                        sum += stairs[j];
                    } else {
                        map.put(val, new long[]{j,sum});
                        sb.append(sum + " ");
                        flag = 1;
                        break;
                    }
                }
                if (flag == 0) sb.append(sum + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
