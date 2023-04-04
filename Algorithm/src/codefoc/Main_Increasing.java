package codefoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_Increasing {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());

            int[] list = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                list[i] = Integer.parseInt(st.nextToken());
            }
            if (n == 1) {
                sb.append("YES\n");
                continue;
            }

            Arrays.sort(list);
            boolean result = true;
            for (int i = 1; i < n; i++) {
                if (list[i-1] == list[i]) {
                    result = false;
                    break;
                }
            }

            if (result) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }
}
