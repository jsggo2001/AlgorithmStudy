package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_16926_배열돌리기_정승구 {
    static int r;
    static String[][] map;
    static String[][] result;
    static int[] dx;
    static int[] dy;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nmr = br.readLine().split(" ");
        int n = Integer.parseInt(nmr[0]);
        int m = Integer.parseInt(nmr[1]);
        r = Integer.parseInt(nmr[2]);

        map = new String[n][m];

        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().split(" ");
        }
        List<List<Integer>> points = makePoint(n, m);

        result = new String[n][m];

        dx = new int[]{1, 0, -1, 0};
        dy = new int[]{0, 1, 0, -1};

        for (int i = 0; i < Math.min(m, n) / 2; i++) {
            int startx = points.get(i * 4).get(0);
            int starty = points.get(i * 4).get(1);
            int nowx = startx;
            int nowy = starty;
            int direction = 0;
            int endx = points.get((i + 1) * 4 - 2).get(0);
            int endy = points.get((i + 1) * 4 - 2).get(1);
            int oneCycle = (endx - startx) * 2 + (endy - starty) * 2;
            int addVal = r % oneCycle;
            Deque<String> q = new ArrayDeque<>();
            do {
                q.add(map[nowx][nowy]);
                nowx += dx[direction];
                nowy += dy[direction];
                if (nowx < startx || nowx > endx || nowy < starty || nowy > endy) {
                    nowx -= dx[direction];
                    nowy -= dy[direction];
                    direction = (direction + 1) % 4;
                    nowx += dx[direction];
                    nowy += dy[direction];
                }
            } while (!(startx == nowx && starty == nowy));

            for (int z = 0; z < addVal; z++) {
                q.addFirst(q.removeLast());
            }
            do {
                String data = q.poll();
                result[nowx][nowy] = data;
                nowx += dx[direction];
                nowy += dy[direction];
                if (nowx < startx || nowx > endx || nowy < starty || nowy > endy) {
                    nowx -= dx[direction];
                    nowy -= dy[direction];
                    direction = (direction + 1) % 4;
                    nowx += dx[direction];
                    nowy += dy[direction];
                }
            } while (!(startx == nowx && starty == nowy));
        }
        for (String[] line : result) {
            for (String val : line) {
                sb.append(val + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }


    public static List<List<Integer>> makePoint(int n, int m) {
        List<List<Integer>> points = new ArrayList<>();
        points.add(Arrays.asList(0, 0));
        points.add(Arrays.asList(n - 1, 0));
        points.add(Arrays.asList(n - 1, m - 1));
        points.add(Arrays.asList(0, m - 1));

        List<List<Integer>> addPoint = new ArrayList<>();
        addPoint.add(Arrays.asList(1, 1));
        addPoint.add(Arrays.asList(-1, 1));
        addPoint.add(Arrays.asList(-1, -1));
        addPoint.add(Arrays.asList(1, -1));

        for (int i = 0; i < Math.min(n, m) / 2 - 1; i++) {
            int count = 0;
            for (int j = 0 + (i * 4); j <= ((i + 1) * 4) - 1; j++) {
                points.add(Arrays.asList(points.get(j).get(0) + addPoint.get(count).get(0)
                        , points.get(j).get(1) + addPoint.get(count).get(1)));
                count++;
            }
        }
        return points;
    }
}
