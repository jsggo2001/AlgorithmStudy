package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5656_벽돌깨기_정승구 {
    static int n, w, h;
    static int answer;
    static int[][] map;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
//        int T = 1;
        for (int test_case = 1; test_case < T + 1; test_case++) {
            answer = Integer.MAX_VALUE;
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

//            int[][] copy = copyArr();
            solve(0);
            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static void solve(int cnt) {
        if (countResult() == 0) {
            answer = 0;
            return;
        }

        if (cnt == n) {
            answer = Math.min(countResult(), answer);
            return;
        }

        for (int i = 0; i < w; i++) {
            int[][] temp = copyArr();
            if (!heat(i)) continue;
            solve(cnt + 1);
            map = temp;
        }
    }

    private static int countResult() {
        int result = 0;
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j] > 0) result++;
            }
        }
        return result;
    }

    private static boolean heat(int nowTarget) {
        int x = findX(nowTarget);
        Queue<int[]> q = new LinkedList<>();

        if (x == -1) {
            return false;
        }
        q.offer(new int[]{x, nowTarget});
        while (!q.isEmpty()) {
            int[] now = q.poll();

            int nowX = now[0];
            int nowY = now[1];
            int nextCnt = map[nowX][nowY] - 1;
            map[nowX][nowY] = 0;

            if (nextCnt == 0) continue;
            for (int j = 0; j < 4; j++) {
                int nextX = nowX;
                int nextY = nowY;
                for (int i = 0; i < nextCnt; i++) {
                    nextX = nextX + direction[j][0];
                    nextY = nextY + direction[j][1];
                    if (nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && map[nextX][nextY] != 0) {
                        q.offer(new int[]{nextX, nextY});
                    }
                }

            }
        }
        pullDown();
        return true;
    }

    private static void pullDown() {
        for (int j = 0; j < w; j++) {
            int cnt = h - 1;
            for (int i = h - 1; i >= 0; i--) {
                if (map[i][j] > 0) {
                    map[cnt][j] = map[i][j];
                    cnt--;
                }
            }
            for (int i = cnt; i >= 0; i--) {
                map[i][j] = 0;
            }
        }
    }

    private static int findX(int index) {
        for (int i = 0; i < h; i++) {
            if (map[i][index] > 0) {
                return i;
            }
        }
        return -1;
    }


    private static int[][] copyArr() {
        int[][] result = new int[h][];
        for (int i = 0; i < h; i++) {
            result[i] = map[i].clone();
        }
        return result;
    }

    private static void print() {
        for (int i = 0; i < h; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println();
    }
}
