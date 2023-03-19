package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_2115_벌꿀채취_정승구 {

    static int n, m, c;
    static int[][] map;
    static List<Point> list;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case < T + 1; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            map = new int [n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n - m + 1; j ++) {
                    list.add(pointCalculate(i, j));
                }
            }
            makeAnswer();
            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static void makeAnswer() {
        answer = 0;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).x == list.get(j).x) {
                    if (list.get(j).y - list.get(i).y >= m) {
                        answer = Math.max(answer, list.get(i).max + list.get(j).max);
                    }
                } else {
                    answer = Math.max(answer, list.get(i).max + list.get(j).max);
                }
            }
        }
    }

    private static Point pointCalculate(int x, int y) {
        int[] nums = new int[m];
        int cnt = 0;
        for (int i = y; i < y + m; i++) {
            nums[cnt] = map[x][i];
            cnt++;
        }
        int max = 0;
        for (int i = 0; i < 1<<(m + 1); i++) {
            int temp = 0;
            int nowHoney = 0;
            for (int j = 0; j < m; j++) {
                if ((i & 1<<j) != 0) {
                    temp += nums[j] * nums[j];
                    nowHoney += nums[j];
                }
            }
            if (nowHoney <= c) {
                max = Math.max(max, temp);
            }
        }
        return new Point(x,y, max);
    }




    static class Point {
        public int x;
        public int y;
        public int max;

        public Point(int x, int y, int max) {
            this.x = x;
            this.y = y;
            this.max = max;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    ", max=" + max +
                    '}';
        }
    }
}

/*
4 2 13
6 1 9 7
9 8 5 8
3 4 5 3
8 2 6 7

174
 */
