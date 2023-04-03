package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution_1263_사람네트워크2_정승구 {
    static int[][] map;
    static int result;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case < T + 1; test_case++) {
            result = 100000;
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int num = Integer.parseInt(st.nextToken());;
                    if (num == 0) {
                        map[i][j] = 10000;
                    } else {
                        map[i][j] = num;
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                map[i][i] = 0;
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                    }
                }
            }

            for (int i = 0; i < n; i++) {
                int temp = 0;
                for (int j = 0; j < n; j++) {
                    temp += map[i][j];
                }
                result = Math.min(temp, result);
            }
            sb.append("#" +test_case+" " + result+"\n");
        }
        System.out.println(sb);
    }
}
