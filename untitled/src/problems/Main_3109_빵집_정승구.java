package problems;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_3109_빵집_정승구 {
    static int[] dx = {-1, 0, 1};
    static int[] dy = {1, 1, 1};
    static int r;
    static int c;
    static int result;
    static boolean[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] rc = br.readLine().split(" ");
        r = Integer.parseInt(rc[0]);
        c = Integer.parseInt(rc[1]);
        map = new boolean[r][c];
        result = 0;

        // 입력
        for (int i = 0; i < r; i++) {
            String temp = br.readLine();
            for (int j = 0; j < c; j++) {
                if (temp.charAt(j) == '.') {
                    map[i][j] = true;
                } else {
                    map[i][j] = false;
                }
            }
        }
        for (int i = 0; i < r; i++) {
            solution(1, i, 0, map);
        }
        System.out.println(result);
    }

    private static int solution(int cnt, int x, int y, boolean[][] tempMap) {
        if (y == c - 1) {
            result++;
            map = tempMap;
            return 0;
        }
        for (int i = 0; i < 3; i++) {
            int nowx = x + dx[i];
            int nowy = y + dy[i];
            if (nowx >= 0 && nowx < r && nowy >= 0 && nowy < c && map[nowx][nowy] == true) {
                boolean[][] passMap = tempMap;
                passMap[nowx][nowy] = false;
                cnt = solution(cnt, nowx, nowy, passMap);
                if (cnt == 0) {
                    return 0;
                }
                //tempMap = map;
            }
        }
        return cnt;
    }
}
