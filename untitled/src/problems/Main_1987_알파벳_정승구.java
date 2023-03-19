package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1987_알파벳_정승구 {
    static int r, c;
    static char[][] map;
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    static boolean[] visited = new boolean[300];
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        map = new char[r][];

        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
        }
        visited[map[0][0]] = true;
        solve(0,0,1);

        System.out.println(result);
    }

    private static void solve(int x, int y, int cnt) {
        result = Math.max(cnt, result);

        for (int i = 0; i < 4; i++) {
            int nowx = x + direction[i][0];
            int nowy = y + direction[i][1];
            if (nowx >= 0 && nowx < r && nowy >= 0 && nowy < c) {
                if (visited[map[nowx][nowy]] != true) {
                    visited[map[nowx][nowy]] = true;
                    solve(nowx, nowy, cnt + 1);
                    visited[map[nowx][nowy]] = false;
                }
            }
        }
    }
}
