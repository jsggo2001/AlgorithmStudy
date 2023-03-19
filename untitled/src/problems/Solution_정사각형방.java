package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Solution_정사각형방 {
    static int[][] map;
    static boolean[][] visited;
    static int n, result, answer, answercount, startnowx, startnowy;
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String args[]) throws Exception {
        Long start = System.nanoTime();
        int T;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            result = 0;
            answercount = 0;
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];

            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    visited = new boolean[n][n];
                    visited[i][j] = true;
                    startnowx = i;
                    startnowy = j;
                    dfs(i, j, 1);
                }
            }
            System.out.println("#" + test_case + " " + answer + " " + answercount);
            System.out.println((System.nanoTime() - start)/1000000000.0);
        }
    }

    private static void dfs(int i, int j, int cnt) {
        if (!check(i, j)) {
            if (cnt > result) {
                result = cnt;
                answer = map[startnowx][startnowy];
                answercount = cnt;
                return;
            } else if (cnt == result && map[startnowx][startnowy] < answer) {
                answer = map[startnowx][startnowy];
                return;
            }
        }
        for (int z = 0; z < 4; z++) {
            int nowx = i + dx[z];
            int nowy = j + dy[z];
            if (nowx >= 0 && nowx < n && nowy >= 0 && nowy < n) {
                if (map[i][j] - map[nowx][nowy] == -1) {
                    if (visited[nowx][nowy] == false) {
                        visited[nowx][nowy] = true;
                        dfs(nowx, nowy, cnt + 1);
                    }
                }
            }
        }
    }

    public static boolean check(int i, int j) {
        for (int z = 0; z < 4; z++) {
            int nowx = i + dx[z];
            int nowy = j + dy[z];
            if (nowx >= 0 && nowx < n && nowy >= 0 && nowy < n) {
                if (map[i][j] - map[nowx][nowy] == -1) {
                    return true;
                }
            }
        }
        return false;
    }

}
