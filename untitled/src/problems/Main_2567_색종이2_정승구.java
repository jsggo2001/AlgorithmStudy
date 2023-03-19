package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2567_색종이2_정승구 {
    static int[][] map;
    static int[][] direction = {{1, 0}, {-1, 0}, {0, -1}, {0, 1}};
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            list.add(Arrays.asList(Integer.parseInt(st.nextToken()),
                    Integer.parseInt(st.nextToken())));
        }

        map = new int[102][102];

        for (int i = 0; i < list.size(); i++) {
            int startX = list.get(i).get(1);
            int startY = list.get(i).get(0);

            for (int r = startX; r < startX + 10; r++) {
                for (int c = startY; c < startY + 10; c++) {
                    map[r][c] = 2;
                }
            }
        }
        drawLine();
        //print();
        answer();
        System.out.println(result);


    }

    private static void print() {
        for (int i = 100; i >= 0; i--) {
            for (int j = 0; j < 101; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    private static void answer() {
        for (int i = 0; i < 101; i++) {
            for (int j = 0; j < 101; j++) {
                if (map[i][j] == 1) result++;
            }
        }
    }

    private static void drawLine() {
        for (int i = 0; i < 102; i++) {
            for (int j = 0; j < 102; j++) {
                if (map[i][j] == 2) {
                    fourCheck(i, j);

                }
            }
        }
    }

    private static void fourCheck(int r, int c) {

        for (int i = 0; i < 4; i++) {
            int nowX = r + direction[i][0];
            int nowY = c + direction[i][1];
            if (nowX >= 0 && nowX < 102 && nowY >= 0 && nowY < 102 && map[nowX][nowY] == 0) {
                result++;
            }
        }
    }
}
/*
4
3 7
5 2
15 7
13 14

 */
