package codeforce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_Challenging_Valleys {
    static int[] list;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int direction = 0;
            int pre = Integer.parseInt(st.nextToken());
            int now = 0;
            boolean result = true;
            for (int i = 1;i < n; i++) {
                now = Integer.parseInt(st.nextToken());
                if (now == pre) {
                    pre = now;
                } else if (now > pre) {
                    direction = 1;
                    pre = now;
                } else if (now < pre && direction == 0) {
                    pre = now;
                } else if (now < pre && direction == 1) {
                    result = false;
                    break;
                }
            }
            if (result) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
