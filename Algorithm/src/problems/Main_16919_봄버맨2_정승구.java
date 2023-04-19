package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_16919_봄버맨2_정승구 {
    static int R, C, N;
    static char[][] firstMap;
    static char[][] secondMap;
    static char[][] thirdMap;
    static StringBuilder sb = new StringBuilder();
    static int[][] direction = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        firstMap = new char[R][C];
        for (int i = 0; i < R; i++) {
            firstMap[i] = br.readLine().toCharArray();
        }
        secondMap = makeNext(firstMap);
        thirdMap = makeNext(secondMap);

        if (N == 1) {
            print(firstMap);
            return;
        }

        if (N % 2 == 0) {
            char[][] full = new char[R][C];
            for (int i = 0; i < R; i++) {
                Arrays.fill(full[i], 'O');
            }
            print(full);
        } else {
            if (N % 4 == 1) print(thirdMap);
            else print(secondMap);
        }

    }

    private static char[][] makeNext(char[][] map) {
        char[][] nextMap = new char[R][C];
        for (int i = 0; i < R; i++) {
            Arrays.fill(nextMap[i], 'O');
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 'O') {
                    boom(i, j, nextMap);
                }
            }
        }
        return nextMap;
    }

    private static void boom(int i, int j, char[][] map) {
        map[i][j] = '.';
        for (int k = 0; k < 4; k++) {
            int nx = i + direction[k][0];
            int ny = j + direction[k][1];

            if (nx >= 0 && nx < R && ny >= 0 && ny < C) {
                map[nx][ny] = '.';
            }
        }
    }

    private static void print(char[][] map) {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(map[i][j]);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
