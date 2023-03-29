package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_17069_파이프옮기기2_정승구 {
    static int n;
    static int[][] map;
    static long[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new long[n][n][3];
        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                dp[i][j] = new long[]{0, 0, 0};
            }
        }

        for (int j = 1; j < n; j++) {
            if (map[0][j] == 1) break;
            dp[0][j] = new long[]{1, 0, 0};
        }
        for (int i = 1; i < n; i++) {
            for (int j = 2; j < n; j++) {
                solve(i, j);
            }
        }
        long result = 0;
        for (int i = 0; i < 3; i++) {
            result += dp[n - 1][n - 1][i];
        }
        //print();
        System.out.println(result);
    }

    private static void print() {
        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.deepToString(dp[i]));
        }
    }

    private static void solve(int x, int y) {
        if (map[x][y] == 1) return;
        checkLeft(x, y);
        checkDiag(x, y);
        checkUp(x, y);
    }

    private static void checkLeft(int x, int y) {
        int preX = x;
        int preY = y - 1;
        if (preY < 1) return;
        dp[x][y][0] += dp[preX][preY][0];
        //if(x + 1 < n && map[x + 1][y] != 1)
        dp[x][y][0] += dp[preX][preY][1];
    }

    private static void checkDiag(int x, int y) {
        int preX = x - 1;
        int preY = y - 1;
        if (preY < 1 || preX < 0) return;
        if (x - 1 < 0 || map[x - 1][y] == 1) return;
        if (y - 1 < 1 || map[x][y - 1] == 1) return;
        dp[x][y][1] += dp[preX][preY][1];
        dp[x][y][1] += dp[preX][preY][0];
        dp[x][y][1] += dp[preX][preY][2];
    }

    private static void checkUp(int x, int y) {
        int preX = x - 1;
        int preY = y;
        if (preY < 1 || preX < 0) return;
        dp[x][y][2] += dp[preX][preY][2];
        //if ((y + 1 < n && map[x][y + 1] != 1) || y == n - 1)
        dp[x][y][2] += dp[preX][preY][1];
    }
}
//    private static void solve2(int x, int y) {
//        for (int i = 0; i < 3; i++) {
//            if (i == 0 && dp[x][y][i] > 0) {
//                if(!goRight(x,y, 0, dp[x][y][i])) continue;
//                goDiagnal(x,y, 1, dp[x][y][i]);
//            }
//            if (i == 1 && dp[x][y][i] > 0) {
//                if (y == n - 1) {
//                    goDiagnal(x, y, 1, dp[x][y][i]);
//                    goRight(x, y, 0, dp[x][y][i]);
//                    goDown(x, y, 2, dp[x][y][i]);
//                } else {
//                    if (!goDiagnal(x, y, 1, dp[x][y][i])) continue;
//                    goRight(x, y, 0, dp[x][y][i]);
//                    goDown(x, y, 2, dp[x][y][i]);
//                }
//            }
//            if (i == 2 && dp[x][y][i] > 0) {
//                if(!goDown(x,y,2, dp[x][y][i])) continue;
//                goDiagnal(x,y,1, dp[x][y][i]);
//            }
//        }
 //   }

//    private static boolean goRight(int x, int y, int i, int pre) {
//        int nextX = x;
//        int nextY = y + 1;
//        if (nextY >= n || map[nextX][nextY] == 1) return false;
//        dp[nextX][nextY][i] += pre;
//        return true;
//    }
//
//    private static boolean goDiagnal(int x, int y, int i, int pre) {
//        int nextX = x + 1;
//        int nextY = y + 1;
//        if (nextY >= n || nextX >= n || map[nextX][nextY] == 1) return false;
//        dp[nextX][nextY][i] += pre;
//        return true;
//    }
//    private static boolean goDown(int x, int y, int i, int pre) {
//        int nextX = x + 1;
//        int nextY = y;
//        if (nextX >= n || map[nextX][nextY] == 1) return false;
//        dp[nextX][nextY][i] += pre;
//        return true;
//    }
//}
