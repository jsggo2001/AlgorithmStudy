package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600_말이되고픈원숭이_정승구 {
    static int k, w, h;
    static int[][] board;
    static boolean[][][] visited;
    static Queue<int[]> q;
    static int min = Integer.MAX_VALUE;
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {-1, -2}, {-2, -1}, {-2, 1},
            {-1, 2}, {1, 2}, {2, 1}, {2, -1}, {1, -2}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        w = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        board = new int[h][w];
        visited = new boolean[h][w][k + 1];
        for (int i = 0; i < h; i++) Arrays.fill(board[i], Integer.MAX_VALUE);
        for (int i = 0; i < h; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < w; j++) {
                int temp = Integer.parseInt(st.nextToken());
                board[i][j] = temp;
            }
        }
        board[0][0] = 0;

        min = bfs();

        if (min == Integer.MAX_VALUE) System.out.println("-1");
        else System.out.println(min);
    }

    private static int bfs() {
        q = new ArrayDeque<>();
        q.offer(new int[]{0, 0, 0, 0});
        visited[0][0][0] = true;

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            int jump = now[3];
            if (x == h - 1 && y == w - 1) {
                return cnt;
            }
            for (int i = 0; i <= 3; i++) {
                int nextX = x + direction[i][0];
                int nextY = y + direction[i][1];
                int nextCnt = cnt + 1;
                if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w || board[nextX][nextY] != 0) continue;
                if (visited[nextX][nextY][jump]) continue;
                int nextVal = nextCnt;
                visited[nextX][nextY][jump] = true;
                q.offer(new int[]{nextX, nextY, nextVal, jump});
            }
            if (jump < k) {
                for (int i = 4; i < 12; i++) {
                    int nextX = x + direction[i][0];
                    int nextY = y + direction[i][1];
                    int nextCnt = cnt + 1;
                    if (nextX < 0 || nextX >= h || nextY < 0 || nextY >= w || board[nextX][nextY] != 0) continue;
                    if (visited[nextX][nextY][jump + 1]) continue;
                    int nextVal = nextCnt;
                    visited[nextX][nextY][jump + 1] = true;
                    q.offer(new int[]{nextX, nextY, nextVal, jump + 1});
                }
            }
        }
        return min;
    }
}
