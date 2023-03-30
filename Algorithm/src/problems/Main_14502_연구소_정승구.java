package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14502_연구소_정승구 {
    static int n, m, answer;
    static int[][] board;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        solve(0);
        System.out.println(answer);
    }


    private static void solve(int wall) {
        if (wall == 3) {
            int now = check();
            answer = Math.max(answer, now);
            return;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    int[][] temp = copyBoard();
                    board[i][j] = 1;
                    solve(wall + 1);
                    board = temp;
                }
            }
        }
    }

    private static int[][] copyBoard() {
        int[][] result = new int[n][m];
        for (int i = 0; i < n; i++) {
            result[i] = board[i].clone();
        }
        return result;
    }

    private static int check() {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 2) {
                    spreadV(i, j);
                }
            }
        }
        int result = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 0) {
                    result++;
                }
            }
        }

        return result;
    }

    static void print(int[][] check) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(check[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static void spreadV(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});

        while (!q.isEmpty()) {
            int[] now = q.poll();
            int preX = now[0];
            int preY = now[1];

            for (int i = 0; i < 4; i++) {
                int nx = preX + direction[i][0];
                int ny = preY + direction[i][1];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && board[nx][ny] == 0) {
                    board[nx][ny] = 2;
                    q.offer(new int[]{nx, ny});
                }
            }
        }
    }
}

/*
7 7
2 0 0 0 1 1 0
0 0 1 0 1 2 0
0 1 1 0 1 0 0
0 1 0 0 0 0 0
0 0 0 0 0 1 1
0 1 0 0 0 0 0
0 1 0 0 0 0 0
 */
