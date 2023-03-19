package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution_1767_프로세서연결하기_정승구 {
    static int n, pointNum, answer, answerCore;
    static int[][] map;
    static List<Point> points;
    static int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {0, 0}};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int test_case = 1; test_case < T + 1; test_case++) {
            answer = Integer.MAX_VALUE;
            answerCore = 0;
            points = new ArrayList<>();
            n = Integer.parseInt(br.readLine());
            map = new int[n][n];
            StringTokenizer st;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    int now = Integer.parseInt(st.nextToken());
                    map[i][j] = now;
                    if (now == 1 && i != 0 && i != n - 1 && j != 0 && j != n - 1) {
                        points.add(new Point(i, j));
                    }
                }
            }
            pointNum = points.size();
            solve(0, 0, 0);
            System.out.println("#" + test_case + " " + answer);
        }
    }

    private static void solve(int index, int result, int core) {
        if (index == pointNum) {
            if (core > answerCore) {
                answerCore = core;
                answer = result;
            } else if (core == answerCore) {
                answer = Math.min(answer, result);
            }
            return;
        }

        for (int i = 0; i < 5; i++) {
            int[][] temp = copy();
            int drawCnt = draw(index, i);
            if (drawCnt == -1) {
                map = temp;
                continue;
            }
            if (drawCnt > 0) {
                core++;
                solve(index + 1, result + drawCnt, core);
                core--;
                map = temp;
            } else if (drawCnt == 0) {
                solve(index + 1, result, core);
            }
        }
    }

    private static int draw(int index, int direction) {
        if (direction == 4) return 0;
        int result = 0;
        Point nowPoint = points.get(index);
        int nextX = nowPoint.x;
        int nextY = nowPoint.y;
        while (true) {
            nextX = nextX + directions[direction][0];
            nextY = nextY + directions[direction][1];
            if (nextX < 0 || nextX >= n || nextY < 0 || nextY >= n) break;
            if (map[nextX][nextY] == 1) return -1;
            map[nextX][nextY] = 1;
            result++;
        }
        return result;
    }

    private static void print() {
        for (int[] line : map) {
            System.out.println(Arrays.toString(line));
        }
        System.out.println();
    }

    private static int[][] copy() {
        int[][] result = new int[n][];
        for (int i = 0; i < n; i++) {
            result[i] = map[i].clone();
        }
        return result;
    }

    static class Point {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "Point{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}

/*
7
0 0 1 0 0 0 0
0 0 1 0 0 0 0
0 0 0 0 0 1 0
0 0 0 0 0 0 0
1 1 0 1 0 0 0
0 1 0 0 0 0 0
0 0 0 0 0 0 0

 */