package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1194_달이차오른다가자_정승구 {

    static int n, m, answer = -1;
    static char[][] board;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static boolean[][][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m][200];

        board = new char[n][];

        for (int i = 0; i < n; i++) {
            board[i] = br.readLine().toCharArray();
        }

        solve();

        System.out.println(answer);
    }

    private static void solve() {

        int[] start = findStart();
        visited[start[0]][start[1]][start[3]] = true;
        Queue<int[]> q = new LinkedList<>();
        q.offer(start);

        while (!q.isEmpty()) {

            int[] now = q.poll();
            int x = now[0];
            int y = now[1];
            int cnt = now[2];
            int keys = now[3];

            if (board[x][y] == '1') {
                answer = cnt;
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = x + direction[d][0];
                int ny = y + direction[d][1];

                if (nx < 0 || nx >= n || ny < 0 || ny >= m) continue;
                if (board[nx][ny] == '#') continue;
                if (visited[nx][ny][keys]) continue;

                int[] nextNode = parsePosition(nx, ny, cnt, keys);
                if (nextNode[0] == -1) {
                    continue;
                } else {
                    visited[nextNode[0]][nextNode[1]][nextNode[3]] = true;
                    q.offer(nextNode);
                }
            }
        }
    }

    private static int[] parsePosition(int nx, int ny, int cnt, int keys) {
        Character nowValue = board[nx][ny];
        if (nowValue == '1' || nowValue == '.' || nowValue == '0') {
            return new int[]{nx, ny, cnt + 1, keys};
        }

        if (Character.isUpperCase(nowValue)) {
            int bit = (nowValue - 'A' + 1);
            if ((keys & 1 << bit) > 0) {
                return new int[]{nx, ny, cnt + 1, keys};
            } else {
                return new int[]{-1, ny, cnt + 1, keys};
            }
        }

        if (Character.isLowerCase(nowValue)) {
            int bit = nowValue - 'a' + 1;
            int nextKeys = keys | 1 << bit;
            return new int[]{nx, ny, cnt + 1, nextKeys};
        }
        return null;
    }

    private static int[] findStart() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == '0') {
                    return new int[]{i, j, 0, 0};
                }
            }
        }
        return null;
    }
}
