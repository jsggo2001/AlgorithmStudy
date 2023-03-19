package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.function.BiPredicate;

public class Solution_1873_상호의배틀필드_정승구 {
    static String[][] map;
    static int h,w,n;
    static String order;
    static List<Integer> now;
    static StringBuilder sb = new StringBuilder();
    public enum Direction {
        UP(-1,0, "^"),
        DOWN(1,0, "v"),
        LEFT(0,-1, "<"),
        RIGHT(0,1, ">");
        private final int x, y;
        private final String symbol;
        Direction(int x,int y,String symbol) {
            this.x = x;
            this.y = y;
            this.symbol = symbol;
        }
        public int x() {return x;}
        public int y() {return y;}
    }
    static Direction nowDirection;
    static BiPredicate<Integer, Integer> OutCheck = (x, y) ->
            x >= 0 && x < h && y >= 0 && y < w;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case < T + 1; test_case++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());
            map = new String[h][w];

            for (int i = 0; i < h; i++) {
                map[i] = br.readLine().split("");
            }

            n = Integer.parseInt(br.readLine());
            order = br.readLine();

            findTank();

            for (int i = 0; i < n; i++) {
                excute(order.charAt(i));
            }

            sb.append("#" + test_case + " ");
            for (int i = 0; i < h; i++) {
                for (int j = 0; j < w; j++) {
                    sb.append(map[i][j]);
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void excute(char order) {
        if (order == 'U') {
            nowDirection = Direction.UP;
            move();
        } else if (order == 'D') {
            nowDirection = Direction.DOWN;
            move();
        } else if (order == 'L') {
            nowDirection = Direction.LEFT;
            move();
        } else if (order == 'R') {
            nowDirection = Direction.RIGHT;
            move();
        } else {
            shoot();
        }
    }

    private static void shoot() {
        int x = now.get(0);
        int y = now.get(1);
        while (true) {
            int nowX = x + nowDirection.x;
            int nowY = y + nowDirection.y;
            if (!OutCheck.test(nowX,nowY)) break;
            if (map[nowX][nowY].equals("#")) break;
            if (map[nowX][nowY].equals("*")) {
                map[nowX][nowY] = ".";
                break;
            }
            x = nowX;
            y = nowY;
        }
    }

    private static void move() {
        int nowX = now.get(0) + nowDirection.x;
        int nowY = now.get(1) + nowDirection.y;
        map[now.get(0)][now.get(1)] = nowDirection.symbol;
        if (OutCheck.test(nowX,nowY) && map[nowX][nowY].equals(".")) {
            map[now.get(0)][now.get(1)] = ".";
            now.add(0,nowX);
            now.add(1,nowY);
            map[nowX][nowY] = nowDirection.symbol;
        }
    }

    private static void findTank() {
        now = new ArrayList<>();
        for (int i = 0; i < h; i++) {
            for (int j = 0; j < w; j++) {
                if (map[i][j].equals("^")) {
                    nowDirection = Direction.UP;
                    now.add(i);
                    now.add(j);
                } else if (map[i][j].equals("v")) {
                    nowDirection = Direction.DOWN;
                    now.add(i);
                    now.add(j);
                } else if (map[i][j].equals("<")) {
                    nowDirection = Direction.LEFT;
                    now.add(i);
                    now.add(j);
                } else if (map[i][j].equals(">")) {
                    nowDirection = Direction.RIGHT;
                    now.add(i);
                    now.add(j);
                }
            }
        }
    }
}
