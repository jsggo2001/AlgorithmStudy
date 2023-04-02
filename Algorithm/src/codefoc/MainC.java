package codefoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainC {
    static String map;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            br.readLine();

            int result = 0;
            for (int i = 0; i < 8; i++) {
                map = br.readLine();
                if (result == 1) continue;
                if (map.equals("RRRRRRRR")) {
                    sb.append('R' + "\n");
                    result = 1;
                }
            }
            if (result == 0) sb.append('B' + "\n");
        }
        System.out.println(sb);
    }
}