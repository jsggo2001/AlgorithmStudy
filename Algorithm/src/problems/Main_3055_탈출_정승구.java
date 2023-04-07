package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_3055_탈출_정승구 {

    static int r, c, result;
    static char[][] map;
    static Queue<int[]> waters;
    static Queue<int[]> beavers;
    static int[][] waterMap;
    static int[][] beaverMap;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][];
        waterMap = new int[r][c];
        waters = new LinkedList<>();
        beavers = new LinkedList<>();
        beaverMap = new int[r][c];


        for (int i = 0; i < r; i++) {
            map[i] = br.readLine().toCharArray();
            for (int j = 0; j < c; j++) {
                if (map[i][j] == '*') {
                    waters.offer(new int[]{i,j});
                    //waterMap[i][j] = -1;
                }
                if (map[i][j] == 'S') {
                    beavers.add(new int[]{i,j});
                }
            }
        }
        makeWaters();
//        System.out.println(Arrays.deepToString(waterMap));
        moveBeaver();
//        System.out.println(Arrays.deepToString(beaverMap));
        if (result == 0) System.out.println("KAKTUS");
        else System.out.println(result);
    }

    private static void moveBeaver() {
        while(!beavers.isEmpty()) {
            int[] now = beavers.poll();
            int x = now[0];
            int y = now[1];
            int time = beaverMap[x][y];
            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                int nextTime = time + 1;
                if (map[nx][ny] == 'D') {
                    result = nextTime;
                    return;
                }
                if (map[nx][ny] == 'X' || map[nx][ny] == '*' || beaverMap[nx][ny] != 0) continue;
                if (waterMap[nx][ny] == 0 || waterMap[nx][ny] > nextTime) {
                    beaverMap[nx][ny] = nextTime;
                    beavers.offer(new int[]{nx, ny});
                }
            }
        }

    }

    static int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    private static void makeWaters() {
        while(!waters.isEmpty()) {
            int[] now = waters.poll();
            int x = now[0];
            int y = now[1];
            int time = waterMap[x][y];
            for (int i = 0; i < 4; i++) {
                int nx = x + directions[i][0];
                int ny = y + directions[i][1];

                if (nx < 0 || nx >= r || ny < 0 || ny >= c) continue;
                if (map[nx][ny] == 'X' || map[nx][ny] != '.' || waterMap[nx][ny] != 0) continue;
                waterMap[nx][ny] = time + 1;
                waters.offer(new int[]{nx,ny});
            }
        }
    }
}
