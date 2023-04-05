import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution_5643_키순서_정승구 {
    static int n, m, answer;
    static int[][] map;
    static final int MAX = 100000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t < T + 1; t++) {

            n = Integer.parseInt(br.readLine());
            m = Integer.parseInt(br.readLine());
            map = new int[n + 1][n + 1];
            answer = 0;

            for (int i = 0; i < n + 1; i++) {
                Arrays.fill(map[i], MAX);
            }
            StringTokenizer st;
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int from = Integer.parseInt(st.nextToken());
                int to = Integer.parseInt(st.nextToken());
                map[from][to] = 1;
            }


            for (int i = 1; i < n + 1; i++) {
                for (int j = 1; j < n + 1; j++) {
                    if (i == j) continue;
                    for (int k = 1; k < n + 1; k++) {
                        if (k == j && k == i) continue;
                        map[j][k] = Math.min(map[j][k], map[j][i] + map[i][k]);
                    }
                }
            }
            check();
            System.out.println("#"+t+" "+answer);
        }
    }

    private static void check() {
        for (int i = 1; i < n + 1; i++) {
            int temp = 0;
            for (int j = 1; j < n + 1; j++) {
                if (map[i][j] > 0 && map[i][j] < MAX) temp++;
                if (map[j][i] > 0 && map[j][i] < MAX) temp++;
            }
            if (temp == n - 1) answer++;
        }
    }
}
